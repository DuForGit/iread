package com.iread.utils;

import java.util.Random;

/**
 *项目名称: iread
 *类名称: CodeUtil
 *类描述: 生成验证码、唯一识别码等
 *创建人: Administrator
 * @version 1.0.0
 * @author 方秋都
 *
 */
public class CodeUtil {
	private static  final Random r = new Random();
	//private static final String test = "801402";//测试以0开头的结果
	private CodeUtil(){};
	
	public static int getCode(){
		String code = "";
		for(int i=0; i<6;i++){
			code+=r.nextInt(10);
			//code += test.substring(i, i+1);
			if(i == 0){//判断第一个值
				if(code.equals("0")){
					System.out.println("首位为0");
					code = "1";
				}
			}
		}
		System.out.println("getCode:" + code);
		return Integer.parseInt(code);
	}
}
