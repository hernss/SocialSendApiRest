package com._37coins.bcJsonRpc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com._37coins.bcJsonRpc.pojo.Account;
import com._37coins.bcJsonRpc.pojo.Address;
import com._37coins.bcJsonRpc.pojo.AddressInformation;
import com._37coins.bcJsonRpc.pojo.Block;
import com._37coins.bcJsonRpc.pojo.BlockChainInfo;
import com._37coins.bcJsonRpc.pojo.BlockHeader;
import com._37coins.bcJsonRpc.pojo.DecodedTransaction;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.LastBlock;
import com._37coins.bcJsonRpc.pojo.Masternode;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com._37coins.bcJsonRpc.pojo.PeerInfo;
import com._37coins.bcJsonRpc.pojo.Transaction;
import com._37coins.bcJsonRpc.pojo.VerifyResult;



public interface BitcoindInterface {
	
	//Returns an object containing various state info.
	public Info getinfo();
	
	
	//Get hash for best block
	public String getbestblockhash();
	
	//Get Block by hash
	public Block getblock(String hash);
	
	//Get info about blockchain status
	public BlockChainInfo getblockchaininfo();
	
	//Get block count
	public BigDecimal getblockcount();
	
	//Get block hash by height on blockchain
	public String getblockhash(BigDecimal index);
	
	//Get Actual Difficulty
	public double getdifficulty();
	
	//Get block header by block hash
	public BlockHeader getblockheader(String hash);
	
	//Get connection counts
	public long getconnectioncount();
	
	//Get info about peers connected
	public List<PeerInfo> getpeerinfo();
	
	//decode transaction from hexstring
	public DecodedTransaction decoderawtransaction(String hexstring);
	
	//Get hexstring from transaction id
	public String getrawtransaction(String txid);
	
	//get info about masternodes currently running	
	public MasternodeCount getmasternodecount();
	
	//Get List of masternodes
	public List<Masternode> listmasternodes();
	
	//Verify if a addres is a valid one
	public VerifyResult validateaddress(String  sendaddress);
	/*

	  
	*/
	
	
}
