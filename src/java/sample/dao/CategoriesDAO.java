package sample.dao;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import sample.dto.Categories;
import sample.dto.Plant;
import sample.utils.DBUtils;

/**
 *
 * @author ASUS
 */
public class CategoriesDAO {

    public static ArrayList<Categories> getCategotiesList() {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT CateID ,CateName\n"
                        + "FROM dbo.Categories";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                ArrayList<Categories> list = new ArrayList<>();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("CateID");
                        String name = rs.getString("CateName");
                        Categories ct = new Categories(id, name);
                        list.add(ct);
                    }
                    return list;
                }
                cn.close();
            } else {
                System.out.println("Connection error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Categories> searchCate(String CateName) {
        ArrayList<Categories> list = new ArrayList<>();
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "SELECT CateID ,CateName\n"
                        + "FROM dbo.Categories\n"
                        + "WHERE CateName=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, CateName);
                ResultSet rs = pst.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int id = rs.getInt("CateID");
                        String name = rs.getString("CateName");
                        Categories ct = new Categories(id, name);
                        list.add(ct);
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

    public static boolean updateCategories(int CateId, String CateName) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "UPDATE Categories SET CateName = ?\n"
                        + "WHERE CateID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, CateName);
                pst.setInt(2, CateId);
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

    public static boolean insertCate(String name) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = "INSERT INTO Categories(CateName)\n"
                        + "VALUES(?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                int up = pst.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean removeCate(int id) {
        try {
            Connection cn = DBUtils.makeConnection();
            if (cn != null) {
                String sql = " DELETE FROM Categories\n"
                        + "WHERE CateID = ?";
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
