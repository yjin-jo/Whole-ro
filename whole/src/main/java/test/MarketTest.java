package test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.dao.*;
import model.Item;
import model.Post;

public class MarketTest {
    private static MarketDAO marketDao = new MarketDAO();

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        
        List<Post> postList = marketDao.findtypeMarketPost();
        // empList에 포함된 모든 emp 객체들의 필드 값을 출력

        if (postList != null) {
            Iterator<Post> iter = postList.iterator();

            System.out.println(
                    "post_id        title           type          content        image      reg_date   writer_id");

            System.out.println("-----------------------------------------------------------------------");
            while (iter.hasNext()) {

                Post post = iter.next();
                System.out.println(post);

            }
        } else {
            System.out.println("No posts found.");
        }
        
        System.out.print("포스트제목을 입력하시오: ");
        String posttitle = scanner.next();
        System.out.println();
        
       Item item = marketDao.findPostDetail(posttitle);
       
       if (item != null) {   
           System.out.println("<글 제목>");
           System.out.println("글 제목:"+ posttitle);
           System.out.println("글 타입:"+ item.getType());
           System.out.println("글 내용:"+ item.getContent());
           System.out.println("글 이미지:"+ item.getImage());
           System.out.println("글 생성일:"+ item.getReg_date());
           System.out.println("작성자 id:"+ item.getWriter_id());
           System.out.println("좋아요 수:"+ item.getCnt_like());
           System.out.println("스크랩 수:"+ item.getScrap());
           System.out.println("가격:"+ item.getPrice());
           System.out.println("선호 타입:"+ item.getDetail());
           System.out.println();
           }
    }

}
