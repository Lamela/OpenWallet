package openwallet.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import openwallet.bean.*;
import openwallet.util.DBUtil;
import openwallet.util.DateUtil;
 
public class CommentDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from Comment";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
    public int getTotal(int pid) {
    	int total = 0;
    	try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
    		
    		String sql = "select count(*) from Comment where pid = " + pid;
    		
    		ResultSet rs = s.executeQuery(sql);
    		while (rs.next()) {
    			total = rs.getInt(1);
    		}
    	} catch (SQLException e) {
    		
    		e.printStackTrace();
    	}
    	return total;
    }
 
    public void add(Comment bean) {



        String sql = "insert into Comment values(null,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, bean.getUser().getId_user());
            ps.setInt(2, bean.getProduct().getId_product());
            ps.setTimestamp(3, DateUtil.d2t(bean.getDate_comment()));
	    ps.setDouble(4, bean.getNote());
            
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId_comment(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(Comment bean) {

        String sql = "update Comment set id_user= ?, id_product=?, date_comment=? , note = ? where id_comment = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, bean.getUser().getId_user());
            ps.setInt(2, bean.getProduct().getId_product());
            ps.setTimestamp(3, DateUtil.d2t(bean.getDate_comment()));
	    ps.setDouble(4, bean.getNote());
            ps.setInt(5, bean.getId_comment());
            ps.execute();
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from Comment where id_comment = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public Comment get(int id) {
        Comment bean = new Comment();
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from Comment where id_comment = " + id;
 
            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
				UserDAO userDAO = new UserDAO();
				ProductDAO productDAO = new ProductDAO();
                int id_user = rs.getInt("id_user");
                int id_product = rs.getInt("id_product");
                Date date_comment = DateUtil.t2d(rs.getTimestamp("date_comment"));
                Double note = rs.getDouble("note");
                
                bean.setId_comment(id);
                bean.setDate_comment(date_comment);
                bean.setUser(userDAO.get(id_user));
                bean.setProduct(productDAO.get(id_product));
                bean.setNote(note);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
 
    public List<Comment> list(int pid) {
        return list(pid, 0, Short.MAX_VALUE);
    }
 
    public int getCount(int pid) {
        String sql = "select count(*) from Comment where Id_product = ? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
               return rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return 0;    	
    }
    public List<Comment> list(int pid, int start, int count) {
        List<Comment> beans = new ArrayList<Comment>();
 
        String sql = "select * from Comment where id_product = ? order by id_comment desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, pid);
            ps.setInt(2, start);
            ps.setInt(3, count);
 
            ResultSet rs = ps.executeQuery();
 
			UserDAO userDAO = new UserDAO();
			ProductDAO productDAO = new ProductDAO();
            while (rs.next()) {
                Comment bean = new Comment();
                int id_comment = rs.getInt("id_comment");
                int id_user = rs.getInt("id_user");
                int id_product = rs.getInt("id_product");
                Date date_comment = DateUtil.t2d(rs.getTimestamp("date_comment"));
                Double note = rs.getDouble("note");
                
                
                bean.setId_comment(id_comment);
                bean.setDate_comment(date_comment);
                bean.setUser(userDAO.get(id_user));
                bean.setProduct(productDAO.get(id_product));
                bean.setNote(note);
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }
	public boolean isExist(Double note, int pid) {
		
		 
		String sql = "select * from Comment where note = ? and id_product = ?";
		
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setDouble(1, note);
        	ps.setInt(2, pid);
            
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
            	return true;
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }

		
		return false;
	}
 
}
