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
import java.util.Date;
import java.util.Set;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
