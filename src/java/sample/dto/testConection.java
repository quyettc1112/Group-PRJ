/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dto;

import java.util.ArrayList;
import sample.dao.AccountDAO;
import sample.dao.OrderDAO;
import sample.dao.PlanDAO;

/**
 *
 * @author Admin
 */
public class testConection {
    public static void main(String[] args) throws Exception {
        //  test Accoutn      
        Account acc = AccountDAO.getAccount("admin@gmail.com", "admin");
//        if (acc != null) {
//            if (acc.getRole() == 1)  
//                System.out.println("i am an admin");  
//            else 
//                System.out.println("i am an user");  
//        } else System.out.println("login fail"); 
        
//        
//        // Cho nay test in list account
//        ArrayList <Account> list = AccountDAO.getAccountList();
//        for (Account account : list) {
////            System.out.println(account.getAccID()+ ", "+ account.getEmail()+ ", "+account.getFullname()
////            + ", "+account.getPassword()+ ", "+account.getPhone()+ ", "+account.getStatus()+ ", "+account.getRole());
//                System.out.println(account.toString());
//        }
//        
//        // chalend 2
//        if (AccountDAO.updateAccountStatus("test@gmail.com", 1))
//               System.out.println("Update success");
//        else System.out.println("Update fail");
//        
        
//        // chalend 3
//        if (AccountDAO.updateAccount("test@gmail.com", "999999", "thino", "123456"))
//            System.out.println("Update success");
//        else System.out.println("Update fail");
        
//        
//        if (AccountDAO.insertAccount("test3@gmail.com", "222222", "chi pheo", "12345", 1, 0))
//            System.out.println("Update success");
//        else System.out.println("Update fail");


//
//           ArrayList<Plant> list2 = PlanDAO.getPlants("ros", "byname");
//           for (Plant plant : list2) {
//                System.out.println(plant.toString());
//        }

//        ArrayList<Order> listt = OrderDAO.getOrders("admin@gmail.com");
//        for (Order order : listt) {
//            System.out.println(listt.toString()); 
//        }
        
//        ArrayList<OrderDetail> listOD = OrderDAO.getOrderDetail(3);
//        
//        for (OrderDetail orderDetail : listOD) {
//            System.out.println(listOD.toString());
//        }
//        System.out.println("------");
//        for (int i = 0; i <listOD.size(); i++) {
//            System.out.println(listOD.get(i).toString());
//        }
//        
//if (AccountDAO.updateAccountName_Phone("test@gmail.com", "Tran Cuong Quyet", "0356970686"))
//            System.out.println("True");
//
//else {
//            System.out.println("flase");
//}
//    if  (AccountDAO.updateToken("Haha123", "bruh@gmail.com"))
//            System.out.println("true");
//    else System.out.println("Fasle");
   String tnp = PlanDAO.getPlantsIMG("1");
        System.out.println(tnp);


 }

}
