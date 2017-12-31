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
public class Item_Cart {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_item_cart")
  private int id_item_cart;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_user;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_product;
  private int number_item_cart;

  public Item_Cart(){};

  public Item_Cart(int id_item_cart, int id_user, int id_product, int number_item_cart) {
    this.id_item_cart = id_item_cart;
    this.id_user = id_user;
    this.id_product = id_product;
    this.number_item_cart = number_item_cart;
  }

  public int getId_item_cart() {
      return id_item_cart;
  }

  public void setId_item_cart(int id_item_cart) {
      this.id_item_cart = id_item_cart;
  }

  public int getId_user() {
      return id_user;
  }

  public void setId_user(int id_user) {
      this.id_user = id_user;
  }

  public int getId_product() {
      return id_product;
  }

  public void setId_product(int id_product) {
      this.id_product = id_product;
  }

  public int getNumber_item_cart() {
      return number_item_cart;
  }

  public void setNumber_item_cart(int number_item_cart) {
      this.number_item_cart = number_item_cart;
  }
}
