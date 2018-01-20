package openwallet.bean;

import openwallet.bean.User;
import openwallet.dao.UserDAO;
import org.junit.*;

public class UserTest {
  private UserDAO userDAO;
  private User user;
  private int id_user;

  @Before
  public void avantTest(){
    this.user = new User("Open","Wallet",new Date(0).valueOf("1995-11-21"),
    "normalType", false, "open.wallet@gmail.com", "mdp", "0611111111", "123456");


    this.userDAO = new UserDAO();
    this.id_user = this.userDAO.add(comment);
  }

  @Test
  public void testAdd() {
    User user2= userDAO.get(this.id_user);

    assertEquals(this.assertUserEquals(this.user, user2), true);
  }

  @Test
  public void testUpdate(){
    this.user.setBirthday(new Date(0).valueOf("2018-01-18"));
    this.userDAO.update(this.user);
    User user2= userDAO.get(id_comment);

    assertEquals(user2.getBirthday().equals(new Date(0).valueOf("2018-01-18")), true);
  }

  @Test
  public void testDelete(){
    User user2= userDAO.get(this.id_user);

    id_user2 = userDAO.add(user2);
    userDAO.delete(id_user2);

    assertEquals(userDAO.get(id_comment2), null);
  }

  private boolean assertUserEquals(User user1,User user2) {

    if(user1.getId_user()!=user2.getId_user()) {
      System.out.println("TestUser Error: id_user not equals !");
    } else {
      if(!user1.getFirstname_user().equals(user2.getFirstname_user())) {
        System.out.println("TestUser Error: firstname_user not equals !");
      }else {
        if(!user1.getLastname_user().equals(user2.getLastname_user())) {
          System.out.println("TestUser Error: lastname_user not equals !");
        } else {
          if(!user1.getBirthday().equals(user2.getBirthday())) {
            System.out.println("TestUser Error: birthday not equals !");
          } else {
            if(!user1.getType_usergetType_user().equals(user2.getType_user())) {
              System.out.println("TestUser Error: type_user not equals !");
            } else {
              if(!user1.getEmail().equals(user2.getEmail())) {
                System.out.println("TestUser Error: email not equals !");
              } else {
                if(!user1.getPassword().equals(user2.getPassword())) {
                  System.out.println("TestUser Error: password not equals !");
                } else {
                  if(!user1.getNumber_id_card().equals(user2.getNumber_id_card())) {
                    System.out.println("TestUser Error: number_id_card not equals !");
                  } else {
                    if(!user1.getMobile_user().equals(user2.getMobile_user())) {
                      System.out.println("TestUser Error: mobile_user not equals !");
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
