package com.socialsend.sendapi.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;

@Path("/supply")
public class Supply {

	@GET
	@Path("/gettotalsupply")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> gettxoutsetinfo() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Double> r ;
		try {
			r = new Response<Double>(rpc.gettxoutsetinfo().getTotalSupply());
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
}