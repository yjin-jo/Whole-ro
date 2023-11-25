package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Community;
import model.Food;

public class FoodDAO {
private JDBCUtil jdbcUtil = null;
	
	public FoodDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	public List<Food> findFoodList() throws SQLException {
		//나의 냉장고 확인 화면
        String sql = "SELECT post_id, title, image, exp_date, reg_date "
        		   + "FROM FOOD JOIN POST USING (post_id) "
        		   + "ORDER BY reg_date";        
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Food> foodList = new ArrayList<Food>();	// Community들의 리스트 생성
			while (rs.next()) {
				Food food = new Food();
				food.setPost_id(rs.getLong("post_id"));// Community 객체를 생성하여 현재 행의 정보를 저장
				food.setTitle(rs.getString("title"));
				food.setImage(rs.getString("image"));
				food.setExp_date(rs.getDate("exp_date"));
				food.setReg_date(rs.getDate("reg_date").toLocalDate());
				foodList.add(food);				// List에 Community 객체 저장
			}		
			return foodList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
