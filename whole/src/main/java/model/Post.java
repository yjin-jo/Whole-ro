package model;

import java.util.Date;

public class Post {
    protected Long post_id;
    protected String title;
    protected String type;
    protected String content;
    protected String image;
    protected Date reg_date;
    protected Long writer_id;

    public Post(Long post_id, String title, String type, String content, String image, Date reg_date, Long writer_id) {
        super();
        this.post_id = post_id;
        this.title = title;
        this.type = type;
        this.content = content;
        this.image = image;
        this.reg_date = reg_date;
        this.writer_id = writer_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Long getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(Long writer_id) {
        this.writer_id = writer_id;
    }

}
