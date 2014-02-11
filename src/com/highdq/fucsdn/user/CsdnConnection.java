package com.highdq.fucsdn.user;

import java.net.HttpCookie;

/**
 * 与csdn的连接
 * @author Yutsing Lee
 *
 */
public class CsdnConnection {
    /**
     * 登录时返回正确的用户信息
     */
    private RequestLoginResult requestLoginResult;
    
    private HttpCookie cookies[];
    
    public CsdnConnection(RequestLoginResult result, HttpCookie cookies[]) {
    	requestLoginResult = result;
    	this.cookies = cookies;
    }

	public RequestLoginResult getRequestLoginResult() {
		return requestLoginResult;
	}

	public HttpCookie[] getCookies() {
		return cookies;
	}

}
