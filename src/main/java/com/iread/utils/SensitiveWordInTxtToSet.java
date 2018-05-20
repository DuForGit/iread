package com.iread.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/**
 *项目名称: iread
 *类名称: SensitiveWordInTxtToMap
 *类描述: 
 *创建人: Administrator
 *创建时间: 2018年4月6日下午10:18:47
 * @version
 * @author 方秋都
 *
 */
public class SensitiveWordInTxtToSet {
	private SensitiveWordInTxtToSet(){}
	private static Set<String> sensitiveWordSet = new HashSet<>();
	public final static Set<String> SENSITIVE_WORD_SET = toSet();
	
	private static Set<String> toSet(){
		String f = SensitiveWordUtil.class.getClassLoader().getResource("sensitive.txt").getFile();
		System.out.println("敏感词路径：" + f);
		String uri = f.replace("%20", " ");
		InputStreamReader read;
		try {
			read = new InputStreamReader(new FileInputStream(new File(uri)),"utf8");
			BufferedReader buff = new BufferedReader(read);
			String s;
			try {
				while((s = buff.readLine()) != null){
					sensitiveWordSet.add(s);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		return sensitiveWordSet;
	}
	
}
