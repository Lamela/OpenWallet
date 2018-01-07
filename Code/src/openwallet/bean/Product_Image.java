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
public class Product_Image {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_product_image")
  private int id_product_image;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_product;

  public Product_Image(){};

  public Product_Image(int id_product_image, int id_product) {
      this.id_product_image = id_product_image;
      this.id_product = id_product;
  }

  public int getId_product_image() {
      return id_product_image;
  }

  public void setId_product_image(int id_product_image) {
      this.id_product_image = id_product_image;
  }

  public int getId_product() {
      return id_product;
  }

  public void setId_product(int id_product) {
      this.id_product = id_product;
  }
}
