package openwallet.bean;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;

public class ItemCart {
  private int id_item_cart;
  private User user;
  private Product product;
  private int number_item_cart;

  public ItemCart(){};

  public ItemCart(int id_item_cart, User user, Product product, int number_item_cart) {
    this.id_item_cart = id_item_cart;
    this.user = user;
    this.product = product;
    this.number_item_cart = number_item_cart;
  }
  public ItemCart(User user, Product product, int number_item_cart) {
    this.user = user;
    this.product = product;
    this.number_item_cart = number_item_cart;
  }

  public int getId_item_cart() {
      return id_item_cart;
  }

  public void setId_item_cart(int id_item_cart) {
      this.id_item_cart = id_item_cart;
  }

  public User getUser() {
      return user;
  }

  public void setUser(User user) {
      this.user = user;
  }

  public Product getProduct() {
      return product;
  }

  public void setProduct(Product product) {
      this.product = product;
  }

  public int getNumber_item_cart() {
      return number_item_cart;
  }

  public void setNumber_item_cart(int number_item_cart) {
      this.number_item_cart = number_item_cart;
  }
}
