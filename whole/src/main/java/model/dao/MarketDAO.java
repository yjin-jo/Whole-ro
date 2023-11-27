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

    // post 
    
    // 타입 상관없이 모든 글을 보여주기
    public List<Item> findItemListAllType() throws SQLException {

        String sql = "SELECT post_id, title, type, content, image,reg_date, writer_id,cnt_like,detail,price,scrap "
                + "FROM ITEM JOIN POST USING (post_id) "
                + "WHERE type = 'MARKET' OR type='MY_REFRIGERATOR'";

        jdbcUtil.setSqlAndParameters(sql,null); // JDBCUtil에 query문 설정

  
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
           
            List<Item> allitemList = new ArrayList<Item>(); // 타입이 Market인 Post 리스트 생성
            while (rs.next()) {
                Item item = new Item();
                item.setPost_id(rs.getLong("post_id"));// post 객체를 생성하여 현재 행의 정보를 저장
                item.setTitle(rs.getString("title"));
                item.setType(rs.getString("type"));
                item.setContent(rs.getString("content"));
                item.setImage(rs.getString("image"));
                item.setReg_date(rs.getDate("reg_date").toLocalDate());
                item.setWriter_id(rs.getLong("writer_id"));
                item.setCnt_like(rs.getInt("cnt_like"));
                item.setDetail(rs.getString("detail"));
                item.setPrice(rs.getLong("price"));
                item.setScrap(rs.getInt("scrap"));
                allitemList.add(item);             // List에 post 객체 저장
            }
            return allitemList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }
    
    // 글 중에서 타입에 따라서 아이템 글 리스트을 보여주기
    public List<Item> findItemListType(String type) throws SQLException {

        String sql = "SELECT post_id, title, type, content, image,reg_date, writer_id,cnt_like,detail,price,scrap "
                + "FROM ITEM JOIN POST USING (post_id) "
                + "WHERE type = ? ";

        jdbcUtil.setSqlAndParameters(sql,  new Object[]{type}); // JDBCUtil에 query문 설정

  
        try {
            ResultSet rs = jdbcUtil.executeQuery(); // query 실행
           
            List<Item> itemList = new ArrayList<Item>(); // 타입이 Market인 Post 리스트 생성
            while (rs.next()) {
                Item item = new Item();
                item.setPost_id(rs.getLong("post_id"));// post 객체를 생성하여 현재 행의 정보를 저장
                item.setTitle(rs.getString("title"));
                item.setType(rs.getString("type"));
                item.setContent(rs.getString("content"));
                item.setImage(rs.getString("image"));
                item.setReg_date(rs.getDate("reg_date").toLocalDate());
                item.setWriter_id(rs.getLong("writer_id"));
                item.setCnt_like(rs.getInt("cnt_like"));
                item.setDetail(rs.getString("detail"));
                item.setPrice(rs.getLong("price"));
                item.setScrap(rs.getInt("scrap"));
                itemList.add(item);             // List에 post 객체 저장
            }
            return itemList;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // resource 반환
        }
        return null;
    }
    // 글 제목으로 select해서 상세 글 보이도록
    // 사진, 제목, 가격, 지역, 태그, 업로드 날짜 가져오기
    public Item findItemDetail(String type,String title) throws SQLException {

    String sql = "SELECT post_id, item.cnt_like,item.detail, item.price,item.scrap, post.title, post.image,post.type,post.content,post.reg_date,post.writer_id "
            + "FROM ITEM JOIN POST USING (post_id) "
            + "WHERE post.type = ? and post.title = ?";
    
    jdbcUtil.setSqlAndParameters(sql, new Object[]{type, title}); // JDBCUtil에 query문 설정
 
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
