package openwallet.bean;

import openwallet.dao.AddressDAO;
import openwallet.dao.UserDAO;
import openwallet.bean.User;
import openwallet.bean.Address;
import java.sql.Date;
import org.junit.*;

public class AddressTest {
  private User myUser;
  private Address myAddress;
  private AddressDAO addrDAO;
  private int myAddrID;

  @Before
  public void avantTest() {
    //sans ID ds le constructeur car il est généré auto et on va ensuite le récupérer grâce
    //au add de l'AddressDAO
    myUser = new User("Jean","Dupont",new Date(0).valueOf("1995-11-21"),
    "normalType", false, "jean.dupont@gmail.com", "mdp", "0611111111", "123456");

    myAddress = new Address(myUser,"Jean",
     "Dupont", "0611111111", "Rue République","Rouen", "France", "76000");

     new UserDAO().add(myUser);
     addrDAO = new AddressDAO();
     myAddrID = addrDAO.add(myAddress);

  }

  @Test
  public void testAdd() {
      Address myAddress2 = addrDAO.get(myAddrID);

      Assert.assertEquals(this.assertAddressEquals(myAddress, myAddress2), true);

      // if(this.assertAddressEquals(myAddress, myAddress2))
      //   System.out.println("TestAddress: testAdd Succès");
      // else
      //   System.out.println("TestAddress: testAdd Échec");

  }

  @Test
  public void testUpdate() {
      myAddress.setCity("Paris");

      addrDAO.update(myAddress);

      Address myAddress2 = addrDAO.get(myAddrID);

      Assert.assertEquals(myAddress2.getCity().equals("Paris"), true);

      // if(myAddress2.getCity().equals("Paris"))
      //   System.out.println("TestAddress: testUpdate Succès");
      // else
      //   System.out.println("TestAddress: testUpdate Échec");
  }

  @Test
  public void testDelete() {
    Address myAddress2 = new Address(myUser,"Georges",
     "Dubois", "0611111111", "Rue République","Rouen", "France", "76000");

    int myAddrID2 = addrDAO.add(myAddress2);
    addrDAO.delete(myAddrID2);

    Assert.assertEquals(addrDAO.get(myAddrID2), null);

    // if(addrDAO.get(myAddrID2)==null)
    //   System.out.println("TestAddress: testDelete Succès");
    // else
    //   System.out.println("TestAddress: testDelete Échec");
  }

  private boolean assertAddressEquals(Address addr1,Address addr2) {
    boolean equal=false;
    if(addr1.getId_address()!=addr2.getId_address()) {
      System.out.println("TestAddress Erreur: id_address ne sont pas égaux!");
    } else {
      if(!addr1.getFirstname_receiver().equals(addr2.getFirstname_receiver())) {
        System.out.println("TestAddress Erreur: firstname_receiver ne sont pas égaux!");
      }else {
        if(!addr1.getLastname_receiver().equals(addr2.getLastname_receiver())) {
          System.out.println("TestAddress Erreur: lastname_receiver ne sont pas égaux!");
        } else {
          if(!addr1.getMobile_receiver().equals(addr2.getMobile_receiver())) {
            System.out.println("TestAddress Erreur: mobile_receiver ne sont pas égaux!");
          } else {
            if(!addr1.getStreet().equals(addr2.getStreet())) {
              System.out.println("TestAddress Erreur: street ne sont pas égaux!");
            }else {
              if(!addr1.getCity().equals(addr2.getCity())) {
                System.out.println("TestAddress Erreur: city ne sont pas égaux!");
              }else {
                if(!addr1.getCountry().equals(addr2.getCountry())) {
                  System.out.println("TestAddress Erreur: country ne sont pas égaux!");
                }else {
                  if(!addr1.getPost_address().equals(addr2.getPost_address())){
                    System.out.println("TestAddress Erreur: country ne sont pas égaux!");
                  }else {
                    equal = true;
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
