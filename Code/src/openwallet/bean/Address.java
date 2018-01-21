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

public class Address {
  private int id_address;
  private User user;
  private String firstname_receiver;
  private String lastname_receiver;
  private String mobile_receiver;
  private String street;
  private String city;
  private String country;
  private String post_address;

  public int getId_address() {
  return id_address;
  }

  public void setId_address(int id_address) {
  this.id_address = id_address;
  }

  public User getUser() {
  return user;
  }

  public void setUser(User user) {
  this.user = user;
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

  public void setMobile_receiver(String mobile_receiver) {
  this.mobile_receiver = mobile_receiver;
  }

  public String getMobile_receiver() {
  return mobile_receiver;
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

  public String getPost_address() {
  return post_address;
  }

  public void setPost_address(String post_address) {
  this.post_address = post_address;
  }
}
