package openwallet.bean;


import java.sql.Date;
import java.util.Set;
import java.util.TreeSet;

public class ProductImage {
  private int id_product_image;
  private Product product;

  public ProductImage(){};

  public ProductImage(int id_product_image, Product product) {
      this.id_product_image = id_product_image;
      this.product = product;
  }
  public ProductImage(Product product) {
      this.product = product;
  }

  public int getId_product_image() {
      return id_product_image;
  }

  public void setId_product_image(int id_product_image) {
      this.id_product_image = id_product_image;
  }

  public Product getProduct() {
      return product;
  }

  public void setProduct(Product product) {
      this.product = product;
  }
}
