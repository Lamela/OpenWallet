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
import java.util.ArrayList;

@Entity
@Table(name = "User")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_user")
  private int id_user;
  private String firstname_user;
  private String lastname_user;
  private LocalDate birthday;
  private String type_user;
  private boolean premium;
  private String email;
  private String password;
  private String telephone_number;
  private ArrayList cart;

  public User(){};

  public User(int id_user, String firstname_user, String lastname_user, LocalDate birthday, String type_user, boolean premium, String email, String password, String telephone_number, Address delivery_address, Address invoice_address, ArrayList cart) {
      this.id_user = id_user;
      this.firstname_user = firstname_user;
      this.lastname_user = lastname_user;
      this.birthday = birthday;
      this.type_user = type_user;
      this.premium = premium;
      this.email = email;
      this.password = password;
      this.telephone_number = telephone_number;
      this.cart = cart;
  }

  //Getters:
      public int getId_user() {
          return id_user;
      }

      public String getFirstname_user() {
          return firstname_user;
      }

      public String getLastname_user() {
          return lastname_user;
      }

      public LocalDate getBirthday() {
          return birthday;
      }

      public String getType_user() {
          return type_user;
      }

      public boolean isPremium() {
          return premium;
      }

      public String getEmail() {
          return email;
      }

      public String getPassword() {
          return password;
      }

      public String getTelephone_number() {
          return telephone_number;
      }

      public ArrayList getCart() {
          return cart;
      }

    //Setters:
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setFirstname_user(String firstname_user) {
        this.firstname_user = firstname_user;
    }

    public void setLastname_user(String lastname_user) {
        this.lastname_user = lastname_user;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public void setCart(ArrayList cart) {
        this.cart = cart;
    }
}
