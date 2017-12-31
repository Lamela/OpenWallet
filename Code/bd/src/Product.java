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
@Table(name = "Product")
public class Product {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_product")
  private int id_product;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_category;
  private int id_user;
  private String name_product;
  private String description;
  private double price;
  private int stock;
  private LocalDate create_date_product;
  private String origin;
  private boolean sold;
  private String brand;
  private String color;
  private String material;
  private double note;

  public Product(){};

  public Product(int id_product, int id_category, int id_user, String name_product, String description, double price, int stock, LocalDate create_date_product, String origin, boolean sold, String brand, String color, String material, double note) {
    this.id_product = id_product;
    this.id_category = id_category;
    this.id_user = id_user;
    this.name_product = name_product;
    this.description = description;
    this.price = price;
    this.stock = stock;
    this.create_date_product = create_date_product;
    this.origin = origin;
    this.sold = sold;
    this.brand = brand;
    this.color = color;
    this.material = material;
    this.note = note;
  }

  public int getId_product() {
      return id_product;
  }

  public void setId_product(int id_product) {
      this.id_product = id_product;
  }

  public int getId_category() {
      return id_category;
  }

  public void setId_category(int id_category) {
      this.id_category = id_category;
  }

  public int getId_user() {
      return id_user;
  }

  public void setId_user(int id_user) {
      this.id_user = id_user;
  }

  public String getName_product() {
      return name_product;
  }

  public void setName_product(String name_product) {
      this.name_product = name_product;
  }

  public String getDescription() {
      return description;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public double getPrice() {
      return price;
  }

  public void setPrice(double price) {
      this.price = price;
  }

  public int getStock() {
      return stock;
  }

  public void setStock(int stock) {
      this.stock = stock;
  }

  public LocalDate getCreate_date_product() {
      return create_date_product;
  }

  public void setCreate_date_product(LocalDate create_date_product) {
      this.create_date_product = create_date_product;
  }

  public String getOrigin() {
      return origin;
  }

  public void setOrigin(String origin) {
      this.origin = origin;
  }

  public boolean isSold() {
      return sold;
  }

  public void setSold(boolean sold) {
      this.sold = sold;
  }

  public String getBrand() {
      return brand;
  }

  public void setBrand(String brand) {
      this.brand = brand;
  }

  public String getColor() {
      return color;
  }

  public void setColor(String color) {
      this.color = color;
  }

  public String getMaterial() {
      return material;
  }

  public void setMaterial(String material) {
      this.material = material;
  }

  public double getNote() {
      return note;
  }

  public void setNote(double note) {
      this.note = note;
  }
}
