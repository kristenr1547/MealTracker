package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import model.Meal;

public class mealDbUtil {
private DataSource datasource;

public mealDbUtil(DataSource datasource) {
	this.datasource = datasource;
}

public List<Meal> getMeals() throws Exception{
	List<Meal> meals = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM meal";
	try {
		conn = datasource.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("mealID");
			String mealName = rs.getString("mealName");
			String mealType = rs.getString("whichMeal");
			String mealDay = rs.getString("whichDay");
			
			Meal meal = new Meal(id,mealName,mealType,mealDay);
			meals.add(meal);

		}
		return meals;
	}
	finally {
		jdbcUtil.close(conn,stmt,rs);
	}

}


public void addMeal (Meal meal) throws SQLException{
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "INSERT INTO meal(mealName,whichMeal,whichDay) VALUES(?,?,?)";
	try {
		conn = datasource.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, meal.getMealName());
		stmt.setString(2, meal.getMealType());
		stmt.setString(3, meal.getMealDay());
		stmt.executeUpdate();
	}
	finally {
		jdbcUtil.close(conn,stmt,rs);
	}
	
}

public Meal getMeal(int mealID) throws SQLException{
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "SELECT * from meal WHERE mealId = ?";
	try {
		conn = datasource.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, mealID);
		rs = stmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("mealID");
			String mealName = rs.getString("mealName");
			String mealType = rs.getString("whichMeal");
			String mealDay = rs.getString("whichDay");
			Meal meal = new Meal(id,mealName,mealType,mealDay);
			return meal;
		}else {
			return null;
		}
		
	}
	finally {
		jdbcUtil.close(conn,stmt,rs);
	}
	
}

public void updateMeal(Meal meal) throws SQLException {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "UPDATE meal SET mealName = ?, whichMeal = ?, whichDay = ?  WHERE mealId = ?";
	try {
		conn = datasource.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, meal.getMealName());
		stmt.setString(2, meal.getMealType());
		stmt.setString(3, meal.getMealDay());
		stmt.setInt(4, meal.getMealID());
		stmt.executeUpdate();
	}
	finally {
		jdbcUtil.close(conn,stmt,rs);
	}
	
}

}
