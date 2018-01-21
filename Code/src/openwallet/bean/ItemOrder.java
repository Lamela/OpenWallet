package openwallet.bean;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;


public class ItemOrder {
  private int id_item_order;
  private User user;
  private Orders orders;
  private Product product;
  private int number_item_order;

  public ItemOrder(){};

  public ItemOrder(int id_item_order, User user, Orders orders, Product product, int number_item_order) {
    this.id_item_order = id_item_order;
    this.orders = orders;
    this.product = product;
    this.user = user;
    this.number_item_order = number_item_order;
  }
  public ItemOrder(User user, Orders orders, Product product, int number_item_order) {
    this.orders = orders;
    this.product = product;
    this.user = user;
    this.number_item_order = number_item_order;
  }


  public int getId_item_order() {
      return id_item_order;
  }

  public void setId_item_order(int id_item_order) {
      this.id_item_order = id_item_order;
  }

  public Orders getOrders() {
      return orders;
  }

  public void setOrders(Orders orders) {
      this.orders = orders;
  }

  public Product getProduct() {
      return product;
  }

  public void setProduct(Product product) {
      this.product = product;
  }

  public User getUser() {
      return user;
  }

  public void setUser(User user) {
      this.user = user;
  }
  public int getNumber_item_order() {
      return number_item_order;
  }

  public void setNumber_item_order(int number_item_order) {
      this.number_item_order = number_item_order;
  }
}
