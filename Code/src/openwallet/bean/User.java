package openwallet.bean;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class User {
  private int id_user;
  private String firstname_user;
  private String lastname_user;
  private Date birthday;
  private String type_user;
  private boolean premium;
  private String email;
  private String password;
  private String mobile_user;
  private String number_id_card;

  public User(){};

  public User(int id_user, String firstname_user, String lastname_user, Date birthday, String type_user, boolean premium, String email, String password, String mobile_user, String number_id_card) {
      this.id_user = id_user;
      this.firstname_user = firstname_user;
      this.lastname_user = lastname_user;
      this.birthday = birthday;
      this.type_user = type_user;
      this.premium = premium;
      this.email = email;
      this.password = password;
      this.mobile_user = mobile_user;
      this.number_id_card = number_id_card;
  }

  public User(String firstname_user, String lastname_user, Date birthday, String type_user, boolean premium, String email, String password, String mobile_user, String number_id_card) {
      this.firstname_user = firstname_user;
      this.lastname_user = lastname_user;
      this.birthday = birthday;
      this.type_user = type_user;
      this.premium = premium;
      this.email = email;
      this.password = password;
      this.mobile_user = mobile_user;
      this.number_id_card = number_id_card;
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

  public Date getBirthday() {
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

  public String getMobile_user() {
      return mobile_user;
  }

  public String getNumber_id_card() {
      return number_id_card;
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

  public void setBirthday(Date birthday) {
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

  public void setMobile_user(String mobile_user) {
      this.mobile_user = mobile_user;
  }

  public void setNumber_id_card(String number_id_card) {
      this.number_id_card = number_id_card;
  }
}
