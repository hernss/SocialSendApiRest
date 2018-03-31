package com._37coins.bcJsonRpc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com._37coins.bcJsonRpc.pojo.Account;
import com._37coins.bcJsonRpc.pojo.Address;
import com._37coins.bcJsonRpc.pojo.AddressInformation;
import com._37coins.bcJsonRpc.pojo.Block;
import com._37coins.bcJsonRpc.pojo.BlockChainInfo;
import com._37coins.bcJsonRpc.pojo.Info;
import com._37coins.bcJsonRpc.pojo.LastBlock;
import com._37coins.bcJsonRpc.pojo.MasternodeCount;
import com._37coins.bcJsonRpc.pojo.Transaction;



public interface BitcoindInterface {
	
	//Returns an object containing various state info.
	public Info getinfo();
	//get info about masternodes currently running	
	public MasternodeCount getmasternodecount();
	
	
	public String getbestblockhash();
	
	public Block getblock(String hash);
	
	public BlockChainInfo getblockchaininfo();
	
	public BigDecimal getblockcount();
	
	public String getblockhash(BigDecimal index);
	
	public double getdifficulty();
	
	
	/*getblockheader "hash" ( verbose )
	getchaintips
	
	getmempoolinfo
	getrawmempool ( verbose )
	gettxout "txid" n ( includemempool )
	gettxoutsetinfo
	verifychain ( checklevel numblocks )
*/
	
	
}
