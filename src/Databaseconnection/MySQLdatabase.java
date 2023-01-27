package Databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLdatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//database connection
		String host ="localhost";
		String port= "3306";
		Connection con =DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port + "/Test" ,"root","@Gabriel123");
		//connection URL: jdbc:mysql://"10.1.7.111":"/USSD_AIRTIME";
		Statement s=con.createStatement();
		ResultSet result=s.executeQuery("select * from demo'");
		while(result.next()) 
		{
			//result.next() is to leave the first
			System.out.println(result.getString("name"));
			System.out.println(result.getString("id"));
		}
		
	}

}
