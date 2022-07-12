package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
import model.Meal;

public class itemDbUtil {
	
	private DataSource datasource;

	public itemDbUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Item> getItems() throws Exception{
		List<Item> items = new ArrayList<>();
		Connection conn;
		Statement stmt;
		ResultSet rs;
		String sql = "SELECT * FROM item";
		try {
			
			conn = datasource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
			
			}
			return items;
		}
		finally {
			
		}

	}
	
	
}
