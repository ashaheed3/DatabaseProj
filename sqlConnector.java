package application;



	import java.sql.*;

	public class sqlConnector {
		
		
		public static  Connection Connector() {
			
			 String url = "jdbc:mysql://localhost:3306/ecomm";
			 String username = "root";
			 String password = "10Isanumber";
						
			try {
				
				Connection conn = DriverManager.getConnection(url,username,password);
				return conn;
			} catch (Exception exc) {
				exc.printStackTrace();
				return null;
			}
		}
	}
	

