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
 import java.time.LocalDate;


 @Entity
 @Table(name = "Order")
 public class Order {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "id_order")
   private int id_order;
   @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
   private int id_user;
   private int code_order;
   private double total_price;
   private String user_message;
   private LocalDate create_date_order;
   private LocalDate pay_date;
   private LocalDate delivery_date;
   private LocalDate confirm_date;
   private double payment;
   private String status;


   public Order(){};

   public Order(int id_order, int id_user, int code_order, double total_price, String user_message, LocalDate create_date_order, LocalDate pay_date, LocalDate delivery_date, LocalDate confirm_date, double payment, String status) {
       this.id_order = id_order;
       this.id_user = id_user;
       this.code_order = code_order;
       this.total_price = total_price;
       this.user_message = user_message;
       this.create_date_order = create_date_order;
       this.pay_date = pay_date;
       this.delivery_date = delivery_date;
       this.confirm_date = confirm_date;
       this.payment = payment;
       this.status = status;
   }

   public int getId_order() {
       return id_order;
   }

   public void setId_order(int id_order) {
       this.id_order = id_order;
   }

   public int getId_user() {
       return id_user;
   }

   public void setId_user(int id_user) {
       this.id_user = id_user;
   }

   public int getCode_order() {
       return code_order;
   }

   public void setCode_order(int code_order) {
       this.code_order = code_order;
   }

   public double getTotal_price() {
       return total_price;
   }

   public void setTotal_price(double total_price) {
       this.total_price = total_price;
   }

   public String getUser_message() {
       return user_message;
   }

   public void setUser_message(String user_message) {
       this.user_message = user_message;
   }

   public LocalDate getCreate_date_order() {
       return create_date_order;
   }

   public void setCreate_date_order(LocalDate create_date_order) {
       this.create_date_order = create_date_order;
   }

   public LocalDate getPay_date() {
       return pay_date;
   }

   public void setPay_date(LocalDate pay_date) {
       this.pay_date = pay_date;
   }

   public LocalDate getDelivery_date() {
       return delivery_date;
   }

   public void setDelivery_date(LocalDate delivery_date) {
       this.delivery_date = delivery_date;
   }

   public LocalDate getConfirm_date() {
       return confirm_date;
   }

   public void setConfirm_date(LocalDate confirm_date) {
       this.confirm_date = confirm_date;
   }

   public double getPayment() {
       return payment;
   }

   public void setPayment(double payment) {
       this.payment = payment;
   }

   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }
 }
