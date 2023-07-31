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
import sample.dto.Plant;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class PlanDAO {

  

    public static String getPlantsIMG(String pid) {
        String img = null;
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select imgPath from Plants\n"
                        + "where PID = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, pid);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        img = rs.getString("imgPath");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

    public static int getPlantsPrice(String pid) {
        int price = 0;
        try {
            Connection cn = DBUtils.makeConnection();
            String sql = "select price from Plants\n"
                    + "where PID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, pid);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    price = rs.getInt("price");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    public static ArrayList<Plant> getPlants(String keyword, String searchby) {
        ArrayList<Plant> list = new ArrayList<>();

        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null && searchby != null) {
                String sql = "select PID,PName,price,imgPath,description,status, Plants.CateID as 'CateID', CateName\n"
                        + "from Plants join Categories on Plants.CateID = Categories.CateID\n";
                if (searchby.equalsIgnoreCase("by name")) {
                    sql = sql + "where Plants.PName like ?";
                } else {
                    sql = sql + "where CateName like ?";
                }
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1,"%"+ keyword + "%" );
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant plant = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(plant);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Plant> getPlantsList() {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "select PID,PName,price,imgPath,description,status, Plants.CateID as 'CateID', CateName\n"
                        + "from Plants join Categories on Plants.CateID = Categories.CateID\n";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ArrayList<Plant> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("PID");
                        String name = rs.getString("PName");
                        int price = rs.getInt("price");
                        String imgpath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateid = rs.getInt("CateID");
                        String catename = rs.getString("CateName");
                        Plant Pl = new Plant(id, name, price, imgpath, description, status, cateid, catename);
                        list.add(Pl);
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

    public static boolean updatePlant(int pid, String name, int price, String imgpath, String description, int status, int cateid, String catename) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Plants SET Pname=?, price=?, imgPath=?, description=?, status=?, cateid=? \n"
                        + "WHERE PID = ?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, price);
                ps.setString(3, imgpath);
                ps.setString(4, description);
                ps.setInt(5, status);
                ps.setInt(6, cateid);
                ps.setInt(7, pid);
                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    cn.close();
                    return true;
                } else {
                    cn.close();
                    return false;
                }
            } else {
                System.out.println("Connection Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertPlant(String PName, int price, String imgPatH, String description, int status, int CateID) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String pl = "INSERT INTO dbo.Plants(PName,price,imgPath,description,status,CateID)\n"
                        + "VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(pl);
                pst.setString(1, PName);
                pst.setInt(2, price);
                pst.setString(3, imgPatH);
                pst.setString(4, description);
                pst.setInt(5, status);
                pst.setInt(6, CateID);
                int up = pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean removePlant(int id) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "DELETE FROM Plants\n"
                        + "WHERE PID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                int rowsUpdated = pst.executeUpdate();
                if (rowsUpdated > 0) {
                    cn.close();
                    return true;
                } else {
                    cn.close();
                    return false;
                }
            } else {
                System.out.println("Connection Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
