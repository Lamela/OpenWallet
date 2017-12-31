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
@Table(name = "Item_Order")
public class Item_Order {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_item_order")
  private int id_item_order;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_order;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_product;
  private int number_item_order;

  public Item_Order(){};

  public Item_Order(int id_item_order, int id_order, int id_product, int number_item_order) {
    this.id_item_order = id_item_order;
    this.id_order = id_order;
    this.id_product = id_product;
    this.number_item_order = number_item_order;
  }

  public int getId_item_order() {
      return id_item_order;
  }

  public void setId_item_order(int id_item_order) {
      this.id_item_order = id_item_order;
  }

  public int getId_order() {
      return id_order;
  }

  public void setId_order(int id_order) {
      this.id_order = id_order;
  }

  public int getId_product() {
      return id_product;
  }

  public void setId_product(int id_product) {
      this.id_product = id_product;
  }

  public int getNumber_item_order() {
      return number_item_order;
  }

  public void setNumber_item_order(int number_item_order) {
      this.number_item_order = number_item_order;
  }
}
