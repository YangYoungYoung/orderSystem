package com.ruoyi.common.base.print.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.ruoyi.common.base.print.Config;
import com.ruoyi.common.base.print.Request;

public class ListException {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		Map<String, String> params = new HashMap<String, String>();

		String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
		params.put("reqTime", reqTime);
		
		String securityCode = DigestUtils.md5Hex(Config.memberCode + reqTime + Config.apiKey);
		params.put("securityCode", securityCode);

		params.put("memberCode", Config.memberCode);
		params.put("imsi", Config.receiptDeviceNo);
		
		params.put("start", Request.getPastDate(7));
		params.put("end", Request.getPastDate(0));
		
		System.out.println("=====请求参数 START=====\r\n" + "---> listException <---\r\n" + params + "\r\n=====请求参数 END=====");

		String result = Request.sendGet("http://api.poscom.cn/apisc/listException", params);

		System.out.println("=====请求返回 START=====\r\n" + result + "\r\n=====请求返回 END=====");
	}

}
