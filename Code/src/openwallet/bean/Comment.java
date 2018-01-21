package openwallet.bean;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.time.LocalDate;

public class Comment {

  private int id_comment;
  private User user;
  private Product product;
  private Date date_comment;
  private double note;
  private String content;

  public Comment(){};

  public Comment(int id_comment, User user, Product product, Date date_comment, double note, String content) {
     this.id_comment = id_comment;
     this.user = user;
     this.product = product;
     this.date_comment = date_comment;
     this.note = note;
	 this.content = content;
   }
   public Comment(User user, Product product, Date date_comment, double note, String content) {
      this.user = user;
      this.product = product;
      this.date_comment = date_comment;
      this.note = note;
   this.content = content;
    }


   public int getId_comment() {
       return id_comment;
   }

   public void setId_comment(int id_comment) {
       this.id_comment = id_comment;
   }

   public User getUser() {
       return user;
   }

   public void setUser(User user) {
       this.user = user;
   }

   public Product getProduct() {
       return product;
   }

   public void setProduct(Product product) {
       this.product = product;
   }

   public Date getDate_comment() {
       return date_comment;
   }

   public void setDate_comment(Date date_comment) {
       this.date_comment = date_comment;
   }

   public double getNote() {
       return note;
   }

   public void setNote(double note) {
       this.note = note;
   }

   public String getContent() {
       return this.content;
   }

   public void setContent(String content) {
       this.content = content;
   }

}
