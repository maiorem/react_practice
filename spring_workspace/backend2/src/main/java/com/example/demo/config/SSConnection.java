package com.example.demo.config;
import java.util.function.Consumer;

import javax.servlet.annotation.WebListener;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@WebListener
public class SSConnection {
	 private static JSch jsch = new JSch();

	    private String url = "106.10.34.210"; //"210.89.190.54";
	    private String username = "root";
	    private String password = "Cool48##";
	    private int port = 1029;  
	    private int lport = 3306;  
	    private int rport = 3306; 
	    private Session session;
	    
	    public SSConnection init(Consumer<Boolean> arg) {  
	        try {
	        	
	            session = jsch.getSession(username, url, port);
	            session.setPassword(password);
	            java.util.Properties config = new java.util.Properties();
	            config.put("StrictHostKeyChecking", "no");
	            session.setConfig(config);
	            session.connect();
	            session.setPortForwardingL(lport, "127.0.0.1", rport);
	            System.out.println("##########################################");
	            
	        } catch (Exception e) {
	        	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
	        }
	        
	        return this;
	    }
	    public void shutdown() throws Exception {
	        if (session != null && session.isConnected()) {
	            session.disconnect();
	        }
	    }
}
