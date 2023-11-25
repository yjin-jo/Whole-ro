package model;

import java.util.Date;

import model.enums.BooleanEnum;
import model.enums.MessageType;

public class Message {
   
    private Long msgId;
    private Long senderId;
    private Long receiverId;
    private String title;
    private String content;
    private String image;
    private Date reg_date;
    private BooleanEnum is_read;
    private MessageType msgType;
    
    public Message(Long msgId, Long senderId, Long receiverId, String title, String content, String image,
            Date reg_date, BooleanEnum is_read, MessageType msgType) {
        super();
        this.msgId = msgId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.reg_date = reg_date;
        this.is_read = is_read;
        this.msgType = msgType;
    }
    public Long getMsgId() {
        return msgId;
    }
    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }
    public Long getSenderId() {
        return senderId;
    }
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
    public Long getReceiverId() {
        return receiverId;
    }
    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Date getReg_date() {
        return reg_date;
    }
    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
    public BooleanEnum getIs_read() {
        return is_read;
    }
    public void setIs_read(BooleanEnum is_read) {
        this.is_read = is_read;
    }
    public MessageType getMsgType() {
        return msgType;
    }
    public void setMsgType(MessageType msgType) {
        this.msgType = msgType;
    }
    
    

}
