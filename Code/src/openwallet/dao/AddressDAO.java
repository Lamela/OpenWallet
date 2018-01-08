package openwallet.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import openwallet.bean.Address;
import openwallet.util.DBUtil;
import openwallet.util.DateUtil;
 
public class AddressDAO {
 
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
 
    public void add(Address bean) {
 
        String sql = "insert into address values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
			ps.setInt(1, bean.getId_user());
            ps.setString(2, bean.getFirstname_receiver());
            ps.setString(3, bean.getLastname_receiver());
            ps.setString(4, bean.getMobile_receiver());
            ps.setString(5, bean.getStreet());
            ps.setString(6, bean.getCity());
            ps.setString(7, bean.getCountry());
            ps.setString(8, bean.getPost_address());
 
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId_address(id);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(Address bean) {
 
        String sql = "update address set id_user = ? , firstname_receiver = ? , lastname_receiver = ?, mobile_receiver = ?, street = ?, city = ?, country = ?, post_address = ? where id_address = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
			ps.setInt(1, bean.getId_user());
            ps.setString(2, bean.getFirstname_receiver());
            ps.setString(3, bean.getLastname_receiver());
            ps.setString(4, bean.getMobile_receiver());
            ps.setString(5, bean.getStreet());
            ps.setString(6, bean.getCity());
            ps.setString(7, bean.getCountry());
            ps.setString(8, bean.getPost_address());
			ps.setInt(9, bean.getId_address());
 
            ps.execute();
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from address where id_address = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public Address get(int id) {
        Address bean = null;
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from Address where id_address = " + id;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
                bean = new Address();
				int id_user = rs.getInt("id_user");
				bean.setId_user(id_user);
                String firstname_receiver = rs.getString("firstname_receiver");
                bean.setFirstname_receiver(firstname_receiver);
                String lastname_receiver = rs.getString("lastname_receiver");
                bean.setLastname_receiver(lastname_receiver);
                String mobile_receiver = rs.getString("mobile_receiver");
                bean.setMobile_receiver(mobile_receiver);
                String street = rs.getString("street");
                bean.setStreet(street);
                String city = rs.getString("city");
                bean.setCity(city);
                String country = rs.getString("country");
                bean.setCountry(country);
                String post_address = rs.getString("post_address");
                bean.setPost_address(post_address);
                bean.setId_address(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
 
    public List<Address> list() {
        return list(0, Short.MAX_VALUE);
    }
 
    public List<Address> list(int start, int count) {
        List<Address> beans = new ArrayList<>();
 
        String sql = "select * from address order by id_address desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, start);
            ps.setInt(2, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Address bean = new Address();
                int id = rs.getInt(1);

				int id_user = rs.getInt("id_user");
				bean.setId_user(id_user);
                String firstname_receiver = rs.getString("firstname_receiver");
                bean.setFirstname_receiver(firstname_receiver);
                String lastname_receiver = rs.getString("lastname_receiver");
                bean.setLastname_receiver(lastname_receiver);
                String mobile_receiver = rs.getString("mobile_receiver");
                bean.setMobile_receiver(mobile_receiver);
                String street = rs.getString("street");
                bean.setStreet(street);
                String city = rs.getString("city");
                bean.setCity(city);
                String country = rs.getString("country");
                bean.setCountry(country);
                String post_address = rs.getString("post_address");
                bean.setPost_address(post_address);
                bean.setId_address(id);

                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }

	/*public boolean isExist(String firstname, String lastname) {
		User user = get(firstname, lastname);
		return user!=null;

	}*/

/*	public Address get(int id) {
		Address bean = null;
		 
		String sql = "select * from address where id_address = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                bean = new Address();
                int id_user = rs.getInt("id_user");
				bean.setId_user = id_user;
				String firstname_receiver = rs.getString("firstname_receiver");
                bean.setFirstname_receiver(firstname_receiver);
				String lastname_receiver = rs.getString("lastname_receiver");
                bean.setLastname_receiver(lastname_receiver);
                String mobile_receiver = rs.getString("mobile_receiver");
                bean.setMobile_receiver(mobile_receiver);
                String city = rs.getString("city");
                bean.setCity(city);
                String street = rs.getString("street");
                bean.setStreet(street);
                String country = rs.getString("country");
                bean.setCountry(country);
                String post_address = rs.getString("post_address");
                bean.setPost_address(post_address);
                bean.setId_address(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
	}*/

	/*
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
*/
 
}
