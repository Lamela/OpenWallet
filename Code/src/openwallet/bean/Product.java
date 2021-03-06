package openwallet.bean;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;

public class Product {
  private int id_product;
  private Category category;
  private User user;
  private String name_product;
  private String description;
  private double price;
  private int stock;
  private Date create_date_product;
  private String origin;
  private int sold;
  private String brand;
  private String color;
  private String material;
  private int comment_count;

  public Product(){};

  public Product(int id_product, Category category, User user, String name_product, String description, double price, int stock, Date create_date_product, String origin, int sold, String brand, String color, String material) {
    this.id_product = id_product;
    this.category = category;
    this.user = user;
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
	this.comment_count = comment_count;
  }

  public Product(Category category, User user, String name_product, String description, double price, int stock, Date create_date_product, String origin, int sold, String brand, String color, String material) {
    this.category = category;
    this.user = user;
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
  this.comment_count = comment_count;
  }

  public int getId_product() {
      return id_product;
  }

  public void setId_product(int id_product) {
      this.id_product = id_product;
  }

  public Category getCategory() {
      return category;
  }

  public void setCategory(Category category) {
      this.category = category;
  }

  public User getUser() {
      return user;
  }

  public void setUser(User user) {
      this.user = user;
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

  public Date getCreate_date_product() {
      return create_date_product;
  }

  public void setCreate_date_product(Date create_date_product) {
      this.create_date_product = create_date_product;
  }

  public String getOrigin() {
      return origin;
  }

  public void setOrigin(String origin) {
      this.origin = origin;
  }

  public int getSold() {
      return sold;
  }

  public void setSold(int sold) {
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

  public void setComment_count(int comment_count) {
      this.comment_count = comment_count;
  }

  public int getComment_count() {
  	  return this.comment_count;
  }
}
