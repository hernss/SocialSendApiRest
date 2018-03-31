package com.socialsend.sendapi.config;

import java.net.MalformedURLException;
import java.net.URL;

public class RPCConfiguration {
	
	private String user = "";
	private String pass = "";
	private URL url;
	
	public URL getUrl() {
		return url;
	}
	public void setUrl(String url) throws MalformedURLException {
		this.url = new URL( url);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}


	public RPCConfiguration() throws MalformedURLException {
		
		this.user = "sendrpc";
		this.pass = "66HuNPybj8UkTXZ77kEKcTqrmpCUafVVUYSUFSuk6Suf";
		this.url = new URL("http://localhost:50051/");
		
		
	}
	
	
	
	
	

}
