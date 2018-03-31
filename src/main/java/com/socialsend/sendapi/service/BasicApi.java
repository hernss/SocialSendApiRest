package com.socialsend.sendapi.service;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.socialsend.sendapi.rpc.RPCConnection;
import com.socialsend.sendapi.vo.VOUsuario;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;


@Path("/basic")
public class BasicApi {
	
	@GET
	@Path("/getinfo")
	@Produces({MediaType.APPLICATION_JSON})
	public Info getinfo() {
		try {
			RPCConnection rpc = new RPCConnection();
			Info i = new Info();
			i.setStatus("ERROR");
			return i;
		} catch (IOException e) {
			Info i = new Info();
			i.setStatus("ERROR");
			return i;
		}
	}
	
	@GET
	@Path("/getmasternodecount")
	@Produces({MediaType.APPLICATION_JSON})
	public MasternodeCount getmasternodecount() {
		
		try {
			RPCConnection rpc = new RPCConnection();
			return rpc.getMn();
		} catch (IOException e) {
			
			return null;
		}
	
		
	}

	
}
