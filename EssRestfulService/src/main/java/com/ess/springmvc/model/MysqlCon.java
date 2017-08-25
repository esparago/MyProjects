package com.ess.springmvc.model;

import java.sql.*;

public class MysqlCon {
	private Statement stmt;
	private Connection con;

	public MysqlCon() {
		try{
			Class.forName("com.mysql.jdbc.Driver");

			//LOCAL: ess is the database name, root is the username and root is the password
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ess","root","root");
			
			//AWS: ess is the database name, root is the username and root1234 is the password
			//this.con=DriverManager.getConnection("jdbc:mysql://ess.cuof1rkzi6j1.us-east-2.rds.amazonaws.com:3306/ess","root","root1234");
			
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
				listofapis = listofapis + ", " + rs.getString(1);
			}
		}
		catch(Exception e){ 
				System.out.println(e);
		}
		return listofapis;
	}

	public void createUser(String aName, String aRole) {
		String update = "insert into users (name, role) values (\"" + aName +"\",\""+aRole+"\")";
		System.out.println(update);
		try{	
			this.stmt.executeUpdate(update);
		}
		catch(Exception e){ 
				System.out.println(e);
		}
	}
	
	public void deleteUser(String aName) {
		String delete = "delete from users where name="+"\"" + aName + "\"";
		System.out.println(delete);
		try{	
			this.stmt.executeUpdate(delete);
		}
		catch(Exception e){ 
				System.out.println(e);
		}
	}
	
	public void closeConnection () {
	
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
}