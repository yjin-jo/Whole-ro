package model;

import java.time.LocalDate;
import java.util.Date;

import model.enums.BooleanEnum;
import model.enums.MessageType;

public class MessageEntity {
   
    private Long msgId;
    private Long senderId;
    private Long receiverId;
    private String title;
    private String content;
    private String image;
    private LocalDate regDate;
    private BooleanEnum isRead;
    private MessageType msgType;
    private Long postId;
    
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public MessageEntity() {
       
    }
    
    public MessageEntity(Long msgId, Long senderId, Long receiverId, String title, String content, String image,
            LocalDate reg_date, BooleanEnum isRead, MessageType msgType, Long postId) {
        super();
        this.msgId = msgId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.regDate = reg_date;
        this.isRead = isRead;
        this.msgType = msgType;
        this.postId = postId;
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
    public LocalDate getRegDate() {
        return regDate;
    }
    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }
    public BooleanEnum getIsRead() {
        return isRead;
    }
    public void setIsRead(BooleanEnum is_read) {
        this.isRead = is_read;
    }
    public MessageType getMsgType() {
        return msgType;
    }
    public void setMsgType(MessageType msgType) {
        this.msgType = msgType;
    }
    
    @Override
    public String toString() {
        return "MessageEntity [msgId=" + msgId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", title="
                + title + ", content=" + content + ", image=" + image + ", regDate=" + regDate + ", isRead=" + isRead
                + ", msgType=" + msgType + ", postId=" + postId + "]";
    }

}
