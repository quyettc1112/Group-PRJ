/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import sample.dto.Order;
import sample.dto.OrderDetail;
import sample.dto.Plant;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public static ArrayList<Order> getOrders(String email) {
        ArrayList<Order> list = new ArrayList<>();

        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null && email != null) {
                String sql = "select OrderID,OrdDate,shipdate,Orders.status,Orders.AccID from Orders\n"
                        + "join Accounts on Orders.AccID = Accounts.accID\n"
                        + "where Accounts.email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int OrderID = rs.getInt("OrderID");
                        Date OrdDate = rs.getDate("OrdDate");
                        Date shipdate = rs.getDate("shipdate");
                        int status = rs.getInt("status");
                        int AccID = rs.getInt("AccID");
                        Order o = new Order(OrderID, OrdDate, shipdate, status, AccID);
                        list.add(o);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<OrderDetail> getOrderDetail(int orderID) {
        ArrayList<OrderDetail> listOD = new ArrayList<>();

        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select DetailId,OrderID,PID,PName,price,imgPath, quantity\n"
                        + "from OrderDetails,Plants\n"
                        + "where OrderID=? and OrderDetails.FID= Plants.PID";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int detailID = rs.getInt("DetailId");
                        int PlantID = rs.getInt("PID");
                        String PlanName = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgpath");
                        int quantity = rs.getInt("quantity");
                        OrderDetail od = new OrderDetail(detailID, orderID, PlantID, PlanName, price, imgpath, quantity);
                        listOD.add(od);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOD;
    }

    public static boolean updateOrdertStatus(String email, int orderID) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "update o\n"
                        + "set o.status = 3\n"
                        + "from Orders o\n"
                        + "join Accounts a on o.AccID = a.accID\n"
                        + "where a.email = ? and o.orderID = ?";
                PreparedStatement pst = cn.prepareCall(s);
                pst.setString(1, email);
                pst.setInt(2, orderID);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

     public static boolean updateOrdertStatusv2(String email, int orderID) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String s = "update o\n"
                        + "set o.status = 1\n"
                        + "from Orders o\n"
                        + "join Accounts a on o.AccID = a.accID\n"
                        + "where a.email = ? and o.orderID = ?";
                PreparedStatement pst = cn.prepareCall(s);
                pst.setString(1, email);
                pst.setInt(2, orderID);
                int up = pst.executeUpdate();
                cn.close();
                return (up > 0);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
     public static boolean insertOrder(String email, HashMap<String, Integer> cart) {
        Connection cn = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                int accid = 0, orderid = 0;
                cn.setAutoCommit(false); //off autocommit
                // get account id by email
                String sql = "select accID from Accounts where Accounts.email=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    accid = rs.getInt("accID");
                }
                //insert a new order
                System.out.println("accoutid: " + accid);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("order date:" + d);
                sql = "insert Orders (OrdDate, status, AccID) values (?, ?, ?)";
                pst = cn.prepareStatement(sql);
                pst.setDate(1, d);
                pst.setInt(2, 1);
                pst.setInt(3, accid);
                pst.executeUpdate();
                //get order id that is the lagest number
                sql = "select top 1 orderID from Orders order by orderId desc ";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    orderid = rs.getInt("orderID");
                }
                //insert order details
                System.out.println("orderid: " + orderid);
                Set<String> pids = cart.keySet();
                for (String pid : pids) {
                    sql = "insert OrderDetails values (?,?,?) ";
                    pst = cn.prepareStatement(sql);
                    pst.setInt(1, orderid);
                    pst.setInt(2, Integer.parseInt(pid.trim()));
                    pst.setInt(3, cart.get(pid));
                    pst.executeUpdate();
                    cn.commit();
                    cn.setAutoCommit(true);
                }
                return true;
            } else {
                System.out.println("k chen order dc");
            }
        } catch (Exception e) {
            try {
                if (cn != null) {
                    cn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            result =  false;
        } finally {
            try {
                if (cn !=  null) {
                    cn.close();
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return result;
    }
    
     public static ArrayList<Order> getOrders(String from, String to) {
        ArrayList<Order> list = new ArrayList<>();
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select OrderID,OrdDate,shipdate,Orders.status,Orders.AccID from Orders \n"
                        + "join Accounts on Orders.AccID = Accounts.accID\n"
                        + "where Orders.OrdDate BETWEEN ? AND ?";
                PreparedStatement pst = cn.prepareStatement(sql);
               pst.setString(1, from);
               pst.setString(2, to);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int OrderID = rs.getInt("OrderID");
                        Date OrdDate = rs.getDate("OrdDate");
                        Date shipdate = rs.getDate("shipdate");
                        int status = rs.getInt("status");
                        int AccID = rs.getInt("AccID");
                        Order o = new Order(OrderID, OrdDate, shipdate, status, AccID);
                        list.add(o);
                    }
                }
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     
     
     public static ArrayList<Order> getOrderList() {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT OrderID,OrdDate,shipdate,o.status,a.AccID,fullname\n"
                        + "FROM Orders o JOIN Accounts a ON o.AccID = a.accID ";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ArrayList<Order> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int OId = rs.getInt("OrderID");
                        Date ODate = rs.getDate("OrdDate");
                        Date OShip = rs.getDate("shipdate");
                        int Ostatus = rs.getInt("status");
                        int AId = rs.getInt("AccID");
                        String name = rs.getString("fullname");
                        Order Or = new Order(OId, ODate, ODate, Ostatus, AId, name);
                        list.add(Or);
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

    public static ArrayList<Order> getOrderbyName(String Oname) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT OrderID,OrdDate,shipdate,o.status,a.AccID,fullname\n"
                        + "FROM Orders o JOIN Accounts a ON o.AccID = a.accID\n"
                        + "WHERE fullname like ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + Oname + "%");
                ResultSet rs = pst.executeQuery();
                ArrayList<Order> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int OId = rs.getInt("OrderID");
                        Date ODate = rs.getDate("OrdDate");
                        Date OShip = rs.getDate("shipdate");
                        int Ostatus = rs.getInt("status");
                        int AId = rs.getInt("AccID");
                        String fname = rs.getString("fullname");
                        Order OrByN = new Order(OId, ODate, OShip, Ostatus, AId, fname);
                        list.add(OrByN);
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

    public static ArrayList<Order> getOrderbyDate(Date OrderDateB, Date OrderDateE) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT OrderID,OrdDate,shipdate,O.status,O.AccID, a.fullname\n"
                        + "FROM Orders o JOIN Accounts a ON o.AccID =a.accID \n"
                        + "WHERE OrdDate between ? AND ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setDate(1, new java.sql.Date(OrderDateB.getTime()));
                pst.setDate(2, new java.sql.Date(OrderDateE.getTime()));
                ResultSet rs = pst.executeQuery();
                ArrayList<Order> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int OId = rs.getInt("OrderID");
                        Date ODate = rs.getDate("OrdDate");
                        Date OShip = rs.getDate("shipdate");
                        int Ostatus = rs.getInt("status");
                        int AId = rs.getInt("AccID");
                        String fname = rs.getString("fullname");
                        Order OrByD = new Order(OId, ODate, OShip, Ostatus, AId, fname);
                        list.add(OrByD);
                    }
                    return list;
                }
                cn.close();
            } else{
                System.out.println("Connection Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
     
}
