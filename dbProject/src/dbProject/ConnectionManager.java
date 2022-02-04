package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	public Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/shopdb";
		String driver = "com.mysql.cj.jdbc.Driver";
		String id = "root";
		String pwd = "mcys1309";
		try {
			//driver로딩
			Class.forName(driver);
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다.");
		}

		try {
			con = DriverManager.getConnection(url,id,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("컨넥션을 만들 수 없습니다.");
		}
		return con;
	}
	public void closeConnection(Connection con,Statement stmt,ResultSet rs) {
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
