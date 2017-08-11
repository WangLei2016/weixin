package com.weixin.commn;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class parseXml
{
/**
 * 解析微信发来的请求（XML）
 * 
 * @param request
 * @return
 * @throws Exception
 */
@SuppressWarnings("unchecked")
public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
	// 将解析结果存储在HashMap中
	Map<String, String> map = new HashMap<String, String>();

	// 从request中取得输入流
	InputStream inputStream = request.getInputStream();
	// 读取输入流
	SAXReader reader = new SAXReader();
	Document document = reader.read(inputStream);
	// 得到xml根元素
	Element root = document.getRootElement();
	// 得到根元素的所有子节点
	List<Element> elementList = root.elements();

	// 遍历所有子节点
	for (Element e : elementList)
		map.put(e.getName(), e.getText());

	// 释放资源
	inputStream.close();
	inputStream = null;

	return map;
}


}