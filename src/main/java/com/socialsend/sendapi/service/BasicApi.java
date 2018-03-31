package com.socialsend.sendapi.service;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;
import com._37coins.bcJsonRpc.pojo.Block;
import com._37coins.bcJsonRpc.pojo.BlockChainInfo;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;

@Path("/basic")
public class BasicApi {
	
	@GET
	@Path("/getinfo")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Info> getinfo() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Info> r;
		try {
			r = new Response<Info>(rpc.getInfo());
		} catch (Exception e) {
			r = new Response<Info>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getmasternodecount")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<MasternodeCount> getmasternodecount() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<MasternodeCount> r;
		try {
			r = new Response<MasternodeCount>(rpc.getMasternodeCount());
		} catch (Exception e) {
			r = new Response<MasternodeCount>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getbestblockhash")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<String> getbestblockhash() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<String> r;
		try {
			r = new Response<String>(rpc.getbestblockhash());
		} catch (Exception e) {
			r = new Response<String>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getblock/{hash}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Block> getblock(@PathParam("hash") String hash) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Block> r ;
		try {
			r = new Response<Block>(rpc.getblock(hash));
		} catch (Exception e) {
			r = new Response<Block>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getblockchaininfo")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<BlockChainInfo> getblockchaininfo() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<BlockChainInfo> r ;
		try {
			r = new Response<BlockChainInfo>(rpc.getblockchaininfo());
		} catch (Exception e) {
			r = new Response<BlockChainInfo>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getblockcount")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<BigDecimal> getblockcount() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<BigDecimal> r ;
		try {
			r = new Response<BigDecimal>(rpc.getblockcount());
		} catch (Exception e) {
			r = new Response<BigDecimal>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	/*

	

	
	public BigDecimal getblockcount();
	
	public String getblockhash(BigDecimal index);
	
	public double getdifficulty();*/
	
}
