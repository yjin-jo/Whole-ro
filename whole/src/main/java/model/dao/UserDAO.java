package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserEntity;
import model.enums.GenderEnum;



/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */

public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
     * 사용자 관리 테이블에 새로운 사용자 생성.
     */
       /**
     * 사용자 관리 테이블에 새로운 사용자 생성.
     */
       /**
     * 사용자 관리 테이블에 새로운 사용자 생성.
     */
	public int create(UserEntity user) throws SQLException {
        String sql = "INSERT INTO USER_TABLE VALUES (SEQUENCE_USERID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";       
        Object[] param = new Object[] { user.getEmail(), 
                user.getPassword(), user.getNickname(), user.getGender().toString(),
                user.getIntroduction(), user.getInterest(), user.getAddress(),
                user.getReportCount()};             
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
                        
        try {               
            int result = jdbcUtil.executeUpdate();  // insert 문 실행
            System.out.println(result);
            System.out.println("삽입에 성공했습니다.");
            return result;
            
            // insert 문 실행
        } catch (Exception ex) {
            jdbcUtil.rollback();// resource 반환// resource 반환
            ex.printStackTrace();// resource 반환
        } finally {     
            jdbcUtil.commit();// resource 반환
            jdbcUtil.close();   // resource 반환
        }       
        return 0;           
    }

    /**
     * 기존의 사용자 정보를 수정.
     */
    public int update(UserEntity user) throws SQLException {
        String sql = "UPDATE USER_TABLE "
                    + "SET password=?, nickname=?, introduction=?, interest=?, address=? "
                    + "WHERE email=?";
        Object[] param = new Object[] {user.getPassword(), user.getNickname(), 
                    user.getIntroduction(), user.getInterest(), user.getAddress(),
                    user.getEmail()};              
        jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil에 update문과 매개 변수 설정
            
        try {               
            int result = jdbcUtil.executeUpdate();  // update 문 실행
            System.out.println("수정에 성공했습니다.");
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }

    /**
     * 사용자 ID에 해당하는 사용자를 삭제.
     */
    public int remove(String email) throws SQLException {
        String sql = "DELETE FROM USER_TABLE WHERE email=?";       
        jdbcUtil.setSqlAndParameters(sql, new Object[] {email});   // JDBCUtil에 delete문과 매개 변수 설정

        try {               
            int result = jdbcUtil.executeUpdate();  // delete 문 실행
            System.out.println(result);
            System.out.println("삭제에 성공했습니다.");
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        }
        finally {
            jdbcUtil.commit();
            jdbcUtil.close();   // resource 반환
        }       
        return 0;
    }

    /**
     * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
     * 저장하여 반환.
     */
    /**
     * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
     * 저장하여 반환.
     */
    public UserEntity findUser(String interest) throws SQLException {
        String sql = "SELECT nickname, introduction, interest "
                    + "FROM USER_TABLE "
                    + "WHERE interest=? ";              
        jdbcUtil.setSqlAndParameters(sql, new Object[] {interest}); // JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();     // query 실행
            if (rs.next()) {                        // 학생 정보 발견
                UserEntity user = new UserEntity(       // User 객체를 생성하여 학생 정보를 저장
                    rs.getString("nickname"),
                    rs.getString("introdution"),
                    "interest");
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }

    /**
     * 전체 사용자 정보를 검색하여 List에 저장 및 반환
     */
    public List<UserEntity> findUserList(String email) throws SQLException {
        String sql =  "SELECT * "
                    + "FROM USER_TABLE "
                    + "WHERE email=? " 
                    + "ORDER BY user_id";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {email});     // JDBCUtil에 query문 설정
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();         // query 실행         
            List<UserEntity> userList = new ArrayList<UserEntity>();    // User들의 리스트 생성
            while (rs.next()) {
                UserEntity user = new UserEntity();           // User 객체를 생성하여 현재 행의 정보를 저장
                user.setUserId(rs.getLong("user_id"));
                user.setEmail(email);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setGender(GenderEnum.valueOf(rs.getString("gender")));
                user.setIntroduction(rs.getString("introduction"));
                user.setInterest(rs.getString("interest"));
                user.setAddress(rs.getString("address"));
                user.setReportCount(rs.getInt("report_count"));
                userList.add(user);             // List에 User 객체 저장
            }       
            System.out.println(userList);
            return userList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }
    
    public List<UserEntity> findUserWithWithList(String interest) throws SQLException {
        String sql =  "SELECT user_id, nickname, introduction, interest "
                    + "FROM USER_TABLE "
                    + "WHERE interest=? " 
                    + "ORDER BY user_id";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {interest});     // JDBCUtil에 query문 설정
                    
        try {
            ResultSet rs = jdbcUtil.executeQuery();         // query 실행         
            List<UserEntity> userList = new ArrayList<UserEntity>();    // User들의 리스트 생성
            while (rs.next()) {
                UserEntity user = new UserEntity();           // User 객체를 생성하여 현재 행의 정보를 저장
                user.setNickname(rs.getString("nickname")); 
                user.setIntroduction(rs.getString("introduction"));
                user.setInterest(interest);
                userList.add(user);             // List에 User 객체 저장
            }       
            
            return userList;                    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return null;
    }

 
	/**
	 * 특정 커뮤니티에 속한 사용자들을 검색하여 List에 저장 및 반환
	 */
	//public List<User> findUsersInCommunity(int communityId) throws SQLException {
        //String sql = "SELECT userId, name, email, phone FROM UserInfo "
 //    				+ "WHERE commId = ?";                         
	///	jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil에 query문과 매개 변수 설정
		
	//	try {
	//		ResultSet rs = jdbcUtil.executeQuery();		// query 실행
	//		List<User> memList = new ArrayList<User>();	// member들의 리스트 생성
	//		while (rs.next()) {
	//			User member = new User(			// User 객체를 생성하여 현재 행의 정보를 저장
	//				rs.getString("userId"),
	//				rs.getString("name"),
	//				rs.getString("email"),
	//				rs.getString("phone"));
	//			memList.add(member);			// List에 Community 객체 저장
	//		}		
	//		return memList;					
	//			
	//	} catch (Exception ex) {
	//		ex.printStackTrace();
	//	} finally {
	//		jdbcUtil.close();		// resource 반환// resource 반환
	//	}
	//	return null;
	//}
	
	/**
	 * 특정 커뮤니티에 속한 사용자들의 수를 count하여 반환
	 */
	//public int getNumberOfUsersInCommunity(int communityId) {
	//	String sql = "SELECT COUNT(userId) FROM UserInfo "
     //				+ "WHERE commId = ?";              
	//	jdbcUtil.setSqlAndParameters(sql, new Object[] {communityId});	// JDBCUtil에 query문과 매개 변수 설정
	//	
	//	try {
	//		ResultSet rs = jdbcUtil.executeQuery();		// query 실행
	///		rs.next();										
	//		return rs.getInt(1);			
	//	} catch (Exception ex) {
	//		ex.printStackTrace();
	//	} finally {
	//		jdbcUtil.close();		// resource 반환
	//	}
	//	return 0;
	//}
	
	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String email) throws SQLException {
		String sql = "SELECT count(*) FROM USER_TABLE WHERE email=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public boolean existingUserNickname(String nickname) throws SQLException {
        String sql = "SELECT count(*) FROM USER_TABLE WHERE nickname=?";      
        jdbcUtil.setSqlAndParameters(sql, new Object[] {nickname});    // JDBCUtil에 query문과 매개 변수 설정

        try {
            ResultSet rs = jdbcUtil.executeQuery();     // query 실행
            if (rs.next()) {
                int count = rs.getInt(1);
                return (count == 1 ? true : false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // resource 반환
        }
        return false;
    }


}
