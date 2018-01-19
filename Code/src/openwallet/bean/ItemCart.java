package openwallet.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.OrderBy;
import javax.persistence.Column;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.TreeSet;
import java.time.LocalDate;


@Entity
@Table(name = "Item_Cart")
public class ItemCart {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_item_cart")
  private int id_item_cart;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private User user;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private Product Product;
  private int number_item_cart;

  public ItemCart(){};

  public ItemCart(int id_item_cart, User user, Product product, int number_item_cart) {
    this.id_item_cart = id_item_cart;
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
