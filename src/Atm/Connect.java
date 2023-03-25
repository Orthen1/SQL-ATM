package Atm;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	static Connection con;
	
	
	static Connection getConnection(){
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accounts","root","root");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			return con;
		
	}
}
