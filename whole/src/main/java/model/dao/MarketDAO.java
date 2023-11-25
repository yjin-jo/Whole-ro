package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Post;

public class MarketDAO {
    private JDBCUtil jdbcUtil = null;

    public MarketDAO() {
        jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
    }

    // 냉장고
    // 글 중에서 타입이 마켓인 사용자의 글을 보여주기
    public List<Post> findtypeMarketPost() throws SQLException {

        String sql = "SELECT post_id, title, type, content, image,reg_date, writer_id "
                + "FROM POST "
                + "WHERE type = 'MARKET'";

        jdbcUtil.setSqlAndParameters(sql, null); // JDBCUtil에 query문 설정

  
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
           
            List<Post> postList = new ArrayList<Post>(); // 타입이 Market인 Post 리스트 생성
            while (rs.next()) {
                Post post = new Post();
                post.setPost_id(rs.getLong("post_id"));// post 객체를 생성하여 현재 행의 정보를 저장
                post.setTitle(rs.getString("title"));
                post.setType(rs.getString("type"));
                post.setContent(rs.getString("content"));
                post.setImage(rs.getString("image"));
                post.setReg_date(rs.getDate("reg_date").toLocalDate());
                post.setWriter_id(rs.getLong("writer_id"));
                postList.add(post);             // List에 post 객체 저장
            }
            return postList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }
    // 글 제목으로 select해서 상세 글 보이도록
    // 사진, 제목, 가격, 지역, 태그, 업로드 날짜 가져오기
    public Item findPostDetail(String title) throws SQLException {

    String sql = "SELECT post_id, item.cnt_like,item.detail, item.price,item.scrap, post.title, post.image,post.type,post.content,post.reg_date,post.writer_id "
            + "FROM ITEM JOIN POST USING (post_id) "
            + "WHERE post.type = 'MARKET' and post.title = ?";
    
    jdbcUtil.setSqlAndParameters(sql, new Object[]{title}); // JDBCUtil에 query문 설정
 
    try {
        ResultSet rs = jdbcUtil.executeQuery(); // query 실행
   
        if(rs.next()) {
            Item item = new Item();
            item.setPost_id(rs.getLong("post_id"));// post 객체를 생성하여 현재 행의 정보를 저장
            item.setCnt_like(rs.getInt("cnt_like"));
            item.setDetail(rs.getString("detail"));
            item.setPrice(rs.getLong("price"));
            item.setScrap(rs.getInt("scrap"));
            item.setTitle(rs.getString("title"));
            item.setImage(rs.getString("image"));
            item.setType(rs.getString("type"));
            item.setContent(rs.getString("content"));
            item.setReg_date(rs.getDate("reg_date").toLocalDate());
            item.setWriter_id(rs.getLong("writer_id"));

            return item;         
        }
      

    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        jdbcUtil.close(); // resource 반환
    }
    return null;
}
}
