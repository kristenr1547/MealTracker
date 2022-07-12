package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcUtil {

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				//doesn't close the connection just makes it available and puts back in the pool
				conn.close();
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
