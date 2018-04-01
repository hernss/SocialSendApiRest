package com.socialsend.sendapi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;

import com.socialsend.sendapi.response.Response;
import com.socialsend.sendapi.rpc.RPCConnection;
import com._37coins.bcJsonRpc.pojo.Block;
import com._37coins.bcJsonRpc.pojo.BlockChainInfo;
import com._37coins.bcJsonRpc.pojo.DecodedTransaction;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.Masternode;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com._37coins.bcJsonRpc.pojo.PeerInfo;
import com._37coins.bcJsonRpc.pojo.Transaction;
import com._37coins.bcJsonRpc.pojo.VerifyResult;

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
	
	@GET
	@Path("/getblockhash/{index}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<String> getblockhash(@PathParam("index") BigDecimal index) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<String> r ;
		try {
			r = new Response<String>(rpc.getblockhash(index));
		} catch (Exception e) {
			r = new Response<String>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getdifficulty")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Double> getdifficulty() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Double> r ;
		try {
			r = new Response<Double>(rpc.getdifficulty());
		} catch (Exception e) {
			r = new Response<Double>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getconnectioncount")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Long> getconnectioncount() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Long> r ;
		try {
			r = new Response<Long>(rpc.getconnectioncount());
		} catch (Exception e) {
			r = new Response<Long>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getpeerinfo")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<List<PeerInfo>> getpeerinfo() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<List<PeerInfo>> r ;
		try {
			r = new Response<List<PeerInfo>>(rpc.getpeerinfo());
		} catch (Exception e) {
			r = new Response<List<PeerInfo>>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/decoderawtransaction/{hex}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<DecodedTransaction> decoderawtransaction(@PathParam("hex") String hex) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<DecodedTransaction> r ;
		try {
			r = new Response<DecodedTransaction>(rpc.decoderawtransaction(hex));
		} catch (Exception e) {
			r = new Response<DecodedTransaction>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/getrawtransaction/{txid}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<String> getrawtransaction(@PathParam("txid") String txid) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<String> r ;
		try {
			r = new Response<String>(rpc.getrawtransaction(txid));
		} catch (Exception e) {
			r = new Response<String>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/listmasternodes")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<List<Masternode>> listmasternodes() {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<List<Masternode>> r ;
		try {
			r = new Response<List<Masternode>>(rpc.listmasternodes());
		} catch (Exception e) {
			r = new Response<List<Masternode>>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/validateaddress/{address}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<VerifyResult> validateaddress(@PathParam("address") String address) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<VerifyResult> r ;
		try {
			r = new Response<VerifyResult>(rpc.validateaddress(address));
		} catch (Exception e) {
			r = new Response<VerifyResult>(null);
			r.setStatus("ERROR");
			r.setMessage(e.getMessage());
		}
		
		return r;
	}
	
	@GET
	@Path("/gettransaction/{txid}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response<Transaction> gettransaction(@PathParam("txid") String txid) {
		RPCConnection rpc = RPCConnection.getInstance();
		Response<Transaction> r ;
		try {
			r = new Response<Transaction>(rpc.gettransaction(txid));
		} catch (Exception e) {
			r = new Response<Transaction>(null);
			r.setStatus("ERROR");
			r.setMessage(txid + e.getMessage());
		}
		
		return r;
	}
	/*

	
	
	*/
	
	
}
