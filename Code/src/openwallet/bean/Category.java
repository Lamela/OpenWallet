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
@Table(name = "Category")
public class Category {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_category")
  private int id_category;
  private String name_category;
  List<Product> products;
  List<List<Product>> productsByRow;

  public Category(){};


      public Category(int id_category, String name_category) {
          this.id_category = id_category;
          this.name_category = name_category;
      }

      public int getId_category() {
          return id_category;
      }

      public void setId_category(int id_category) {
          this.id_category = id_category;
      }

      public String getName_category() {
          return name_category;
      }

      public void setName_category(String name_category) {
          this.name_category = name_category;
      }

      public List<Product> getProducts() {
        return products;
      }

      public void setProducts(List<Product> products) {
        this.products = products;
      }

      public List<List<Product>> getProductsByRow() {
        return productsByRow;
      }

      public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
      }
}
