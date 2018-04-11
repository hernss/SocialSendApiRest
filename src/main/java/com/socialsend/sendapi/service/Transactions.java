package com.socialsend.sendapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com._37coins.bcJsonRpc.pojo.DecodedTransaction;
import com._37coins.bcJsonRpc.pojo.NewPaymentParameters;
import com._37coins.bcJsonRpc.pojo.NewPaymentResponse;
import com._37coins.bcJsonRpc.pojo.PaymentStatus;
import com._37coins.bcJsonRpc.pojo.ScriptPubKey;
import com._37coins.bcJsonRpc.pojo.Transaction;
import com._37coins.bcJsonRpc.pojo.TxInfo;
import com._37coins.bcJsonRpc.pojo.Vout;
import com.socialsend.sendapi.database.Database;
import com.socialsend.sendapi.email.SendMail;
import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;

@Path("/txinfo")
public class Transactions {

	
	public String convertDateToString(long timestamp)
	{
	   String dateString = "";
	   SimpleDateFormat sdfr = null;
	   try{
		   sdfr = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	   }catch (Exception ex ){
		   System.out.println(ex);
	   }
	   /*you can also use DateFormat reference instead of SimpleDateFormat 
	    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
	    */
	   try{
		dateString = sdfr.format( new Date(timestamp * 1000) );
	   }catch (Exception ex ){
		   System.out.println(ex);
	   }
	   return dateString;
	}
	
	
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
	public Response<TxInfo> getinfo(@PathParam("txid") String txid, @PathParam("addr") String addr) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<TxInfo> r ;
		try {
			
			Transaction tx1 = rpc.gettransaction(txid);
			
			if(!tx1.getVout().isEmpty()) {
				ScriptPubKey sp = tx1.getVout().get(0).getScriptPubKey();
				
				if(sp.getType().equals("nonstandard")) {
					//Mined Block
					System.out.println("TXID-MINED");
					
					TxInfo txinfo = new TxInfo();
					txinfo.setConfirmations(tx1.getConfirmations());
					txinfo.setDate(convertDateToString(tx1.getTime()));
					txinfo.setReward(true);
					txinfo.setTime(tx1.getTime());
					txinfo.setTo(addr);
					
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
						txinfo.setAmount(valueMN);
						txinfo.setFrom("");
						r = new Response<TxInfo>(txinfo);
						r.setMessage("MN Reward");
					}else {
						
						//Consulto los valores de entrada.
						if(!tx1.getVin().isEmpty()) {
							String txidEntrada = tx1.getVin().get(0).getTxid();
							long vout = tx1.getVin().get(0).getVout();
							
							//Busco la tx de origen
							Transaction tx2 = rpc.gettransaction(txidEntrada);
							
							if((!tx2.getVout().isEmpty()) && tx2.getVout().get((int)vout).getScriptPubKey().getAddresses().get(0).equals(addr)) {
								double valuePOSentrada = tx2.getVout().get((int)vout).getValue();
								txinfo.setAmount(valuePOS - valuePOSentrada);
								txinfo.setFrom(tx2.getVout().get((int)vout).getScriptPubKey().getAddresses().get(0));
								r = new Response<TxInfo>(txinfo);
								r.setMessage("Stake Reward");
							}else {
								r = new Response<TxInfo>(null);
								r.setStatus("ERROR");
								r.setMessage("No se encontraron Vouts validos");
							}
						}else {
							r = new Response<TxInfo>(null);
							r.setStatus("ERROR");
							r.setMessage("No se encontraron Vins validos");
						}
					}
				}else {
					//TX p2p
					System.out.println("TXID-P2P");
					double value = 0;
					TxInfo txinfo = new TxInfo();
					
					for(Vout v : tx1.getVout()) {
						if (v.getScriptPubKey().getAddresses().get(0).equals(addr)) {
							value = v.getValue();
						}
					}
					
					txinfo.setAmount(value);
					txinfo.setConfirmations(tx1.getConfirmations());
					txinfo.setReward(false);
					txinfo.setTime(tx1.getTime());
					txinfo.setTo(addr);
					txinfo.setDate(convertDateToString(tx1.getTime()));
					
					if(!tx1.getVin().isEmpty()) {
						String txidEntrada = tx1.getVin().get(0).getTxid();
						long vout = tx1.getVin().get(0).getVout();
						
						//Busco la tx de origen
						Transaction tx2 = rpc.gettransaction(txidEntrada);
						
						if(!tx2.getVout().isEmpty()) {
							txinfo.setFrom(tx2.getVout().get((int)vout).getScriptPubKey().getAddresses().get(0));
						}
					}
					
					r = new Response<TxInfo>(txinfo);
					r.setMessage("P2P Send");
				}
			}else {
				r = new Response<TxInfo>(null);
				r.setStatus("ERROR");
				r.setMessage("No se encontraron Vouts validos");
			}
				
		} catch (Exception e) {
			r = new Response<TxInfo>(null);
			r.setStatus("ERROR");
			r.setMessage("Se produjo una excepcion no controlada");
		}
		
		return r;
	}
	
	
	/*Generate Payment
	  Parameters:
	  		emailSender
		  	emailReceiver
		  	depositAddress
		  	amount
		  	minimiumConfirmations : default 3
		  	expire : default 7200 segundos
	  Response:
	  		status: OK / ERROR
	  		message: Optional error message
	  		data:
	  			id: internal api id from transaction
	  			cancelLink: in case of existing pending payment to this address, link for canceling pending payment
	  			statusLink: link to api to view payment status.
	
	*/
	
	@POST
	@Path("/makepayment")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response<NewPaymentResponse> makepayment(NewPaymentParameters param) {
		
		Response<NewPaymentResponse> res;
		
		RPCConnection rpc = RPCConnection.getInstance();
		SendMail sm = SendMail.getInstance();
		Database db = Database.getInstance();
		
		if(!rpc.validateaddress(param.getDepositAddress()).isIsvalid()) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Invalid Deposit Address");
			return res;
		}
		
		if(!sm.validateEmail(param.getEmailSender())) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Invalid Sender Email");
			return res;
		}
		
		if(!sm.validateEmail(param.getEmailReceiver())) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Invalid Receiver Email");
			return res;
		}
		
		if(param.getAmount() <= 0) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Invalid requested amount");
			return res;
		}
		
		if(param.getMinimiumConfirmations() <= 0) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Invalid Minimium Confirmations");
			return res;
		}
		
		if(param.getExpire() <= 600) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Minimiun expire time is 600 seconds");
			return res;
		}
		
		//Primero chequear que no haya un pago pendiente a esa deposit address
		if(db.isPendindDeposit(param.getDepositAddress())) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("You have pending deposit to this address. Please cancel your pending order or generate a new address and submit again.");
			return res;
		}
		
		String subject = "Payment Request";
		String SenderMessage = "<p>You are receiving a payment request from " + param.getEmailReceiver() + "</p>";
		SenderMessage += "<p>The total amount to pay is " + param.getAmount() + " Sends and you have to deposit it to the adrress " + param.getDepositAddress() + " until " + convertDateToString( param.getExpire() + (System.currentTimeMillis()/1000)) + " UTC.</p>";
		SenderMessage += "<p>You can scan this QR code with your wallet app.</p>";
		SenderMessage += "<p><img src='https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + param.getDepositAddress() + "'></img></p>";
		SenderMessage += "<p>Or if you are on Android and you have installed SocialSend Android Wallet you can follow this <a href='socialsend://address='" + param.getDepositAddress() + "'>link</a></p>";

		
		if(!sm.sendMessage(param.getEmailSender(), subject, SenderMessage)) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Error when trying to send SenderMail");
			return res;
		}
		
		long id = db.insertPayment(param);
		
		if(id ==0) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Error when trying to insert new payment in db.");
			return res;
		}
		
		String ReceiverMessage = "<p>You have created a new payment request to " + param.getEmailSender() +"</p>";
		ReceiverMessage += "<p>The total amount to pay is " + param.getAmount() + " Sends and the link is available until " + convertDateToString( param.getExpire() + (System.currentTimeMillis()/1000)) + " UTC.</p>";
		ReceiverMessage += "<p>The systen will notify you when the payment were done.</p>";
		ReceiverMessage += "<p>You can check payment status in this <a href='http://140.82.15.8:8080/SocialSendApi/api/txinfo/checkpayment/" + id + "'>link</a></p>";

		if(!sm.sendMessage(param.getEmailReceiver(), subject, ReceiverMessage)) {
			res = new Response<NewPaymentResponse>(null);
			res.setStatus("ERROR");
			res.setMessage("Error when trying to send ReceiverMessage");
			return res;
		}
		
		NewPaymentResponse rp = new NewPaymentResponse();
		
		rp.setId(id);
		rp.setExpiration(param.getExpire() + (System.currentTimeMillis()/1000));
		
		return new Response<NewPaymentResponse>(rp);
	}
	
	@GET
	@Path("/checkpayment/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<PaymentStatus> checkpayment(@PathParam("id") long id) {
		
		Database db = Database.getInstance();
		Response<PaymentStatus> res;
		
		PaymentStatus p = db.getPaymentStatus(id);
		
		if(p == null) {
			res = new Response<PaymentStatus>(null);
			res.setStatus("ERROR");
			res.setMessage("Error reading db.");
			return res;
		}
		
		p.setEmailReceiver("");
		p.setEmailSender("");
		res = new Response<PaymentStatus>(p);
		
		return res;
		
	}
	
	@GET
	@Path("/expirePayment/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Void> expirePayment(@PathParam("id") long id) {
		
		Database db = Database.getInstance();
		Response<Void> res;
		
		PaymentStatus p = db.getPaymentStatus(id);
		
		if(p == null) {
			res = new Response<Void>(null);
			res.setStatus("ERROR");
			res.setMessage("Error reading db.");
			return res;
		}
		
		SendMail sm = SendMail.getInstance();
		String subject = "Payment Expired";
		
		String message = "<h2>Your payment has expired!</h2>";
		message += "<p>You have requested a payment from " + p.getEmailSender() + " for " + p.getAmount() + "Sends.</p>";
		message += "<p>The payment request that you created has expired. Please consider to create a new one</p>";
		
		sm.sendMessage(p.getEmailReceiver(), subject, message);
		
		message = "<h2>The payment request that you received has expired.</h2>";
		message += "<p>You have received a request from " + p.getEmailReceiver() + " for " + p.getAmount() + "Sends.</p>";
		message += "<p>Please do not make this payment, just contact the recipient and ask for a new payment request..</p>";
	
		sm.sendMessage(p.getEmailReceiver(), subject, message);
		
		res = new Response<Void>(null);
		
		return res;
		
	}
	
	@GET
	@Path("/updatePayment/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Void> updatePayment(@PathParam("id") long id) {
		
		Database db = Database.getInstance();
		Response<Void> res;
		
		/*PaymentStatus p = db.getPaymentStatus(id);
		
		if(p == null) {
			res = new Response<Void>(null);
			res.setStatus("ERROR");
			res.setMessage("Error reading db.");
			return res;
		}*/
		
		res = new Response<Void>(null);
		
		return res;
		
	}
}
