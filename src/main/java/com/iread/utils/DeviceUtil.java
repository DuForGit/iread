package com.iread.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 *项目名称: iread
 *类名称: DeviceUtil
 *类描述: 客户端工具类，判断是移动端还是PC端
 *创建人: Administrator
 *创建时间: 2018年1月4日下午10:18:12
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class DeviceUtil {
	private DeviceUtil(){};
	public final static DeviceUtil DEVICE_UTIL = new DeviceUtil();
	private final static String[] DEVICES = {"android","mac os","windows phone"};
	
	//判断是否为移动端
	public boolean isMobileDevice(String requestHeader){
		if(requestHeader == null || requestHeader == ""){
			return false;
		}
		requestHeader = requestHeader.toLowerCase();
		for(String d : DEVICES){
			if(requestHeader.indexOf(d) > 0){
				return true;
			}
		}
		return false;
	}
	/*public static void main(String[] args) {
		DeviceUtil d = DeviceUtil.DEVICE_UTIL;
		//boolean b = d.isMobileDevice("mozilla/5.0 (windows nt 10.0; wow64) applewebkit/537.36 (khtml, like gecko) chrome/56.0.2924.10 safari/537.36");
		boolean b = d.isMobileDevice("opera/9.80 (android 2.3.7; linux; opera mobi/46154) presto/2.11.355 version/12.10");
		System.out.println(b);
	}*/
}
