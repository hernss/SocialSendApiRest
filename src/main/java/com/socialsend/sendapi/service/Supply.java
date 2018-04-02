package com.socialsend.sendapi.service;


import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com._37coins.bcJsonRpc.pojo.Block;
import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;

@Path("/supply")
public class Supply {

	@GET
	@Path("/gettotalsupply")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> gettotalsupply() {
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
	
	@GET
	@Path("/getaverageblocktime")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> getaverageblocktime() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Double> r ;
		try {
			Block bestBlock  = rpc.getblock(rpc.getbestblockhash());
			Block block  = rpc.getblock(rpc.getblockhash(new BigDecimal(bestBlock.getHeight() - 1000)));
			long time = bestBlock.getTime() - block.getTime();
			double avg = (double)time / 1000.0;
			r = new Response<Double>(avg);
			r.setMessage("Average blocktime in seconds of last 1000 blocks");
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
}