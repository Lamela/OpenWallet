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
@Table(name = "Address")
public class Address {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_address")
  private int id_address;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_user;
  private String firstname_receiver;
  private String lastname_receiver;
  private String street;
  private String city;
  private String country;
  private String codepost;

  public Address(){};

  public Address(int id_address, int id_user, String firstname_receiver, String lastname_receiver, String street, String city, String country, String codepost) {
    this.id_address = id_address;
    this.id_user = id_user;
    this.firstname_receiver = firstname_receiver;
    this.lastname_receiver = lastname_receiver;
    this.street = street;
    this.city = city;
    this.country = country;
    this.codepost = codepost;
  }

  public int getId_address() {
  return id_address;
  }

  public void setId_address(int id_address) {
  this.id_address = id_address;
  }

  public int getId_user() {
  return id_user;
  }

  public void setId_user(int id_user) {
  this.id_user = id_user;
  }

  public String getFirstname_receiver() {
  return firstname_receiver;
  }

  public void setFirstname_receiver(String firstname_receiver) {
  this.firstname_receiver = firstname_receiver;
  }

  public String getLastname_receiver() {
  return lastname_receiver;
  }

  public void setLastname_receiver(String lastname_receiver) {
  this.lastname_receiver = lastname_receiver;
  }

  public String getStreet() {
  return street;
  }

  public void setStreet(String street) {
  this.street = street;
  }

  public String getCity() {
  return city;
  }

  public void setCity(String city) {
  this.city = city;
  }

  public String getCountry() {
  return country;
  }

  public void setCountry(String country) {
  this.country = country;
  }

  public String getCodepost() {
  return codepost;
  }

  public void setCodepost(String codepost) {
  this.codepost = codepost;
  }
}
