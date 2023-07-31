/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sample.dto.Account;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    public static Account getAccount(String email, String password) throws Exception {
        Account acc = null;
        Connection cn = DBUtils.makeConnection(); //b1
        try {
            if (cn != null) {                           //b2
                String s = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status= 1 and email = ? and password = ? COLLATE Latin1_General_CS_AI"; // callate dung dev bat tính nang phan biet hoa thuong
                PreparedStatement pst = cn.prepareStatement(s); // dung de chuyen du lieu vao cac dau ?
                pst.setString(1, email); // dau ? bat dau tu 1
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery(); // dung de excute, nam trong driver
                if (rs != null && rs.next()) {           //b3

                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Phone, status, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }

    public static boolean checkExistAccount(String email) throws Exception {
        Account acc = null;
        Connection cn = DBUtils.makeConnection(); //b1
        try {
            if (cn != null) {                           //b2
                String s = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where status= 1 and email = ? and password = ? COLLATE Latin1_General_CS_AI"; // callate dung dev bat tính nang phan biet hoa thuong
                PreparedStatement pst = cn.prepareStatement(s); // dung de chuyen du lieu vao cac dau ?
                pst.setString(1, email); // dau ? bat dau tu 1

                ResultSet rs = pst.executeQuery(); // dung de excute, nam trong driver

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

//    public static ArrayList<Account> getAccountList() {
//        try {
//            Connection cn = DBUtils.makeConnection();
//            if (cn != null) {
//                String s = "select accID,email,password,fullname,phone,status,role from Accounts";
//                Statement st = cn.createStatement();
//                ResultSet rs = st.executeQuery(s);
//                ArrayList<Account> list = new ArrayList<>();
//                if (rs != null) {
//                    while (rs.next()) {
//                        int accID = rs.getInt("accID");
//                        String email = rs.getString("email");
//                        String password = rs.getString("password");
//                        String fullname = rs.getString("fullname");
//                        String phone = rs.getString("phone");
//                        int status = rs.getInt("status");
//                        int role = rs.getInt("role");
//                        Account ac = new Account(accID, email, password, fullname, phone, status, role);
//                        list.add(ac);
//                    }
//                    return list;
//                }
//                cn.close();
//            } else {
//                System.out.println("Connection Error");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static ArrayList<Account> getAccountList() {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "select accID,email,password,fullname,phone,status,role from Accounts";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(s);
                ArrayList<Account> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int accID = rs.getInt("accID");
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String fullname = rs.getString("fullname");
                        String phone = rs.getString("phone");
                        int status = rs.getInt("status");
                        int role = rs.getInt("role");
                        Account ac = new Account(accID, email, password, fullname, phone, status, role);
                        list.add(ac);
                    }
                    return list;
                }
                cn.close();
            } else {
                System.out.println("Connection Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean updateAccountStatus(String email, int status) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "UPDATE dbo.Accounts\n"
                        + "SET status = ?\n"
                        + "WHERE email = ?";
                PreparedStatement pst = cn.prepareCall(s);
                pst.setInt(1, status);
                pst.setString(2, email);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean updateToken(String token, String email) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "UPDATE Accounts\n"
                        + "SET token = ?\n"
                        + "Where email like ?";
                PreparedStatement pst = cn.prepareCall(s);
                pst.setString(1, token);
                pst.setString(2, email);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Account getAccount(String token) throws Exception {
        Account acc = null;
        Connection cn = DBUtils.makeConnection(); //b1
        try {
            if (cn != null) {                           //b2
                String s = "select accID,email,password,fullname,phone,status,role\n"
                        + "from dbo.Accounts\n"
                        + "where token = ?"; // callate dung dev bat tính nang phan biet hoa thuong
                PreparedStatement pst = cn.prepareStatement(s); // dung de chuyen du lieu vao cac dau ?
                pst.setString(1, token); // dau ? bat dau tu 1

                ResultSet rs = pst.executeQuery(); // dung de excute, nam trong driver
                if (rs != null && rs.next()) {           //b3

                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Phone, status, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }

    public static boolean updateAccountName_Phone(String email, String name, String phone) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "UPDATE Accounts\n"
                        + "SET fullname = ?, Phone = ?\n"
                        + "WHERE email = ?";
                PreparedStatement pst = cn.prepareCall(s);
                pst.setString(1, name);
                pst.setString(2, phone);
                pst.setString(3, email);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean updateAccount(String email, String newpassword, String newfullname, String newPhone) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "UPDATE dbo.Accounts\n"
                        + "SET password= ?, fullname = ?, phone = ?\n"
                        + "WHERE email = ?";
                PreparedStatement pst = cn.prepareStatement(s);
                pst.setString(1, newpassword);
                pst.setString(2, newfullname);
                pst.setString(3, newPhone);
                pst.setString(4, email);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertAccount(String newemail, String newpassword, String newfullname, String newPhone, int newStatus, int newRole) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "INSERT INTO dbo.Accounts\n"
                        + "(email,fullname,password,phone,status,role)\n"
                        + "VALUES \n"
                        + "(?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(s);
                pst.setString(1, newemail);
                pst.setString(2, newpassword);
                pst.setString(3, newfullname);
                pst.setString(4, newPhone);
                pst.setInt(5, newStatus);
                pst.setInt(6, newRole);
                int up = pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public static boolean checkAccount(String token) throws Exception {
        boolean result = false;
        String email = "";
        Connection cn = DBUtils.makeConnection(); //b1
        try {
            if (cn != null) {                           //b2
                String s = "select email\n"
                        + "from dbo.Accounts\n"
                        + "where token = ?"; // callate dung dev bat tính nang phan biet hoa thuong
                PreparedStatement pst = cn.prepareStatement(s); // dung de chuyen du lieu vao cac dau ?
                pst.setString(1, token); // dau ? bat dau tu 1

                ResultSet rs = pst.executeQuery(); // dung de excute, nam trong driver
                if (rs != null && rs.next()) {           //b3
                    email = rs.getString("email");
                }
                if (email != null && !email.isEmpty()) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public static ArrayList<Account> getOneAccount(String keyword) {
        ArrayList<Account> list = new ArrayList<>();
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select accID,email,password,fullname,phone,status,role \n"
                        + "from Accounts\n"
                        + "where fullname like + ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%"+keyword+"%");
                ResultSet rs = pst.executeQuery();
                if(rs!=null){
                    while(rs.next()){
                        int accID = rs.getInt("accID");
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String fullname = rs.getString("fullname");
                        String phone = rs.getString("phone");
                        int status = rs.getInt("status");
                        int role = rs.getInt("role");
                        Account ac = new Account(accID, email, password, fullname, phone, status, role);
                        list.add(ac);
                    }
                    return list;
                }
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static Account getAccount2(String token) throws Exception {
        Account acc = null;
        Connection cn = DBUtils.makeConnection(); //b1
        try {
            if (cn != null) {                           //b2
                String s = "SELECT accID,email,password,fullname,phone,status,role\n"
                        + "FROM dbo.Accounts\n"
                        + "WHERE email LIKE ?"; // callate dung dev bat tính nang phan biet hoa thuong
                PreparedStatement pst = cn.prepareStatement(s); // dung de chuyen du lieu vao cac dau ?
                pst.setString(1, token); // dau ? bat dau tu 1
                ResultSet rs = pst.executeQuery(); // dung de excute, nam trong driver
                if (rs != null && rs.next()) {           //b3
                    int AccID = rs.getInt("accID");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String Fullname = rs.getString("fullname");
                    String Phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Account(AccID, Email, Password, Fullname, Phone, status, Role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return acc;
    }
    
}
