package test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.dao.*;
import model.User;


public class UserTest {
    
private static UserDAO userDao = new UserDAO();

    public static void main(String[] args) throws SQLException {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        
      
        //추가
        //User user = new User("email", "password", "nickname", 0, "introduction", "interest", "address", 2);
        //userDao.create(user);
        
        //수정
        //User user1 = new User("ado", "얌냠", "하이하이", "운동", "서울시 성동구", "email");
        //userDao.update(user1);

        //삭제
        //System.out.print("삭제할 이메일를 입력하시오: ");
        //String email1 = scanner.next();
        
        //userDao.remove(email1);
        
        
        System.out.print("출력할 이메일를 입력하시오: ");
        String email2 = scanner.next();
        //email로 전체 정보 출력
        List<User> userList = userDao.findUserList(email2);
        //email로 같이가치에 필요한 정보만 출력
        //List<User> userList = userDao.findWithWithList(email);
        // empList에 포함된 모든 emp 객체들의 필드 값을 출력 

        // emp 객체들을 하나씩 접근하기 위해 empList로부터 Iterator<Employee>를 구해서 활용

        Iterator<User> iter = userList.iterator();
          
        System.out.println("-----------------------------------------------------------------------");

        while(iter.hasNext()) {
            User user2 = iter.next();
            System.out.println(user2);
        }
        System.out.println();

        System.out.print("체크할 이메일를 입력하시오: ");
        String email3 = scanner.next();
        if(userDao.existingUser(email3) == true) {
            System.out.println(email3 + "는 존재합니다.");
        }else {
            System.out.println(email3 + "는 존재하지 않습니다.");
        }
        
        System.out.print("체크할 닉네임를 입력하시오: ");
        String nickname = scanner.next();
        if(userDao.existingNickname(nickname) == true) {
            System.out.println(nickname + "는 존재합니다.");
        }else {
            System.out.println(nickname + "는 존재하지 않습니다.");
        }


        scanner.close();
    }

}