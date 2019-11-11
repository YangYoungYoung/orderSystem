package com.ruoyi.common.base.print.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.ruoyi.common.base.print.Config;
import com.ruoyi.common.base.print.Request;

public class DelDev {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		Map<String, String> params = new HashMap<String, String>();

		String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		params.put("reqTime", reqTime);
		
		String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey + Config.receiptDeviceNo);
		params.put("securityCode", securityCode);

		params.put("memberCode", Config.memberCode);

		params.put("deviceID", Config.receiptDeviceNo);
		
		System.out.println("=====请求参数 START=====\r\n" + "---> deldev <---\r\n" + params + "\r\n=====请求参数 END=====");

		String result = Request.sendPost("http://api.poscom.cn/apisc/deldev", params);

		System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");
	}

}
