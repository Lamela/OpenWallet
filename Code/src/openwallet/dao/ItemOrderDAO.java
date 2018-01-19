package openwallet.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import openwallet.bean.*;
import openwallet.util.*;
 
public class ItemOrderDAO {
 
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select count(*) from ItemOrder";
 
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return total;
    }
 
    public void add(ItemOrder bean) {



        String sql = "insert into ItemOrder values(null,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, bean.getProduct().getId_product());
            
            if(null==bean.getOrders())
            	ps.setInt(2, -1);
            else
            	ps.setInt(2, bean.getOrders().getId_order());  
            
            ps.setInt(3, bean.getUser().getId_user);
            ps.setInt(4, bean.getNumber_item_number());
            ps.execute();
 
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id_item_order = rs.getInt(1);
                bean.setId_item_order(id_item_order);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public void update(ItemOrder bean) {

        String sql = "update ItemOrder set id_product = ?, id_order = ?, id_user = ?, number_item_order = ?  where id_item_order = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {


            ps.setInt(1, bean.getProduct().getId_product());
            if(null==bean.getOrders())
            	ps.setInt(2, -1);
            else
            	ps.setInt(2, bean.getOrders().getId_order());
            ps.setInt(3, bean.getUser().getId_user());
            ps.setInt(4, bean.getNumber_item_number());
            

            ps.setInt(5, bean.getId_item_order());
            ps.execute(); 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
 
    }
 
    public void delete(int id) {
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "delete from ItemOrder where id_item_order = " + id;
 
            s.execute(sql);
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
    }
 
    public ItemOrder get(int id) {
        ItemOrder bean = new ItemOrder();
 
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
 
            String sql = "select * from ItemOrder where id_item_order = " + id;
 
            ResultSet rs = s.executeQuery(sql);
 
            if (rs.next()) {
                int id_product = rs.getInt("id_product");
                int id_order = rs.getInt("id_order");
                int id_user = rs.getInt("id_user");
                int number_item_order = rs.getInt("number_item_order");
                User user = new UserDAO.get(id_user);
                Product product = new ProductDAO().get(id_product);
                bean.setProduct(product);
                bean.setUser(user);
                bean.setNumber_item_order(number_item_order);
                
                if(-1 != id_order){
                    Orders orders = new OrdersDAO().get(id_order);
                    bean.setOrders(orders);               	
                }
                
                bean.setId_item_order(id);
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return bean;
    }
 
    public List<ItemOrder> listByUser(int id_user) {
        return listByUser(id_user, 0, Short.MAX_VALUE);
    }
 
    public List<ItemOrder> listByUser(int id_user, int start, int count) {
        List<ItemOrder> beans = new ArrayList<ItemOrder>();
 
        String sql = "select * from ItemOrder where id_user = ? and id_order = -1 order by id_item_order desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, id_user);
            ps.setInt(2, start);
            ps.setInt(3, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                ItemOrder bean = new ItemOrder();
                int id_item_order = rs.getInt(1);

                int id_product = rs.getInt("id_product");
                int id_order = rs.getInt("id_order");
                int number_item_order = rs.getInt("number_item_order");
                
              
                Product product = new ProductDAO().get(id_product);
                if(-1 != id_order){
                    Orders orders = new OrdersDAO().get(id_order);
                    bean.setOrders(orders);               	
                }

                User user = new UserDAO().get(id_user);
                bean.setProduct(product);

                bean.setUser(user);
                bean.setNumber_item_order(number_item_order);
                bean.setId_item_order(id_item_order);                
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }
    public List<ItemOrder> listByOrder(int id_order) {
    	return listByOrder(id_order, 0, Short.MAX_VALUE);
    }
    
    public List<ItemOrder> listByOrder(int oid, int start, int count) {
    	List<ItemOrder> beans = new ArrayList<ItemOrder>();
    	
    	String sql = "select * from ItemOrder where id_order = ? order by id_item_order desc limit ?,? ";
    	
    	try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
    		
    		ps.setInt(1, id_order);
    		ps.setInt(2, start);
    		ps.setInt(3, count);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			ItemOrder bean = new ItemOrder();
    			int id_item_order = rs.getInt(1);
    			
    			int id_product = rs.getInt("id_product");
    			int id_user = rs.getInt("id_user");
    			int number_item_order = rs.getInt("number_item_order");
    			
    			
    			Product product = new ProductDAO().get(id_product);
    			if(-1 != id_order){
    				Orders orders = new OrdersDAO().get(id_order);
    				bean.setOrders(orders);               	
    			}
    			
    			User user = new UserDAO().get(id_user);
    			bean.setProduct(product);
    			
    			bean.setUser(user);
    			bean.setNumber_item_order(number_item_order);
    			bean.setId_item_order(id_item_order);                
    			beans.add(bean);
    		}
    	} catch (SQLException e) {
    		
    		e.printStackTrace();
    	}
    	return beans;
    }

	public void fill(List<Orders> os) {
		for (Orders o : os) {
			List<ItemOrder> ois = listByOrder(o.getId_order());
			double total_price= 0;
			int total_number = 0;
			for (ItemOrder oi : ois) {
				 total += oi.getNumber_item_number() * oi.getProduct().getPrice();
				 total_number += oi.getNumber_item_number();
			}
			o.setTotal_price(total_price);
			o.setItemOrders(ois);
			o.setTotalNumber(totalNumber);
		}
		
		
		
	}

	public void fill(Order o) {
		List<ItemOrder> ois = listByOrder(o.getId_order());
		double total_price = 0;
		for (ItemOrder oi : ois) {
			 total_price += oi.getNumber_item_number() * oi.getProduct().getPrice();
		}
		o.setTotal_price(total);
		o.setItemOrders(ois);
	}

    public List<ItemOrder> listByProduct(int id_product) {
        return listByProduct(id_product, 0, Short.MAX_VALUE);
    }
 
    public List<ItemOrder> listByProduct(int id_product, int start, int count) {
        List<ItemOrder> beans = new ArrayList<ItemOrder>();
 
        String sql = "select * from ItemOrder where id_product = ? order by id_item_order desc limit ?,? ";
 
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, id_product);
            ps.setInt(2, start);
            ps.setInt(3, count);
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                ItemOrder bean = new ItemOrder();
                int id_id_item_order = rs.getInt(1);

                int id_user = rs.getInt("id_user");
                int id_order = rs.getInt("id_order");
                int number_item_order = rs.getInt("number_item_order");
                
              
                Product product = new ProductDAO().get(id_product);
                if(-1 != id_order){
                    Orders orders = new OrdersDAO().get(id_order);
                    bean.setOrders(orders);               	
                }

                User user = new UserDAO().get(id_user);
                bean.setProduct(product);

                bean.setUser(user);
                bean.setNumber_item_order(number_item_order);
                bean.setId_item_order(id_item_order);                
                beans.add(bean);
            }
        } catch (SQLException e) {
 
            e.printStackTrace();
        }
        return beans;
    }
}