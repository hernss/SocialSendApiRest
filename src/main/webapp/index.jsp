<html>
<title>SocialSend Extended API</title>
<body>
<h2>Implemented commands:</h2>

<p>Basic API commands</p>
<p>API Basic commandas are under http://140.82.15.8:8080/SocialSendApi/api/send/{command}/{parameter}</p>
<table>
<tr><td>getinfo</td><td>Get info about wallet running on server.</td> <td><input id="-1" type="button" url="api/basic/getinfo" value="TEST"/></td></td></tr>
<tr><td>getmasternodecount</td><td>Get how many masternodes are running.</td> <td><input id="-1" type="button" url="api/basic/getmasternodecount" value="TEST"/></td></tr>
<tr><td>getbestblockhash</td><td>Get HASH for the last block generated.</td> <td><input id="-1" type="button" url="api/basic/getbestblockhash" value="TEST"/></td></tr>
<tr><td>getblock/{hash}</td><td>Get block data of block HASH</td> <td><input type="text" id="txt-1"/><input type="button" id="1" url="api/basic/getblock" value="TEST"/></td></td></tr>
<tr><td>getblockchaininfo</td><td>Get information about blockchain</td> <td><input id="-1" type="button" url="api/basic/getblockchaininfo" value="TEST"/></td></tr>
<tr><td>getblockcount</td><td>Get block count</td> <td><input id="-1" type="button" url="api/basic/getblockcount" value="TEST"/></td></tr>
<tr><td>getblockhash/{index}</td><td>Get HASH of block number index</td> <td><input type="text" id="txt-2"/><input type="button" id="2" url="api/basic/getblockhash" value="TEST"/></td></td></tr>
<tr><td>getdifficulty</td><td>Get actual difficulty</td> <td><input id="-1" type="button" url="api/basic/getdifficulty" value="TEST"/></td></tr>
<tr><td>getconnectioncount</td><td>Get connections count for API Service</td> <td><input type="button" url="api/basic/getconnectioncount" value="TEST"/></td></td></tr>
<tr><td>getpeerinfo</td><td>Get info about peers connected to API Service</td> <td><input id="-1" type="button" url="api/basic/getpeerinfo" value="TEST"/></td></tr>
<tr><td>decoderawtransaction/{hex}</td><td>Decode a transaction from hexadecimal block</td> <td><input type="text" id="txt-4"/><input type="button" id="4" url="api/basic/decoderawtransaction" value="TEST"/></td></td></tr>
<tr><td>getrawtransaction/{txid}</td><td>Get hexadecimal code of a transaction identified by txid</td> <td><input type="text" id="txt-5"/><input type="button" id="5" url="api/basic/getrawtransaction" value="TEST"/></td></td></tr>
<tr><td>listmasternodes</td><td>Get a list of every masternodes running</td> <td><input id="-1" type="button" url="api/basic/listmasternodes" value="TEST"/></td></tr>
<tr><td>validateaddress/{address}</td><td>Get if a address is valid or not</td> <td><input type="text" id="txt-6"/><input type="button" id="6" url="api/basic/validateaddress" value="TEST"/></td></td></tr>
<tr><td>gettransaction/{txid}</td><td>Get a complete transaction block by a given txid</td> <td><input type="text" id="txt-7"/><input type="button" id="7" url="api/basic/gettransaction" value="TEST"/></td></td></tr>
</table>	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" >
	
	$( "input[type='button']" ).click(function() {
	   if($( this ).attr("id") != "-1"){
	   		var param = $("#txt-" + $( this ).attr("id")).val();			
	   		var url = $( this ).attr("url") + "/" + param;
	   		window.location = url;
	   }else{
	   		var url = $( this ).attr("url");
	   		window.location = url;
	   }
	});


</script>


</html>
