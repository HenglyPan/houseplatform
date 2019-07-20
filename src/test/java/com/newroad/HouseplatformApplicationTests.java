package com.newroad;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseplatformApplicationTests {
	@Autowired
	private HttpClient httpClient;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testHttpClient() throws IOException {
        System.out.println(EntityUtils.toString(httpClient.execute(new HttpGet("http://www.baidu.com")).getEntity()));

	}


}
