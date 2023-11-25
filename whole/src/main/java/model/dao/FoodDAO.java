package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Food;

public class FoodDAO {
private JDBCUtil jdbcUtil = null;
	
	public FoodDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

}
