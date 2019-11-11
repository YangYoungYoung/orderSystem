package com.ruoyi.common.base.print.action;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.ruoyi.common.base.print.PrintData;
import org.apache.commons.codec.digest.DigestUtils;

import com.ruoyi.common.base.print.Config;
import com.ruoyi.common.base.print.Request;

public class SendMsgToLabel {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO 自动生成的方法存根
		
		Map<String, String> params = new HashMap<String, String>();

		String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		params.put("reqTime", reqTime);
		
		String securityCode = DigestUtils.md5Hex(Config.memberCode + Config.labelDeviceNo + reqTime + Config.apiKey);
		params.put("securityCode", securityCode);
		
		params.put("memberCode", Config.memberCode);
		params.put("deviceNo", Config.labelDeviceNo);
		
		//-----标签打印机 格式类型:2
		params.put("mode", "2");
		params.put("msgDetail", PrintData.LabelData2);
		//-----标签打印机 格式类型:2
		
		//-----标签打印机 格式类型:3
		/*params.put("mode", "3");
		params.put("msgDetail", PrintData.LabelData3);*/
		//-----标签打印机 格式类型:3
		
		params.put("charset","4"); //Default:1, 1:GB18030, 2:GB2312, 3:GBK, 4:UTF-8, 5:Unicode, 6:ISO8859-1, 7:BIG5

		//params.put("msgNo", Content.msgNo);
		
		System.out.println("=====请求参数 START=====\r\n" + "---> sendMsg <---\r\n" + params + "\r\n=====请求参数 END=====");

		String result = Request.sendPost("http://api.poscom.cn/apisc/sendMsg", params);

		System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");
	}

}
