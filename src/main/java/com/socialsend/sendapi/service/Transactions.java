package com.socialsend.sendapi.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com._37coins.bcJsonRpc.pojo.DecodedTransaction;
import com._37coins.bcJsonRpc.pojo.ScriptPubKey;
import com._37coins.bcJsonRpc.pojo.Vout;
import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;

@Path("/txinfo")
public class Transactions {

	@GET
	@Path("/getvalue/{txid}/{addr}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> getvalue(@PathParam("txid") String txid, @PathParam("addr") String addr) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Double> r ;
		try {
			
			DecodedTransaction tx1 = rpc.decoderawtransaction(rpc.getrawtransaction(txid));
			
			if(!tx1.getVout().isEmpty()) {
				ScriptPubKey sp = tx1.getVout().get(0).getScriptPubKey();
				
				if(sp.getType().equals("nonstandard")) {
					//Mined Block
					System.out.println("TXID-MINED");
					//Consulto los valores de salida
					double valuePOS = 0;
					double valueMN = 0;
					boolean isMasternode = false;
					for(Vout v : tx1.getVout()) {
						if(v.getScriptPubKey().getType().equals("pubkey")) {
							if(v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
								valuePOS += v.getValue();
							}
						}
						if(v.getScriptPubKey().getType().equals("pubkeyhash")) {
							valueMN += v.getValue();
							if(v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
								isMasternode = true;
							}
						}
				
					}
					
					if(isMasternode) {
						r = new Response<Double>(valueMN);
						r.setMessage("MN Reward");
					}else {

						//Consulto los valores de entrada.
						if(!tx1.getVin().isEmpty()) {
							String txidEntrada = tx1.getVin().get(0).getTxid();
							long vout = tx1.getVin().get(0).getVout();
							
							//Busco la tx de origen
							DecodedTransaction tx2 = rpc.decoderawtransaction(rpc.getrawtransaction(txidEntrada));
							
							if((!tx2.getVout().isEmpty()) && tx2.getVout().get((int)vout).getScriptPubKey().getAddresses().get(0).equals(addr)) {
								double valuePOSentrada = tx2.getVout().get((int)vout).getValue();
								r = new Response<Double>(valuePOS - valuePOSentrada);
								r.setMessage("Stake Reward");
							}else {
								r = new Response<Double>(null);
								r.setStatus("ERROR");
								r.setMessage("No se encontraron Vouts validos");
							}
						}else {
							r = new Response<Double>(null);
							r.setStatus("ERROR");
							r.setMessage("No se encontraron Vins validos");
						}
					}
				}else {
					//TX p2p
					System.out.println("TXID-P2P");
					double value = 0;
					
					for(Vout v : tx1.getVout()) {
						if (v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
							value = v.getValue();
						}
					}
					
					r = new Response<Double>(value);
					r.setMessage("P2P Send");
				}
			}else {
				r = new Response<Double>(null);
				r.setStatus("ERROR");
				r.setMessage("No se encontraron Vouts validos");
			}
				
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage("Se produjo una excepcion no controlada");
		}
		
		return r;
	}
	

	@GET
	@Path("/getinfo/{txid}/{addr}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> getinfo(@PathParam("txid") String txid, @PathParam("addr") String addr) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Double> r ;
		try {
			
			DecodedTransaction tx1 = rpc.decoderawtransaction(rpc.getrawtransaction(txid));
			
			if(!tx1.getVout().isEmpty()) {
				ScriptPubKey sp = tx1.getVout().get(0).getScriptPubKey();
				
				if(sp.getType().equals("nonstandard")) {
					//Mined Block
					System.out.println("TXID-MINED");
					//Consulto los valores de salida
					double valuePOS = 0;
					double valueMN = 0;
					boolean isMasternode = false;
					for(Vout v : tx1.getVout()) {
						if(v.getScriptPubKey().getType().equals("pubkey")) {
							if(v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
								valuePOS += v.getValue();
							}
						}
						if(v.getScriptPubKey().getType().equals("pubkeyhash")) {
							valueMN += v.getValue();
							if(v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
								isMasternode = true;
							}
						}
				
					}
					
					if(isMasternode) {
						r = new Response<Double>(valueMN);
						r.setMessage("MN Reward");
					}else {

						//Consulto los valores de entrada.
						if(!tx1.getVin().isEmpty()) {
							String txidEntrada = tx1.getVin().get(0).getTxid();
							long vout = tx1.getVin().get(0).getVout();
							
							//Busco la tx de origen
							DecodedTransaction tx2 = rpc.decoderawtransaction(rpc.getrawtransaction(txidEntrada));
							
							if((!tx2.getVout().isEmpty()) && tx2.getVout().get((int)vout).getScriptPubKey().getAddresses().get(0).equals(addr)) {
								double valuePOSentrada = tx2.getVout().get((int)vout).getValue();
								r = new Response<Double>(valuePOS - valuePOSentrada);
								r.setMessage("Stake Reward");
							}else {
								r = new Response<Double>(null);
								r.setStatus("ERROR");
								r.setMessage("No se encontraron Vouts validos");
							}
						}else {
							r = new Response<Double>(null);
							r.setStatus("ERROR");
							r.setMessage("No se encontraron Vins validos");
						}
					}
				}else {
					//TX p2p
					System.out.println("TXID-P2P");
					double value = 0;
					
					for(Vout v : tx1.getVout()) {
						if (v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
							value = v.getValue();
						}
					}
					
					r = new Response<Double>(value);
					r.setMessage("P2P Send");
				}
			}else {
				r = new Response<Double>(null);
				r.setStatus("ERROR");
				r.setMessage("No se encontraron Vouts validos");
			}
				
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage("Se produjo una excepcion no controlada");
		}
		
		return r;
	}
	
	
	
}
