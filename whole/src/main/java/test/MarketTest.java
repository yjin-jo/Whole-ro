package test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import model.dao.*;
import model.Post;

public class MarketTest {
    private static MarketDAO marketDao = new MarketDAO();

    public static void main(String[] args) throws SQLException {

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
    }

}
