package com.socialsend.sendapi.database;

import java.sql.*;

import com._37coins.bcJsonRpc.pojo.NewPaymentParameters;



public class Database {

	// Singleton Variables and Procedures
	private static Database instance = null;
	
	public static Database getInstance() {
      if(instance == null) {
         instance = new Database();
      }
      return instance;
	}
	//End Singleton

	Connection con=null;
	private String host = "140.82.15.8";
	private String port = "3306";
	private String user = "sendapi";
	private String pass = "send1234";
	private String database = "socialsend";
	
	public Database() {
		try {
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
		   System.out.println(e.toString());
		}
		  
		try {
		    con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/" + database,user ,pass);
		  	con.close();
		  	System.out.println("Connected");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
	
	
	private void open() {
		try {
		    con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/" + database,user ,pass);
		  	System.out.println("Connected");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
	
	private void close() {
		try {
			con.close();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
	}
	
	public double getSendBtcPrice() {
		double p = 0;
		PreparedStatement consulta;
		ResultSet resultado;
		  
		try {
			this.open();
			consulta=con.prepareStatement("SELECT price FROM send_btc order by id desc limit 1");
			resultado = consulta.executeQuery();
			if(resultado.next()){
				p = resultado.getDouble("price");
			}
			this.close();
			System.out.println("Price: " + p );
		} catch (SQLException e) {
			System.out.println(e.toString());
			this.close();
			return 0;
		}
		return p;
	}
	
	public double getBtcUsdPrice() {
		double p = 0;
		PreparedStatement consulta;
		ResultSet resultado;
		  
		try {
			this.open();
			consulta=con.prepareStatement("SELECT price FROM btc_usd order by id desc limit 1");
			resultado = consulta.executeQuery();
			if(resultado.next()){
				p = resultado.getDouble("price");
			}
			this.close();
			System.out.println("Price: " + p );
		} catch (SQLException e) {
			System.out.println(e.toString());
			this.close();
			return 0;
		}
		return p;
	}
	
	public double getPesoUsdPrice() {
		double p = 0;
		PreparedStatement consulta;
		ResultSet resultado;
		  
		try {
			this.open();
			consulta=con.prepareStatement("SELECT price FROM peso_usd order by id desc limit 1");
			resultado = consulta.executeQuery();
			if(resultado.next()){
				p = resultado.getDouble("price");
			}
			this.close();
			System.out.println("Price: " + p );
		} catch (SQLException e) {
			System.out.println(e.toString());
			this.close();
			return 0;
		}
		return p;
	}
	
	public double getSendUsdPrice() {
		double send = this.getSendBtcPrice();
		double btc = this.getBtcUsdPrice();
		
		return send * btc;
	}
	
	public double getSendPesoPrice() {
		double send = this.getSendBtcPrice();
		double btc = this.getBtcUsdPrice();
		double peso = this.getPesoUsdPrice();
		
		return send * btc * peso;
	}

	
	public boolean insertPayment(NewPaymentParameters param) {
		PreparedStatement consulta;
		
		try {
			this.open();
			String sql = "insert into payments (emailSender, emailReceiver, depositAddress, amount, confirmations, createTime, expireTime, status) values ('";
			sql += param.getEmailSender() + "', '";
			sql += param.getEmailReceiver() + "', '";
			sql += param.getDepositAddress() + "', '";
			sql += param.getAmount()  + "', '";
			sql += param.getMinimiumConfirmations() + "', ";
			sql += "UNIX_TIMESTAMP(), UNIX_TIMESTAMP() + " + param.getExpire() + ", 'P')";
 			
			consulta=con.prepareStatement(sql);
			consulta.executeQuery();
			
			this.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
			this.close();
			return false;
		}
		return true;
	}
}
