package com.videoManagement.longThread;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.videoManagement.basicDao.BasicServiceImp;
import com.videoManagement.bean.Images;
import com.videoManagement.serviceImp.Ximages;
public class daoImp {

	private final static String FFMPEG_PATH = "ffmpeg" + "/ffmpeg.exe";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public void getFlashVedios() {
		int exeCount = 0;
		try {
			conn = new DB().getConn();
			String sql = "select DISTINCT id,pageUrl from resources,flashVedio where origin=1 and resourcesType = 1 and transcoding is null";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				exeCount++;
				String oldPath = rs.getString("pageUrl");
				if (oldPath != null && oldPath != "") {//判断查询出来的数据是否转码
					String newPath = oldPath.substring(0,
							oldPath.lastIndexOf("."))
							+ ".flv";
					String exePath = newPath.substring(0,
							newPath.lastIndexOf("/"));
					exePath = exePath.substring(0, exePath.lastIndexOf("\\"));
					//生成应用程序路径
					exePath = exePath + "\\" + FFMPEG_PATH;
					Ximages ximages = new Ximages();
					if(exeCount>100){
						//进程数超过50个，休息10分钟
						 Thread.sleep(60*1000*10); 
						 exeCount = 0;
					}
					//对视频转码
					Boolean boolean1 = false;
					if((new File(oldPath)).isFile()){
						boolean1 = ximages.processFLV(oldPath, newPath, exePath);
					}
				
					if(boolean1){
						String newUrl = "flashResources/"
								+ newPath.substring(newPath.lastIndexOf("/"));
						String newSql = "update resources set url=? where id=?";
						ps = conn.prepareStatement(newSql);
						ps.setString(1, newUrl);
						ps.setInt(2, rs.getInt("id"));
						ps.executeUpdate();
						String Sql = "update flashVedio set transcoding=? where flashVedio_id = ?";
						ps = conn.prepareStatement(Sql);
						//将transcoding设置为2表示已经进行转码
						ps.setInt(1, 1);
						ps.setInt(2, rs.getInt("id"));
						ps.executeUpdate();
					}
					
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.close();
		}
		
	}


	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	//处理已经转码的视频，更新数据库数据
	public void delOldFlash(){
		try {
			conn = new DB().getConn();
			String sql = "select DISTINCT id,pageUrl from resources,flashVedio where origin=1 and resourcesType = 1 and transcoding = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String oldPath = rs.getString("pageUrl");
				File file = new File(oldPath);
				if(file.isFile()){
					file.delete();
				}
				String 	sql1 = "update flashVedio set transcoding=? where id=?";
				ps = conn.prepareStatement(sql1);
				//将transcoding设置为2表示已经清除转码前的文件
				ps.setInt(1, 2);
				ps.setInt(2, id);
				ps.executeUpdate();
			}
				
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.close();
		}
		
	}
	
	//处理视频和图片已经不存在的数据库数据
	public void deelNoFlashSql(){
		try {
			conn = new DB().getConn();
			String sql = "select DISTINCT id,pageUrl from resources,flashVedio where origin=1  and resourcesType = 1 and audit = 1 ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String oldPath = rs.getString("pageUrl");
				File file = new File(oldPath);
				if(!file.isFile()){
					sql = "delete from flashVedio where flashVedio_id ="+id;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					sql = "delete from resources where id ="+id;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.close();
		}
	}
	
	//处理视频和图片已经不存在的数据库数据
	public void deelNoImagesSql(){
		try {
			conn = new DB().getConn();
			String sql = "select * from resources where origin=1  and resourcesType = 0 and audit = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
			int id = rs.getInt("id");
				String oldPath = rs.getString("pageUrl");
				File file = new File(oldPath);
				if(!file.isFile()){
					sql = "delete from images where images.images_id  ="+id;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
					sql = "delete from resources where id ="+id;
					ps = conn.prepareStatement(sql);
					ps.executeUpdate();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			this.close();
		}
	}
	}
