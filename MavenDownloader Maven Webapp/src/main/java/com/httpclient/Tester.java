package com.httpclient;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Tester {
	public static void main(String[] args) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://127.0.0.1:8080/API/CHSC/getAgreements");
		
		JSONObject jobj = new JSONObject();
		jobj.put("page", 1);
		jobj.put("size", "a");
		jobj.put("size", 2);
		jobj.put("begindate", "2016-1-1");
		jobj.put("enddate", "2016-12-1");
		jobj.put("opttype", 1);
		jobj.put("tokenid", "9a7c6d60-a30a-4486-8551-7a6c4884e56c");
		jobj.put("ts", "111");
		jobj.put("sign", "49b8916e6df915997bdd00a412cab4fa");
		post.setEntity(new StringEntity(jobj.toString(), "utf-8"));
		try {
			CloseableHttpResponse resp = client.execute(post);
			System.out.println(resp.getStatusLine());
			HttpEntity entity = resp.getEntity();
			
			System.out.println(EntityUtils.toString(entity));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
