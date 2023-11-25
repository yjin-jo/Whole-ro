package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Food;
import model.MessageEntity;
import model.enums.BooleanEnum;
import model.enums.MessageType;

public class MessageDAO {
private JDBCUtil jdbcUtil = null;
    
    public MessageDAO() {          
        jdbcUtil = new JDBCUtil();  // JDBCUtil 객체 생성
    }
    
    public String printMessageSenderNickName(Long id) {
        String sql = "SELECT nickname "
                + "FROM user_table "
                + "where user_id=? ";
        
     jdbcUtil.setSqlAndParameters(sql, new Object[] { id });

     try {
         ResultSet rs = jdbcUtil.executeQuery();         // query 실행         
         String nickname = "";
         if (rs.next()) {
            nickname = rs.getString("nickname");
         }       
         
         return nickname;                    
         
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         jdbcUtil.close();       // resource 반환
     }
     return null;
        
    }

    public List<MessageEntity> printMessageList(Long id) throws SQLException {
        String sql = "SELECT msg_id, sender_id, title, reg_date "
                + "FROM message "
                + "where receiver_id = ? ";
        
     jdbcUtil.setSqlAndParameters(sql, new Object[] { id });        // JDBCUtil에 query문 설정
                 
//     
//     private Long msgId;
//     private Long senderId;
//     private Long receiverId;
//     private String title;
//     private String content;
//     private String image;
//     private Date reg_date;
//     private BooleanEnum is_read;
//     private MessageType msgType;
     
     
     try {
         ResultSet rs = jdbcUtil.executeQuery();         // query 실행         
         List<MessageEntity> messageList = new ArrayList<MessageEntity>();    // Community들의 리스트 생성
         
         while (rs.next()) {
     
             
             MessageEntity message = new MessageEntity(
                     rs.getLong("msg_id"),
                     rs.getLong("sender_id"),
                     null,
                     rs.getString("title"),
                     null,
                     null, 
                     rs.getDate("reg_date").toLocalDate(),
                     null,
                     null
                     );
             messageList.add(message);
         }       
         
         return messageList;                    
         
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         jdbcUtil.close();       // resource 반환
     }
     return null;
 }
   
    public MessageEntity printMessage(Long id) throws SQLException {
        String sql = "SELECT sender_id, title, content, image, reg_date "
                + "FROM message "
                + "where msg_id = ? ";
        
     jdbcUtil.setSqlAndParameters(sql, new Object[] { id });        // JDBCUtil에 query문 설정
               
     try {
         ResultSet rs = jdbcUtil.executeQuery();         // query 실행                  
         if (rs.next()) {
             MessageEntity message = new MessageEntity(
                     id,
                     rs.getLong("sender_id"),
                     null,
                     rs.getString("title"),
                     rs.getString("content"),
                     rs.getString("image"),
                     rs.getDate("reg_date").toLocalDate(),
                     null,
                     null
                     );
             return message;
         }                        
         
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         jdbcUtil.close();       // resource 반환
     }
     return null;
 }
    
    
    TITLE, CONTENT, IMAGE, REG_DATE, IS_READ, MSG_TYPE, MSG_ID, SENDER_ID, RECEIVER_ID, POST_ID
    
   public MessageEntity sendMessage(MessageEntity message) throws SQLException {
       
        String title = message.getTitle();
        String content = message.getContent();
        LocalDate regDate = message.getRegDate();
        BooleanEnum is_read = message.getIsRead();
        
        
        
        
        String sql = "INSERT INTO message "
                + "(TITLE, CONTENT, IMAGE, REG_DATE, IS_READ, MSG_TYPE, MSG_ID, SENDER_ID, RECEIVER_ID, POST_ID) "
                + "VAULES(? ,?, ?, ?, ?, ?, SEQUENCE_MESSAGEID.nextval, ?, ?, ?)  ";
                
        
     jdbcUtil.setSqlAndParameters(sql, new Object[] { id });        // JDBCUtil에 query문 설정
               
     try {
         ResultSet rs = jdbcUtil.executeQuery();         // query 실행                  
         if (rs.next()) {
             MessageEntity message = new MessageEntity(
                     id,
                     rs.getLong("sender_id"),
                     null,
                     rs.getString("title"),
                     rs.getString("content"),
                     rs.getString("image"),
                     rs.getDate("reg_date").toLocalDate(),
                     null,
                     null
                     );
             return message;
         }                        
         
     } catch (Exception ex) {
         ex.printStackTrace();
     } finally {
         jdbcUtil.close();       // resource 반환
     }
     return null;
 }
   
}
