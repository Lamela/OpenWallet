package openwallet.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openwallet.bean.User;
import openwallet.util.DBUtil;
 
public class UserDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from User";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public void add(User bean) {
 
        String sql = "insert into user values(null ,? ,?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setString(1, bean.getFirstname_user());
            ps.setString(2, bean.getLastname_user());
            ps.setTimestamp(3, DateUtil.d2t(bean.getBirthday()));
            ps.setString(4, bean.getType_user());
            ps.setBoolean(5, bean.isPremium());
            ps.setString(6, bean.getEmail());
            ps.setString(7, bean.getPassword());
            ps.setString(8, bean.getMobile_user());
            ps.setString(9, bean.getNumber_id_card());
 
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId_user(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(User bean) {
 
        String sql = "update user set firstname_user= ? , lastname_user = ?, birthday = ?, type_user = ?, premium = ?, email = ?, password = ?, mobile_user = ?, number_id_card = ? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setString(1, bean.getFirstname_user());
            ps.setString(2, bean.getLastname_user());
            ps.setTimestamp(3, DateUtil.d2t(bean.getBirthday()));
            ps.setString(4, bean.getType_user());
            ps.setBoolean(5, bean.isPremium());
            ps.setString(6, bean.getEmail());
            ps.setString(7, bean.getPassword());
            ps.setString(8, bean.getMobile_user());
            ps.setString(9, bean.getNumber_id_card());
            ps.setInt(10, bean.getId_user());
 
            ps.execute();
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from User where id_user = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public User get(int id) {
        User bean = null;
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from User where id_user = " + id;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
                bean = new User();
                String firstname_user = rs.getString("firstname_user");
                bean.setFirstname_user(name);
                String lastname_user = rs.getString("lastname_user");
                bean.setLastname_user(name);
                Date birthday = DateUtil.t2d(rs.getTimestamp("birthday"));
                bean.setBirthday(birthday);
                String type_user = rs.getString("type_user");
                bean.setType_user(type_user);
                boolean premium = rs.getBoolean("premium");
                bean.setPremium(premium);
                String email = rs.getString("email");
                bean.setEmail(email);
                String password = rs.getString("password");
                bean.setPassword(password);
                String mobile_user = rs.getString("mobile_user");
                bean.setMobile_user(mobile_user);
                String number_id_card = rs.getString("number_id_card");
                bean.setNumber_id_card(number_id_card);
                bean.setId_user(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
 
    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();
 
        String sql = "select * from User order by id_user desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                User bean = new User();
                int id = rs.getInt(1);

                String firstname_user = rs.getString("firstname_user");
                bean.setFirstname_user(name);
                String lastname_user = rs.getString("lastname_user");
                bean.setLastname_user(name);
                Date birthday = DateUtil.t2d(rs.getTimestamp("birthday"));
                bean.setBirthday(birthday);
                String type_user = rs.getString("type_user");
                bean.setType_user(type_user);
                boolean premium = rs.getBoolean("premium");
                bean.setPremium(premium);
                String email = rs.getString("email");
                bean.setEmail(email);
                String password = rs.getString("password");
                bean.setPassword(password);
                String mobile_user = rs.getString("mobile_user");
                bean.setMobile_user(mobile_user);
                String number_id_card = rs.getString("number_id_card");
                bean.setNumber_id_card(number_id_card);
                
                bean.setId_user(id);
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }

	public boolean isExist(String firstname, String lastname) {
		User user = get(firstname, lastname);
		return user!=null;

	}

	public User get(String firstname, String lastname) {
		User bean = null;
		 
		String sql = "select * from User where firstname_user = ? AND lastname_user = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, firstname);
            ps.setString(2, lastname);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id_user");
                bean.setFirstname_user(firstname);
                bean.setLastname_user(lastname);
                Date birthday = DateUtil.t2d(rs.getTimestamp("birthday"));
                bean.setBirthday(birthday);
                String type_user = rs.getString("type_user");
                bean.setType_user(type_user);
                boolean premium = rs.getBoolean("premium");
                bean.setPremium(premium);
                String email = rs.getString("email");
                bean.setEmail(email);
                String password = rs.getString("password");
                bean.setPassword(password);
                String mobile_user = rs.getString("mobile_user");
                bean.setMobile_user(mobile_user);
                String number_id_card = rs.getString("number_id_card");
                bean.setNumber_id_card(number_id_card);
                bean.setId_user(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
	}

	public User get(String firstname, String lastname, String password) {
		User bean = null;
		 
		String sql = "select * from User where firstname = ? and lastname = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, firstname);
            ps.setString(2, lastname);
        	ps.setString(3, password);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id_user");
                bean.setFirstname_user(firstname);
                bean.setLastname_user(lastname);
                bean.setPassword(password);
                Date birthday = DateUtil.t2d(rs.getTimestamp("birthday"));
                bean.setBirthday(birthday);
                String type_user = rs.getString("type_user");
                bean.setType_user(type_user);
                boolean premium = rs.getBoolean("premium");
                bean.setPremium(premium);
                String email = rs.getString("email");
                bean.setEmail(email);
                String mobile_user = rs.getString("mobile_user");
                bean.setMobile_user(mobile_user);
                String number_id_card = rs.getString("number_id_card");
                bean.setNumber_id_card(number_id_card);
                bean.setId_user(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
	}
 
}