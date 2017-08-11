package com.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.weixin.service.impl.CoreService;
import com.weixin.util.SignUtil;


@Controller
public class WeixinController {

	@RequestMapping(value = { "signature" },method=RequestMethod.GET)
	public void signature(
			@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr,
			HttpServletResponse response) throws IOException {
		 PrintWriter out = response.getWriter();  
		 // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.flush();
		out.close();
	}
	
	
	@RequestMapping(value = { "signature" },method=RequestMethod.POST)

	public void signaturepost(HttpServletResponse response,HttpServletRequest re) throws IOException, DocumentException {
		   // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(re);  
          System.out.println(">>>>>>>>>>>>>>>>>>>>>>>."+respMessage);
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
	}
	
	
	
	
}