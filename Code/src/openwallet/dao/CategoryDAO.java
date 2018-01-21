package openwallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openwallet.bean.Category;
import openwallet.util.DBUtil;
 
public class CategoryDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from Category";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public int add(Category bean) {
        String sql = "insert into category values(null,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setString(1, bean.getName_category());
 
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId_category(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean.getId_category();
    }
 
    public void update(Category bean) {
 
        String sql = "update category set name_category= ? where id_category = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setString(1, bean.getName_category());
            ps.setInt(2, bean.getId_category());
 
            ps.execute();
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from Category where id_category = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public Category get(int id) {
        Category bean = null;
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from Category where id_category = " + id;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
                bean = new Category();
                String name = rs.getString(2);
                bean.setName_category(name);
                bean.setId_category(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }

    public Category get(String name) {
        Category bean = null;
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from Category where name_category = " + name;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
                bean = new Category();
                int id_category = rs.getInt(1);
                bean.setName_category(name);
                bean.setId_category(id_category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<Category> list(int start, int count) {
        List<Category> beans = new ArrayList<Category>();
 
        String sql = "select * from Category order by id_category desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Category bean = new Category();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                bean.setId_category(id);
                bean.setName_category(name);
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }
 
}
