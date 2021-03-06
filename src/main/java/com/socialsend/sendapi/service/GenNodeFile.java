package com.socialsend.sendapi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.StreamingOutput;

import com._37coins.bcJsonRpc.pojo.PeerInfo;
import com.socialsend.sendapi.rpc.RPCConnection;


@Path("/nodefile")
public class GenNodeFile {
	
	@GET
	@Path("/download")
	@Produces("text/plain")
	public Response downloadFile(@HeaderParam("user-agent") String userAgent) {
		RPCConnection rpc = RPCConnection.getInstance();
		 
		try {
			@SuppressWarnings("unused")
			List<PeerInfo> r = rpc.getpeerinfo();
		} catch (Exception e) {
			return Response.status(Status.NOT_FOUND).build();
		}

		String fileName = "addnode.txt";
		StreamingOutput fileStream;
		
		if(userAgent.indexOf("Linux") >= 0) {
			//if client is running on linux
			fileName = "addnode.sh";
			fileStream =  new StreamingOutput()
	        {
	            
	            public void write(java.io.OutputStream output)
	            {
	            	RPCConnection rpc = RPCConnection.getInstance();
	            	for(PeerInfo p: rpc.getpeerinfo()) {
	        			String line = "send-cli addnode " + p.getAddr() + " add\r\n";
	        			
	        			try {
	        				output.write(line.getBytes());
							output.flush();
							
						} catch (IOException e) {
							e.printStackTrace();
						}
	        		}
	                
	            }
	        };
		}else {
			//Other os than linux
			fileName = "addnode.txt";
			fileStream =  new StreamingOutput()
	        {
	            
	            public void write(java.io.OutputStream output)
	            {
	            	RPCConnection rpc = RPCConnection.getInstance();
	            	for(PeerInfo p: rpc.getpeerinfo()) {
	        			String line = "addnode " + p.getAddr() + " add\r\n";
	        			
	        			try {
	        				output.write(line.getBytes());
							output.flush();
							
						} catch (IOException e) {
							e.printStackTrace();
						}
	        		}
	                
	            }
	        };
		}
		
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = " + fileName)
                .build();
		
		
	}
	
	@GET
    @Path("/bootstrap")
    public Response downloadPdfFile()
    {
        StreamingOutput fileStream =  new StreamingOutput()
        {
            
            public void write(java.io.OutputStream output)
            {
                try
                {
                    java.nio.file.Path path = Paths.get("/home/sendapi/bootstrap.zip");
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                }
                catch (Exception e)
                {
                	e.printStackTrace();                
                }
            }
        };
        
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = bootstrap.zip")
                .build();
    }
	
}
