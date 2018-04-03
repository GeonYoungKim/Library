package admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class Main {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AdminBtnEventHandler adminBtnEventHandler=new AdminBtnEventHandler();
		Firstf f=new Firstf(adminBtnEventHandler);
		f.start();
		
	}
}
