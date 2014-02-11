package com.highdq.fucsdn.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

/**
 * csdn用户的操作，首先需要调用login方法获得CsdnConnection对象做后续操作。
 * @author Yutsing Lee
 *
 */
public class Manipulation {
	/**
	 * 请求登录的页面，里面包含参数替换
	 */
	private final static String REQUEST_LOGIN_PAGE_URL = "https://passport.csdn.net/ajax/accounthandler.ashx?t=log&u=%s&p=%s&remember=0&f=http%%3A%%2F%%2Fwww.csdn.net%%2F&rand=%s";
	
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
		String requestLoginPageUrl = null;   //登录页面
		HttpClient client = null;            //用户执行Http Get请求
		HttpGet httpGet = null;              //请求方法（这里为Get请求）
		int statusCode = -1;                 //请求时返回的状态码
		HttpResponse response = null;        //响应对象
		CsdnConnection connection = null;    //login方法返回的对象
		//设置请求登录页面
		try {
			requestLoginPageUrl = String.format(REQUEST_LOGIN_PAGE_URL, URLEncoder.encode(username, PAGE_ENCODING), URLEncoder.encode(password, PAGE_ENCODING), Math.random());
		    //System.out.println(requestLoginPageUrl);
		} catch (UnsupportedEncodingException e) {}
		
		client = HttpClientBuilder.create().build();
		httpGet = new HttpGet(requestLoginPageUrl);
		
		//添加HTTP头
		String headers[] = REQUEST_LOGIN_HEADER_PARTIAL.split("\r\n");
		for (int i = 0; i < headers.length; i++) {
			String namevalue[] = headers[i].split(": ");
			httpGet.addHeader(namevalue[0], namevalue[1]);
		}
		
		try {
			response = client.execute(httpGet);//执行Get请求
			statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) { //状态码不是OK表示错误
		        System.err.println("Method failed: " + response.getStatusLine().toString());
		    } else {
		    	//连接成功，需要获得cookie和json数据
		    	
		    	String jsonContent = EntityUtils.toString(response.getEntity()); //读取消息体，结构是json字符串
		        Gson gson = new Gson();
		        RequestLoginResult result = gson.fromJson(jsonContent, RequestLoginResult.class);//通过json字符串构造成java对象
		        if (result.isStatus()) {//true表示登录成功，false表示登录失败
		        	//System.out.println(result.getData().getEmail());
		        	//提取cookie信息
		        	Header setcookieheaders[] = response.getHeaders("Set-Cookie");//响应时传递的cookie
		        	HttpCookie clientCookies[] = new HttpCookie[setcookieheaders.length];
		        	//解析cookie
		        	for (int i = 0; i < setcookieheaders.length; i++) {
					    List<HttpCookie>  temps = HttpCookie.parse(setcookieheaders[i].toString());
					    clientCookies[i] = temps.get(0);
		        	}
		        	connection = new CsdnConnection(result, clientCookies);
		        }
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (httpGet != null)
				httpGet.releaseConnection();
		}
		return connection;
	}
}
