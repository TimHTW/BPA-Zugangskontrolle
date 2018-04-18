package DB;

import java.sql.*;

public class DBConnection {
	public static void main(String args[])
    { 
	    try 
	    	{
		         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		         String connectionUrl = "jdbc:sqlserver://LAPTOP-SF5SKVRR\\SQLEXPRESS;" +
		                                 "databaseName=Umsatz;" +
		                                 "integratedSecurity=true";
		         Connection con = DriverManager.getConnection(connectionUrl);
		         System.out.println("Connected.");
		
		         String SQL = "Select Name FROM Mitarbeiter;"; 
		         Statement stmt = con.createStatement(); 
		         ResultSet rs = stmt.executeQuery(SQL);
		 
		         while (rs.next()) 
		         { 
		            System.out.println(rs.getString(1)); 
		         }
	
	    	} 
	    	catch(Exception e) 
	    	{
	         System.out.println(e);
	         System.exit(0); 
	    	}
    }
}
