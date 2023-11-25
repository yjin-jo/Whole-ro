package model;

import java.sql.Date;
import java.time.LocalDate;

public class Item extends Post {

    private int cnt_like;
    private int scrap;
    private Long price;
    private String detail;

    public Item() {
        super();
    }

    public Item(long post_id, String title, String type, String content, String image, LocalDate reg_date,
            Long writer_id, int cnt_like, int scrap, Long price, String detail) {

        super(post_id, title, type, content, image, reg_date, writer_id);

        this.setCnt_like(cnt_like);
        this.setScrap(scrap);
        this.setPrice(price);
        this.setDetail(detail);
    }

    public int getCnt_like() {
        return cnt_like;
    }

    public void setCnt_like(int cnt_like) {
        this.cnt_like = cnt_like;
    }

    public int getScrap() {
        return scrap;
    }

    public void setScrap(int scrap) {
        this.scrap = scrap;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    
   
    @Override

    public String toString() {

        return String.format("%d %15s %15s %15s %15s %15s %d %d %d %d %15s",
                post_id, title, type, image,content, reg_date,writer_id,cnt_like,scrap,price,detail);

    }
}
