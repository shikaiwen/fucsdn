package com.highdq.fucsdn.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ManipulationTest {
	
	@Test
	public void login() {
		CsdnConnection connection = Manipulation.login("stltqhs@163.com", "962312ltq2008");
		Assert.assertEquals(true, connection.getRequestLoginResult().isStatus());
	}
}
