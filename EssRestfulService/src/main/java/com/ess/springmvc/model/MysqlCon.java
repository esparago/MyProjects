package com.ess.springmvc.model;

import java.sql.*;

public class MysqlCon {
	private Statement stmt;
	private Connection con;

	public MysqlCon() {
		try{
			Class.forName("com.mysql.jdbc.Driver");

			//ess is the database name, root is the username and root is the password
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ess","root","root");	
			this.stmt=con.createStatement();	
		}
		catch(Exception e){ 
				System.out.println(e);
		}
	}
	
	public String GetListOfApis() {
		String listofapis = "Restful services = ";
		try{	
			ResultSet rs=this.stmt.executeQuery("select * from restful_services");

			while(rs.next()) {
				//System.out.println(rs.getString(1));
				listofapis = listofapis + ", " + rs.getString(1);
			}
		}
		catch(Exception e){ 
				System.out.println(e);
		}
		return listofapis;
	}
	
	public void closeConnection () {
	
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}