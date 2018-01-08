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
  private int id_user;
  @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
  private int id_product;
  private LocalDate date_comment;
  private double note;
  private boolean is_anonymous;

  public Comment(){};

  public Comment(int id_comment, int id_user, int id_product, Date date_comment, double note) {
     this.id_comment = id_comment;
     this.id_user = id_user;
     this.id_product = id_product;
     this.date_comment = date_comment;
     this.note = note;
   }

   public int getId_comment() {
       return id_comment;
   }

   public void setId_comment(int id_comment) {
       this.id_comment = id_comment;
   }

   public int getId_user() {
       return id_user;
   }

   public void setId_user(int id_user) {
       this.id_user = id_user;
   }

   public int getId_product() {
       return id_product;
   }

   public void setId_product(int id_product) {
       this.id_product = id_product;
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
