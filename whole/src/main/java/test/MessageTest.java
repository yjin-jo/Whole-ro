package test;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.MessageEntity;
import model.dao.MessageDAO;

public class MessageTest {

    public static void main(String[] args) throws Exception {
        MessageDAO messageDao = new MessageDAO();
        
        Scanner sc = new Scanner(System.in);
        
        
        List<String> messageTitleList = new ArrayList<>();
        
        System.out.println("출력할 메시지함의 소유자 사용자 id를 입력하세요. ");
        List<MessageEntity> messageList = messageDao.printMessageList(sc.nextLong());
         
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        
        
        Iterator<MessageEntity> iter = messageList.iterator();
        System.out.println("보낸 사람 닉네임 \t메시지 title \t 생성 시간 \t");

        while (iter.hasNext()) {        
            MessageEntity messageEntity = iter.next();
            String messageSender = messageDao.printMessageSenderNickName(messageEntity.getSenderId());
            System.out.println(messageSender+"\t"+messageEntity.getTitle()+"\t"+messageEntity.getRegDate().format(formatter));
        }
        
//        rs.getLong("msg_id"),
//        rs.getLong("sender_id"),
//        null,
//        rs.getString("title"),
//        rs.getString("content"),
//        rs.getString("image"),
//        rs.getDate("reg_date").toLocalDate(),
//        null,
//        null
        
        System.out.println("출력할  messageId를 입력하세요  ");
        MessageEntity message = messageDao.printMessage(sc.nextLong());
        
        System.out.println("보낸 사람 닉네임 : "+message.getSenderId());
        System.out.println("메시지 제목 : "+message.getTitle());
        System.out.println("메시지 내용 : " +message.getContent());
        System.out.println("첨부 사진 링크 : "+message.getImage());
        System.out.println("작성일 : "+message.getRegDate());
        
    }

}
