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


@Entity
@Table(name = "Product_Image")
public class ProductImage {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_product_image")
  private int id_product_image;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private Product product;

  public ProductImage(){};

  public ProductImage(int id_product_image, Product product) {
      this.id_product_image = id_product_image;
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
