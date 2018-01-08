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
 @Table(name = "Orders")
 public class Orders {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   @Column(name = "id_order")
   private int id_order;
   @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
   private int id_user;
   private int code_order;
   private double total_price;
   private int id_delivery_address;
   private int id_invoice_address;
   private String user_message;
   private Date create_date_order;
   private Date pay_date;
   private Date delivery_date;
   private Date confirm_date;
   private double payment;
   private String status;


   public Orders(){};

   public Orders(int id_order, int id_user, int code_order, double total_price, int id_delivery_address, int id_invoice_address, String user_message, Date create_date_order, Date pay_date, Date delivery_date, Date confirm_date, double payment, String status) {
       this.id_order = id_order;
       this.id_user = id_user;
       this.code_order = code_order;
       this.total_price = total_price;
       this.id_delivery_address = id_delivery_address;
       this.id_invoice_address = id_invoice_address;
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

   public int getId_delivery_address() {
       return id_delivery_address;
   }

   public void setId_delivery_address(int id) {
       this.id_delivery_address=id;
   }

   public int setId_invoice_address() {
       return id_invoice_address;
   }

   public void getId_invoice_address(int id) {
       this.id_invoice_address=id;
   }
   public String getUser_message() {
       return user_message;
   }

   public void setUser_message(String user_message) {
       this.user_message = user_message;
   }

   public Date getCreate_date_order() {
       return create_date_order;
   }

   public void setCreate_date_order(Date create_date_order) {
       this.create_date_order = create_date_order;
   }

   public Date getPay_date() {
       return pay_date;
   }
   
   public void setPay_date(Date pay_date) {
       this.pay_date = pay_date;
   }

   public Date getDelivery_date() {
       return delivery_date;
   }

   public void setDelivery_date(Date delivery_date) {
       this.delivery_date = delivery_date;
   }

   public Date getConfirm_date() {
       return confirm_date;
   }

   public void setConfirm_date(Date confirm_date) {
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
