package test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.dao.*;
import model.Food;


public class FoodTest {
	
private static FoodDAO foodDao = new FoodDAO();

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);

        

//        System.out.print("부서명을 입력하시오: ");
//
//        String deptName = scanner.next();
//
//        System.out.println();
//
//        
//
//         dept = compDao.findDeptByName(deptName);         
//
//        // dept 객체의 필드 값 출력 ...
//
//        System.out.println("<부서정보>");
//
//        System.out.println("부서번호: " + dept.getDeptNo());
//
//        System.out.println("부서명: " + deptName);
//
//        System.out.println("관리자사번: " + dept.getMgrNo());
//
//        System.out.println("사원 수: " + dept.getNumOfEmps());
//
//        System.out.println();

        

        List<Food> foodList = foodDao.findFoodList();
        // empList에 포함된 모든 emp 객체들의 필드 값을 출력 

        // emp 객체들을 하나씩 접근하기 위해 empList로부터 Iterator<Employee>를 구해서 활용

        Iterator<Food> iter = foodList.iterator();

        

        System.out.println("post_id        title           image          exp_date         reg_date");

        System.out.println("-----------------------------------------------------------------------");

        while(iter.hasNext()) {

            Food food = iter.next();

            System.out.println(food);

        }

        System.out.println();

 

        

//        System.out.print("새 관리자 사번과 관리자 보직수당을 입력하시오: ");
//
//        int managerNo  = scanner.nextInt();
//
//        double commission = scanner.nextDouble();
//
//        
//
//        Appointment appo = new Appointment(dept.getDeptNo(), managerNo, commission);
//
//        Employee oldMgr = compDao.replaceManagerOfDept(appo);    
//
//     
//
//        System.out.println("기존 관리자:");     
//
//        // oldMgr의 필드 값 출력
//
//        System.out.printf("%d %s %s %s %.2f %.2f %d\n",
//
//                oldMgr.getEmpno(), oldMgr.getEname(), oldMgr.getJob(),
//
//                oldMgr.getHiredate(), oldMgr.getSal(), oldMgr.getComm(), oldMgr.getDeptNo());
//
//        
//
//        Employee newMgr = compDao.findEmployee(managerNo);   
//
//        System.out.println("새 관리자:");         
//
//        // newMgr의 필드 값 출력 
//
//        System.out.printf("%d %s %s %s %.2f %.2f %d\n", 
//
//                newMgr.getEmpno(), newMgr.getEname(), newMgr.getJob(),
//
//                newMgr.getHiredate(), newMgr.getSal(), newMgr.getComm(), newMgr.getDeptNo());
//
// 

        scanner.close();
	}

}
