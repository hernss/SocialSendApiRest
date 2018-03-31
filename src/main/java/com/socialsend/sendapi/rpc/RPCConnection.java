package com.socialsend.sendapi.rpc;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.List;

import com._37coins.bcJsonRpc.BitcoindClientFactory;
import com._37coins.bcJsonRpc.pojo.Block;
import com._37coins.bcJsonRpc.pojo.BlockChainInfo;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com._37coins.bcJsonRpc.pojo.PeerInfo;
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

	public MasternodeCount getMasternodeCount() {
		return this.client.getClient().getmasternodecount();
	}

	public Block getblock(String hash) {
		return this.client.getClient().getblock(hash);
	}
	
	public BlockChainInfo getblockchaininfo() {
		return this.client.getClient().getblockchaininfo();
	}
	
	public BigDecimal getblockcount() {
		return this.client.getClient().getblockcount();
	}
	
	public String getblockhash(BigDecimal index) {
		return this.client.getClient().getblockhash(index);
	}
	
	public double getdifficulty() {
		return this.client.getClient().getdifficulty();
	}
	
	public long getconnectioncount() {
		return this.client.getClient().getconnectioncount();
	}
	
	public List<PeerInfo> getpeerinfo(){
		return this.client.getClient().getpeerinfo();
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
	
	public String getbestblockhash() {
		return this.client.getClient().getbestblockhash();
	}
	
	
}
