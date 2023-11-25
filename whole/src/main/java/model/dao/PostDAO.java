//package model.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class PostDAO {
//
//    public static void printDeptInfo(String deptName) {
//
//        Connection conn = null;
//        PreparedStatement pStmt = null;
//        ResultSet rs = null;
//
//        StringBuilder query = new StringBuilder();
//        query.append("SELECT deptno, manager, COUNT(empno) AS numOfEmps ");
//        query.append("FROM EMP0000 JOIN DEPT0000 USING (deptno) ");
//        query.append("WHERE dname = ? ");
//
//        query.append("GROUP BY deptno, manager");
//
//        
//
//        try {
//
//            conn = getConnection();     // DBMS와의 연결 획득 
//
//            pStmt = conn.prepareStatement(query.toString());    // Connection에서 PreparedStatement 객체 생성
//
//            pStmt.setString(1, deptName);   // PreparedStatement에 매개변수 값 설정
//
//            rs = pStmt.executeQuery();   // 질의 실행
//
//            
//
//            if (rs.next()) {    // 질의 결과 존재 (결과는 최대 하나의 행)
//
//                System.out.println("<부서정보>");
//
//                System.out.println("부서번호: " + rs.getInt("deptno"));
//
//                System.out.println("부서명: " + deptName);
//
//                System.out.println("관리자사번: " + rs.getInt("manager"));
//
//                System.out.println("사원 수: " + rs.getInt("numOfEmps"));
//
//                System.out.println();
//
//            }           
//
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//
//        } finally {     // 자원 반납
//
//            if (rs != null) 
//
//                try { 
//
//                    rs.close(); 
//
//                } catch (SQLException ex) { ex.printStackTrace(); }
//
//            if (pStmt != null) 
//
//                try { 
//
//                    pStmt.close(); 
//
//                } catch (SQLException ex) { ex.printStackTrace(); }
//
//            if (conn != null) 
//
//                try { 
//
//                    conn.close(); 
//
//                } catch (SQLException ex) { ex.printStackTrace(); }
//
//        }   
//
//    }
//
//}
