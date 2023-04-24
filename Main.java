import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main{
	
	public static void main(String [] args) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Statement stmt = null;
		
		try {
			String user = "root";  
			String passwd = "";
			String url = "jdbc:mysql://localhost:3306/locadora";
			String driverUrl = "com.mysql.cj.jdbc.Driver";
			
			Class.forName(driverUrl);
			conn = DriverManager.getConnection(url, user, passwd);
			
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
			
			while(rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Login: " + rs.getString("login"));

			}
		} catch (SQLException e) {
			System.out.println("");
		} catch (ClassNotFoundException e) {
			System.out.println("");
		} finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
}

