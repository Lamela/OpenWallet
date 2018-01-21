package openwallet.bean;

import openwallet.dao.CategoryDAO;
import openwallet.bean.Category;
import org.junit.*;

public class CategoryTest {
  private Category myCategory;
  private CategoryDAO categoryDAO;
  private int myCategoryID;

  @Before
  public void avantTest() {
    //sans ID ds le constructeur car il est généré auto et on va ensuite le récupérer grâce
    //au add de l'AddressDAO
    myCategory = new Category("Vehicles");

     categoryDAO = new CategoryDAO();
     myCategoryID = categoryDAO.add(myCategory);

  }

  @Test
  public void testAdd() {
      Category myCategory2 = categoryDAO.get(myCategoryID);

      Assert.assertEquals(this.assertCategoryEquals(myCategory, myCategory2), true);

  }

  @Test
  public void testUpdate() {
      myCategory.setName_category("Tools");

      categoryDAO.update(myCategory);

      Category myCategory2 = categoryDAO.get(myCategoryID);

      Assert.assertEquals(myCategory2.getName_category().equals("Tools"), true);

  }

  @Test
  public void testDelete() {
    Category myCategory2 = new Category("Food");

    int myCategoryID2 = categoryDAO.add(myCategory2);
    categoryDAO.delete(myCategoryID2);

    Assert.assertEquals(categoryDAO.get(myCategoryID2), null);
  }

  private boolean assertCategoryEquals(Category cat1,Category cat2) {
    boolean equal=false;

    if(cat1.getId_category()!=cat2.getId_category()) {
      System.out.println("TestCategory Erreur: id_category ne sont pas égaux!");
    } else {
      if(!cat1.getName_category().equals(cat2.getName_category())) {
        System.out.println("TestCategory Erreur: name_category ne sont pas égaux!");
      } else {
        equal = true;
        }
      }


    return equal;

  }

}
