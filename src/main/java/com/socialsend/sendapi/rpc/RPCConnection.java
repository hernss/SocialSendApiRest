package com.socialsend.sendapi.rpc;

import java.io.IOException;
import java.net.MalformedURLException;
import com._37coins.bcJsonRpc.BitcoindClientFactory;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com.socialsend.sendapi.config.RPCConfiguration;


public class RPCConnection {
	
	// Singleton Variables and Procedures
	private static RPCConnection instance = null;
	
	public static RPCConnection getInstance() {
      if(instance == null) {
         instance = new RPCConnection();
      }
      return instance;
	}
	//End Singleton
	
	private BitcoindClientFactory client;
	
	public Info getInfo() {
		return this.client.getClient().getinfo();
	}

	public MasternodeCount getMn() {
		return this.client.getClient().getmasternodecount();
	}

	protected RPCConnection(){

		try {
			RPCConfiguration conf = new RPCConfiguration();
			client = new BitcoindClientFactory(conf.getUrl(), conf.getUser(), conf.getPass());
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
	
	
}
