package openwallet.dao;

import openwallet.dao.ProductDAO;
import openwallet.dao.UserDAO;
import openwallet.dao.CategoryDAO;
import openwallet.bean.Product;
import openwallet.bean.User;
import openwallet.bean.Category;
import org.junit.*;

public class ProductTest {
  private User myUser;
  private Category myCategory;
  private Product myProduct;
  private ProductPAO productDAO;
  private int myProductID;

  @Before
  public void avantTest() {
    //sans ID ds le constructeur car il est généré auto et on va ensuite le récupérer grâce
    //au add de l'AddressDAO
    myUser = new User("Jean","Dupont",new Date(0).valueOf("1995-11-21"),
    "normalType", false, "jean.dupont@gmail.com", "mdp", "0611111111", "123456");

    myCategory = Category("Vehicles");

    myProduct = new Product(myCategory,myUser,"Ferrari","Ferrari Car",
     500000, 3,new Date(0).valueOf("2014-11-21") ,"Italy", 100000, "Ferrari","Red","Metal");

     new UserDAO().add(myUser);
     new CategoryDAO().add(myCategory);

     productDAO = new productDAO();
     myProductID = productDAO.add(myProduct);
  }

  @Test
  public void testAdd() {
      Product myProduct2 = productDAO.get(myProduct);

      assertEquals(this.assertProductEquals(myProduct, myProduct2), true);

      // if(this.assertAddressEquals(myAddress, myProduct2))
      //   System.out.println("TestProduct: testAdd Succès");
      // else
      //   System.out.println("TestProduct: testAdd Échec");

  }

  @Test
  public void testUpdate() {
      myProduct.setColor("Blue");

      productDAO.update(myProduct);

      Product myProduct2 = productDAO.get(myProductID);

      assertEquals(myProduct2.getColor().equals("Blue"), true);

      // if(myProduct2.getCity().equals("Paris"))
      //   System.out.println("TestProduct: testUpdate Succès");
      // else
      //   System.out.println("TestProduct: testUpdate Échec");
  }

  @Test
  public void testDelete() {
    Address myProduct2 = new Product(myCategory,myUser,"Porsche","Porsche Car",
     500000, 3,new Date(0).valueOf("2014-11-21") ,"Germany", 100000, "Porsche","Yellow","Metal");

    myProductID2 = productDAO.add(myProduct2);
    productDAO.delete(myProductID2);

    assertEquals(productDAO.get(myProductID2), null);

    // if(productDAO.get(myProductID2)==null)
    //   System.out.println("TestProduct: testDelete Succès");
    // else
    //   System.out.println("TestProduct: testDelete Échec");
  }

  private boolean assertProductEquals(Product myProduct,Product myProduct2) {
    if(myProduct.getId_product()!=myProduct2.getId_product()) {
      System.out.println("TestProduct Erreur: id_product ne sont pas égaux!");
    } else {
      if(myProduct.getCategory().getId_category()!=myProduct2.getCategory().getId_category()) {
        System.out.println("TestProduct Erreur: id_category ne sont pas égaux!");
      }else {
        if(myProduct.getUser().getId_user()!=myProduct2.getUser().getId_user()) {
          System.out.println("TestProduct Erreur: id_user ne sont pas égaux!");
        } else {
          if(!myProduct.getName_product().equals(myProduct2.getName_product())) {
            System.out.println("TestProduct Erreur: name_product ne sont pas égaux!");
          } else {
            if(!myProduct.getDescription().equals(myProduct2.getDescription())) {
              System.out.println("TestProduct Erreur: description ne sont pas égaux!");
            }else {

              this.stock = stock;
              this.create_date_product = create_date_product;
              this.origin = origin;
              this.sold = sold;
              this.brand = brand;
              this.color = color;
              this.material = material;
            this.comment_count = comment_count;

              if(myProduct.getPrice()!=myProduct2.getPrice()) {
                System.out.println("TestProduct Erreur: price ne sont pas égaux!");
              }else {
                if(!myProduct.getCreate_date_product().compareTo(myProduct2.getCreate_date_product())) {
                  System.out.println("TestProduct Erreur: create_date_product ne sont pas égaux!");
                }else {
                  if(!myProduct.getOrigin().equals(myProduct2.getOrigin())){
                    System.out.println("TestProduct Erreur: origin ne sont pas égaux!");
                  }else {
                    if(myProduct.getSold()!=myProduct2.getSold()) {
                      System.out.println("TestProduct Erreur: sold ne sont pas égaux!");
                    } else{
                      if(!myProduct.getBrand().equals(myProduct2.getBrand())){
                        System.out.println("TestProduct Erreur: brand ne sont pas égaux!");
                      } else {
                        if(!myProduct.getColor().equals(myProduct2.getColor())){
                          System.out.println("TestProduct Erreur: color ne sont pas égaux!");
                        } else {
                          if(!myProduct.getMaterial().equals(myProduct2.getMaterial())){
                            System.out.println("TestProduct Erreur: material ne sont pas égaux!");
                          } else {
                            equal = true;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    return equal;

  }

}
