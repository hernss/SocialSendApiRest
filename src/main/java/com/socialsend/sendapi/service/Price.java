package com.socialsend.sendapi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com._37coins.bcJsonRpc.pojo.Block;
import com.socialsend.sendapi.database.Database;
import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;


@Path("/price")
public class Price {

	
	@GET
	@Path("/send_btc")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> send_btc() {
		Database db = Database.getInstance();
		Response<Double> r = null;
		try {
			r = new Response<Double>(db.getSendBtcPrice());
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/send_usd")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> send_usd() {
		Database db = Database.getInstance();
		Response<Double> r = null;
		try {
			r = new Response<Double>(db.getSendUsdPrice());
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/send_peso")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> send_peso() {
		Database db = Database.getInstance();
		Response<Double> r = null;
		try {
			r = new Response<Double>(db.getSendPesoPrice());
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/convertusd2send/{usd}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> convertusd2send(@PathParam("usd") Double usd) {
		Database db = Database.getInstance();
		Response<Double> r ;
		try {
			double send = db.getSendUsdPrice();
			r = new Response<Double>(usd / send);
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/convertpeso2send/{peso}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> convertpeso2send(@PathParam("peso") Double peso) {
		Database db = Database.getInstance();
		Response<Double> r ;
		try {
			double send = db.getSendPesoPrice();
			r = new Response<Double>(peso / send);
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	
	
}
