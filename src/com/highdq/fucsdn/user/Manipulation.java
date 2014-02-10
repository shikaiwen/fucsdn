package com.highdq.fucsdn.user;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * csdn用户的操作。
 * @author Yutsing Lee
 *
 */
public class Manipulation {
	/**
	 * 请求登录的页面，里面包含参数替换
	 */
	private final static String REQUEST_LOGIN_PAGE = "https://passport.csdn.net/ajax/accounthandler.ashx?t=log&u=%s&p=%s&remember=0&f=http%3A%2F%2Fwww.csdn.net%2F&rand=%s";
	
	/**
	 * csdn页面编码
	 */
	private final static String PAGE_ENCODING = "utf-8";
	
	public static CsdnConnection login(String username, String password) {
		String requestLoginPage = null;
		try {
			String.format(REQUEST_LOGIN_PAGE, URLEncoder.encode(username, PAGE_ENCODING), URLEncoder.encode(password, PAGE_ENCODING), Math.random());
		} catch (UnsupportedEncodingException e) {}
		
		return null;
	}
}
