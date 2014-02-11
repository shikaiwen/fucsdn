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
	 * 请求登录时的部分HTTP头信息
	 */
	private final static String REQUEST_LOGIN_HEADER_PARTIAL = "Accept: */*\r\nAccept-Encoding: gzip,deflate,sdch\r\n"
                                                                 + "Accept-Language: zh-CN,zh;q=0.8\r\n"
                                                                 + "Connection: keep-alive\r\n"
                                                                 + "Host: passport.csdn.net\r\n"
                                                                 + "Referer: https://passport.csdn.net/account/loginbox?"
                                                                 + "callback=logined&hidethird=1&from=http%3a%2f%2fwww.csdn.net%2f\r\n"
                                                                 + "User-Agent: Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like "
                                                                 + "Gecko) Chrome/32.0.1700.107 Safari/537.36\r\n"
                                                                 + "X-Requested-With: XMLHttpRequest\r\n";
	/**
	 * csdn页面编码
	 */
	private final static String PAGE_ENCODING = "utf-8";
	
	/**
	 * 使用username作为用户名，password作为密码请求登录到csdn中，如果登录成功，返回CsdnConnection对象，否则返回null。
	 * 更多的操作将会使用到CsdnConnection对象。
	 * @param username 用户名
	 * @param password 密码
	 * @return 登录成功，返回CsdnConnection对象，否则返回null。
	 */
	public static CsdnConnection login(String username, String password) {
		String requestLoginPage = null;
		
		//设置请求登录页面
		try {
			String.format(REQUEST_LOGIN_PAGE, URLEncoder.encode(username, PAGE_ENCODING), URLEncoder.encode(password, PAGE_ENCODING), Math.random());
		} catch (UnsupportedEncodingException e) {}
		
		
		return null;
	}
}
