package openwallet.bean;

import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;
import java.util.List;


public class Category {
  private int id_category;
  private String name_category;
  List<Product> products;
  List<List<Product>> productsByRow;

  public Category(){};


      public Category(int id_category, String name_category) {
          this.id_category = id_category;
          this.name_category = name_category;
      }
      public Category(String name_category) {
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
