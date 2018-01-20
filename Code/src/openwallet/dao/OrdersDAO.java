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
import openwallet.util.*;

public class OrdersDAO {
	public static final String waitPay = "waitPay";
	public static final String waitDelivery = "waitDelivery";
	public static final String waitConfirm = "waitConfirm";
	public static final String waitReview = "waitReview";
	public static final String finish = "finish";
	public static final String delete = "delete";

  public int getTotal() {
    int total = 0;
    try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

      String sql = "select count(*) from Orders";

      ResultSet rs = s.executeQuery(sql);
      while (rs.next()) {
        total = rs.getInt(1);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return total;
  }

  public void add(Orders bean) {
    String sql = "insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?)";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

      ps.setInt(1, bean.getUser().getId_user());
      ps.setDouble(2, bean.getTotal_price());
      ps.setInt(3, bean.getDelivery_address().getId_address());
      ps.setInt(4, bean.getInvoice_address().getId_address());
      ps.setString(5, bean.getUser_message());
      ps.setTimestamp(6, DateUtil.d2t(bean.getCreate_date_order()));
      ps.setTimestamp(7, DateUtil.d2t(bean.getPay_date()));
      ps.setTimestamp(8, DateUtil.d2t(bean.getDelivery_date()));
      ps.setTimestamp(9, DateUtil.d2t(bean.getConfirm_date()));
      ps.setString(10, bean.getStatus());
      ps.setInt(11, bean.getTotal_number());

      ps.execute();

      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        int id = rs.getInt(1);
        bean.setId_order(id);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

  public void update(Orders bean) {
    String sql = "update orders set id_user = ?, total_price = ?, id_delivery_address = ?, id_invoice_address = ? ,user_message = ? , create_date_order = ? , pay_date = ?, delivery_date = ?, confirm_date = ?, status = ?, total_number where id_order = ?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {


      ps.setInt(1, bean.getUser().getId_user());
      ps.setDouble(2, bean.getTotal_price());
      ps.setInt(3, bean.getDelivery_address().getId_address());
      ps.setInt(4, bean.getInvoice_address().getId_address());
      ps.setString(5, bean.getUser_message());
      ps.setTimestamp(6, DateUtil.d2t(bean.getCreate_date_order()));
      ps.setTimestamp(7, DateUtil.d2t(bean.getPay_date()));
      ps.setTimestamp(8, DateUtil.d2t(bean.getDelivery_date()));
      ps.setTimestamp(9, DateUtil.d2t(bean.getConfirm_date()));
      ps.setString(10, bean.getStatus());
      ps.setInt(11, bean.getTotal_number());
      ps.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void delete(int id) {

    try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
      String sql = "delete from orders where id_order = " + id;
      s.execute(sql);
    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

  public Orders get(int id) {
    Orders bean = new Orders();
    try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

      String sql = "select * from Orders where id_order = " + id;

      ResultSet rs = s.executeQuery(sql);

      if (rs.next()) {


       int id_user = rs.getInt( "id_user");
       User user = new UserDAO().get(id_user);
       double total_price = rs.getDouble("total_price");
       int id_delivery_address = rs.getInt("id_delivery_address");
       Address delivery_address = new AddressDAO().get(id_delivery_address);
       int id_invoice_address = rs.getInt("id_invoice_address");
       Address invoice_address = new AddressDAO().get(id_invoice_address);
       String user_message = rs.getString("user_message");
       Date create_date_order = DateUtil.t2d( rs.getTimestamp("create_date_order"));
       Date pay_date = DateUtil.t2d( rs.getTimestamp("pay_date"));
       Date delivery_date = DateUtil.t2d( rs.getTimestamp("delivery_date"));
       Date confirm_date = DateUtil.t2d( rs.getTimestamp("confirm_date"));
       String status = rs.getString("status");
       int total_number = rs.getInt("total_number");


       bean.setId_order(id);
       bean.setUser(user);
       bean.setTotal_price(total_price);
       bean.setDelivery_address(delivery_address);
       bean.setInvoice_address(invoice_address);
       bean.setUser_message(user_message);
       bean.setCreate_date_order(create_date_order);
       bean.setPay_date(pay_date);
       bean.setDelivery_date(delivery_date);
       bean.setConfirm_date(confirm_date);
       bean.setStatus(status);
       bean.setTotal_number(total_number);

       bean.setId_order(id);
     }

   } catch (SQLException e) {

    e.printStackTrace();
  }
  return bean;
}

public List<Orders> list() {
  return list(0, Short.MAX_VALUE);
}

public List<Orders> list(int start, int count) {
  List<Orders> beans = new ArrayList<>();

  String sql = "select * from Orders_ order by id desc limit ?,? ";

  try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

    ps.setInt(1, start);
    ps.setInt(2, count);

    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      Orders bean = new Orders();
      int id_order=rs.getInt("id_order");
      int id_user = rs.getInt("id_user");
      User user = new UserDAO().get(id_user);
      double total_price = rs.getDouble("total_price");
      int id_delivery_address = rs.getInt("id_delivery_address");
      Address delivery_address = new AddressDAO().get(id_delivery_address);
      int id_invoice_address = rs.getInt("id_invoice_address");
      Address invoice_address = new AddressDAO().get(id_invoice_address);
      String user_message = rs.getString("user_message");
      Date create_date_order = DateUtil.t2d( rs.getTimestamp("create_date_order"));
      Date pay_date = DateUtil.t2d( rs.getTimestamp("pay_date"));
      Date delivery_date = DateUtil.t2d( rs.getTimestamp("delivery_date"));
      Date confirm_date = DateUtil.t2d( rs.getTimestamp("confirm_date"));
      String status = rs.getString("status");
      int total_number = rs.getInt("total_number");

      bean.setId_order(id_order);
      bean.setUser(user);
      bean.setTotal_price(total_price);
      bean.setDelivery_address(delivery_address);
      bean.setInvoice_address(invoice_address);
      bean.setUser_message(user_message);
      bean.setCreate_date_order(create_date_order);
      bean.setPay_date(pay_date);
      bean.setDelivery_date(delivery_date);
      bean.setConfirm_date(confirm_date);
      bean.setStatus(status);
      bean.setTotal_number(total_number);

      beans.add(bean);

    }
  } catch (SQLException e) {

    e.printStackTrace();
  }
  return beans;
}

public List<Orders> list(int uid, String excludedStatus) {
  return list(uid, excludedStatus, 0, Short.MAX_VALUE);
}

public List<Orders> list(int uid, String excludedStatus, int start, int count) {
 List<Orders> beans = new ArrayList<Orders>();

 String sql = "select * from orders where id_user = ? and status != ? order by id_order desc limit ?,? ";

 try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

  ps.setInt(1, uid);
  ps.setString(2, excludedStatus);
  ps.setInt(3, start);
  ps.setInt(4, count);

  ResultSet rs = ps.executeQuery();

  while (rs.next()) {
   Orders bean = new Orders();
   int id_order=rs.getInt( "id_order");
   User user = new UserDAO().get(uid);
   double total_price = rs.getDouble("total_price");
   int id_delivery_address = rs.getInt("id_delivery_address");
   Address delivery_address = new AddressDAO().get(id_delivery_address);
   int id_invoice_address = rs.getInt("id_invoice_address");
   Address invoice_address = new AddressDAO().get(id_invoice_address);
   String user_message = rs.getString("user_message");
   Date create_date_order = DateUtil.t2d( rs.getTimestamp("create_date_order"));
   Date pay_date = DateUtil.t2d(rs.getTimestamp("pay_date"));
   Date delivery_date = DateUtil.t2d(rs.getTimestamp("delivery_date"));
   Date confirm_date = DateUtil.t2d(rs.getTimestamp("confirm_date"));
   String status = rs.getString("status");
   int total_number = rs.getInt("total_number");

   bean.setId_order(id_order);
   bean.setUser(user);
   bean.setTotal_price(total_price);
   bean.setDelivery_address(delivery_address);
   bean.setInvoice_address(invoice_address);
   bean.setUser_message(user_message);
   bean.setCreate_date_order(create_date_order);
   bean.setPay_date(pay_date);
   bean.setDelivery_date(delivery_date);
   bean.setConfirm_date(confirm_date);
   bean.setStatus(status);
   bean.setTotal_number(total_number);

   beans.add(bean);
 }
} catch (SQLException e) {

  e.printStackTrace();
}
return beans;
}

}
