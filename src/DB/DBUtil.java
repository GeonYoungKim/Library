 package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql. *; 

public class DBUtil {
	
	
	public static Connection getConnection(String id,String password) throws ClassNotFoundException, SQLException
	{
		Connection conn=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/gunyoung";
		
		conn=DriverManager.getConnection(url,id,password);
		return conn;
	}
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn,ps);
	}
	public static void close(Connection conn, PreparedStatement ps)
	{
		
		if(ps!=null)
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

}
 