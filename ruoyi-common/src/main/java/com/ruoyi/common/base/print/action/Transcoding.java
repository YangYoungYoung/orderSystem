package com.ruoyi.common.base.print.action;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

public class Transcoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO 自动生成的方法存根

//        System.out.println(String.valueOf(Calendar.getInstance().getTimeInMillis()));
		System.out.println(str2HexStr("中文字符"));
	}
	
	public static String str2HexStr(String source) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = source.getBytes("GBK");
        for(byte b : bytes) {
            sb.append(Integer.toHexString((b & 0xff)));
        }
        return sb.toString();
    }

}
