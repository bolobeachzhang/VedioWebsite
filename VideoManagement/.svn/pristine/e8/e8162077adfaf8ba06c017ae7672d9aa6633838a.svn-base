package com.videoManagement.longThread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.videoManagement.bean.FlashVedio;

public class Ttest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFlashVedios();
	}

	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static List<FlashVedio> getFlashVedios() {
		List<FlashVedio> list = new ArrayList<FlashVedio>();
		System.out.println("BBBBBBBBBBBBBBBBBBBBB");
		try {
			conn = new DB().getConn();
			String sql = "select DISTINCT id,pageUrl from resources,flashVedio where origin = 1 and pageUrl is not null and resourcesType = 1 and transcoding is null";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println( rs.getString("id"));
				System.out.println( rs.getString("pageUrl"));
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
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

		return list;

	}
}
