package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.MessageEntity;
import model.dao.MessageDAO;
import model.enums.BooleanEnum;
import model.enums.MessageType;

public class MessageTest {
    
    static MessageDAO messageDao = new MessageDAO();


    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
       
        
        
        System.out.print("출력할 메시지함의 소유자 사용자 id를 입력하세요. ");
        printMessageBox(sc.nextLong());
        
        System.out.print("출력할 messageId를 입력하세요 : ");
        MessageEntity message = messageDao.printMessage(sc.nextLong());
        
        System.out.println("보낸 사람 닉네임 : "+message.getSenderId());
        System.out.println("메시지 제목 : "+message.getTitle());
        System.out.println("메시지 내용 : " +message.getContent());
        System.out.println("첨부 사진 링크 : "+message.getImage());
        System.out.println("작성일 : "+message.getRegDate());
        
        
        System.out.println("\n데이터 삽입 test ");
        System.out.println("제목 : 안녕하세요 구매가능할까요?");
        System.out.println("내용 : 글보고연락드려요~");
        System.out.println("작성일 : 2023년 11월 25일 ");
        System.out.println("이미지 주소 :image.jpg ");

        System.out.println("상태 : 아직 안읽음 ");
        System.out.println("전송경로 : 마켓으로부터 전송 ");
        System.out.println("식별값 6이 식별값 2에게 전송 ");
        System.out.println("postID 22 글로부터 전송 ");



        BooleanEnum myBoolean = null;
        MessageType messageType = null;
   
        
//        (Long msgId, Long senderId, Long receiverId, String title, String content, String image,
//                LocalDate reg_date, BooleanEnum is_read, MessageType msgType, Long postId);
        MessageEntity insertMessage = new MessageEntity(
               null, 6L, 2L, "안녕하세요 구매가능할까요?",  
               "글보고연락드려요", "image.jpg", LocalDate.now(), myBoolean.FALES,
               messageType.MARKET, 22L);
        
        
        if(messageDao.sendMessage(insertMessage)) {
            System.out.println("메시지 전송에 성공했습니다 ! ");
        }
        
        System.out.print("출력할 메시지함의 소유자 사용자 id를 입력하세요. ");
        printMessageBox(sc.nextLong());
    }
    
    public static void printMessageBox(Long id) throws SQLException {
        List<MessageEntity> messageList = messageDao.printMessageList(id);
        List<String> messageTitleList = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        
        
        Iterator<MessageEntity> iter = messageList.iterator();
        System.out.println("보낸 사람 닉네임 \t메시지 title \t 생성 시간 \t");

        while (iter.hasNext()) {        
            MessageEntity messageEntity = iter.next();
            String messageSender = messageDao.printMessageSenderNickName(messageEntity.getSenderId());
            System.out.println(messageSender+"\t"+messageEntity.getTitle()+"\t"+messageEntity.getRegDate().format(formatter));
        }
    }

}
