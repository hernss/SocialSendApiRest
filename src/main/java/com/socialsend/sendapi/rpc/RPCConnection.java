package com.socialsend.sendapi.rpc;

import java.io.IOException;
import java.net.Authenticator;

import java.net.PasswordAuthentication;
import java.net.URL;



import com._37coins.bcJsonRpc.BitcoindClientFactory;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;


public class RPCConnection {
	JsonRpcHttpClient client;
	String user = "sendrpc";
	String pw = "66HuNPybj8UkTXZ77kEKcTqrmpCUafVVUYSUFSuk6Suf";
	Info info;
	MasternodeCount mn;
	
	public Info getInfo() {
		return info;
	}

	public MasternodeCount getMn() {
		return mn;
	}

	public void setMn(MasternodeCount mn) {
		this.mn = mn;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public RPCConnection() throws IOException {
		
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( user, pw.toCharArray());
			}
			
		});
		
		
		BitcoindClientFactory client = new BitcoindClientFactory(new URL("http://localhost:50051/"), user, pw);
		/*
		String cred = Base64.encodeBytes((user + ":" + pw).getBytes());
		Map<String, String> headers = new HashMap<String, String>(1);
		headers.put("Authorization", "Basic " + cred);
		//client = new JsonRpcHttpClient(new URL("http://localhost:50051/"), headers);
		//client = new JsonRpcHttpClient(new URL("http://" + user + ":" + pw + "@localhost:50051/"));

		
		boolean success =false;
		for (int i = 10; i > 0; i--){
			try{
				
				success = true;
			}catch(Exception e){
				try {
					
					Thread.sleep(1000);
				} catch (InterruptedException e1) {}
			}
			if (success){
				break;
			}
		}
		if (!success){
			throw new IOException("could not connect to bitcoind\n" + (new URL("http://" + user + ":" + pw + "@localhost:50051/")).toString());
		}*/
		this.info = client.getClient().getinfo();
		this.mn = client.getClient().getmasternodecount();
	}
	
	
}
