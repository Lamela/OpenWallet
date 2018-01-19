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
import java.util.Date;
import java.util.Set;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.TreeSet;
import java.time.LocalDate;


@Entity
@Table(name = "Comment")
public class Comment {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id_comment")
  private int id_comment;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private User user;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private Product product;
  private Date date_comment;
  private double note;
  private boolean is_anonymous;

  public Comment(){};

  public Comment(int id_comment, User user, Product product, Date date_comment, double note) {
     this.id_comment = id_comment;
     this.user = user;
     this.product = product;
     this.date_comment = date_comment;
     this.note = note;
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

}
