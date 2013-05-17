package com.videoManagement.serviceImp;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;

public class Ximages {
	public static void processImg(String path, String exePath) {
		File file = new File(path);

		if (!file.exists()) {
			System.err.println("路径[" + path + "]对应的视频文件不存在!");
		}
		List<String> commands = new java.util.ArrayList<String>();
		commands.add(exePath);
		commands.add("-i");
		commands.add(path);
		commands.add("-y");
		commands.add("-f");
		commands.add("image2");
		commands.add("-ss");
		commands.add("38");
		commands.add("-t");
		commands.add("0.001");
		commands.add("-s");
		commands.add("320x240");
		commands.add(path.substring(0, path.lastIndexOf(".")) + ".jpg");
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkfile(String path) {
		File file = new File(path);
		if (!file.isFile()) {
			return false;
		}
		return true;
	}

	// ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	public boolean processFLV(String oldPath, String newPath, String exePath) {

		String ratio = null;// 文件分辨率
		String flashTime = null;// 视频时长
		File source = new File(oldPath);
		Encoder encoder = new Encoder();
		try {
			MultimediaInfo m = encoder.getInfo(source);
			long ls = m.getDuration();
			int height = m.getVideo().getSize().getHeight();
			int width = m.getVideo().getSize().getWidth();
			ratio = width + "x" + height;
			flashTime = ls / 60000 + "分" + (ls - (ls / 60000) * 60000) / 1000
					+ "秒！";
		} catch (Exception e) {
			e.printStackTrace();
		}
		// oldPath需要转码的文件的路径ffmpegPath工具路径
		if (!checkfile(oldPath)) {
			System.out.println(oldPath + " is not file");
			return false;
		}
		// 文件命名
		Calendar c = Calendar.getInstance();
		String savename = String.valueOf(c.getTimeInMillis())
				+ Math.round(Math.random() * 100000);
		List<String> commend = new ArrayList<String>();
		commend.add(exePath);
		commend.add("-i");
		commend.add(oldPath);
		commend.add("-ab");
		commend.add("56");
		commend.add("-ar");
		commend.add("22050");
		commend.add("-qscale");
		commend.add("8");
		commend.add("-r");
		commend.add("15");
		commend.add("-s");
		commend.add(ratio);
		commend.add("-sameq");
		commend.add(newPath);
		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getTime(String oldPath) {
		String flashTime = null;// 视频时长
		File source = new File(oldPath);
		Encoder encoder = new Encoder();
		try {
			MultimediaInfo m = encoder.getInfo(source);
			long ls = m.getDuration();
			flashTime = ls / 60000 + "分" + (ls - (ls / 60000) * 60000) / 1000
					+ "秒！";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return flashTime;
	}
	
	//获取图片分辨率
	public String getImageRatio(String path){
		String ratio = null;
		File file = new File(path);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int width = bi.getWidth(); // 像素
		int height = bi.getHeight(); // 像素
		ratio = width+"X"+height;
		return ratio;
	}
}
