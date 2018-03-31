package com.socialsend.sendapi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;


@Path("/basic")
public class BasicApi {
	
	@GET
	@Path("/getinfo")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Info> getinfo() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Info> r = new Response<Info>(rpc.getInfo());
		
		return r;
	}
	
	@GET
	@Path("/getmasternodecount")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<MasternodeCount> getmasternodecount() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<MasternodeCount> r = new Response<MasternodeCount>(rpc.getMn());
		
		return r;
	}

	
}
