package openwallet.bean;

import openwallet.bean.Orders;
import openwallet.bean.User;
import openwallet.dao.OrdersDAO;
import openwallet.dao.UserDAO;
import org.junit.*;
import java.sql.Date;
import java.util.List;


public class OrdersTest {
  private OrdersDAO ordersDAO;
  private Orders orders;
  private int id_orders;
  private User user;
  private Address address;
  private List<ItemOrder> itemOrders;

  @Before
  public void avantTest(){
    this.itemOrders = null;
    this.user = new User("Open","Wallet",new Date(0).valueOf("1995-11-21"),
    "normalType", false, "open.wallet@gmail.com", "mdp", "0611111111", "123456");

    this.address = new Address(user,"Jean",
     "Dupont", "0611111111", "Rue République","Rouen", "France", "76000");
     this.orders = new Orders(this.user, 100.0, this.address, this.address, "user_message", new Date(0).valueOf("2017-11-21"), new Date(0).valueOf("2017-11-21"), new Date(0).valueOf("2017-11-21"), new Date(0).valueOf("2017-11-21"),"Finished", 10, this.itemOrders);

    this.ordersDAO = new OrdersDAO();
    this.id_orders = this.ordersDAO.add(this.orders);
  }

  @Test
  public void testAdd() {
    Orders orders2= this.ordersDAO.get(this.id_orders);

    Assert.assertEquals(this.assertOrdersEquals(this.orders, orders2), true);
  }

  @Test
  public void testUpdate(){
    this.orders.setCreate_date_order(new Date(0).valueOf("2018-01-18"));
    this.ordersDAO.update(this.orders);
    Orders orders2= ordersDAO.get(this.id_orders);

    Assert.assertEquals(orders2.getCreate_date_order().equals(new Date(0).valueOf("2018-01-18")), true);
  }

  @Test
  public void testDelete(){
    Orders orders2= ordersDAO.get(this.id_orders);

    int id_orders2 = ordersDAO.add(orders2);
    ordersDAO.delete(id_orders2);

    Assert.assertEquals(ordersDAO.get(id_orders2), null);
  }

  private boolean assertOrdersEquals(Orders orders1,Orders orders2) {
    boolean equal=false;

    if(orders1.getId_order()!=orders2.getId_order()) {
      System.out.println("TestOrders Error: id_order not equals !");
    } else {
      if(orders1.getUser().getId_user()!=orders2.getUser().getId_user()) {
        System.out.println("TestOrders Error: User not equals !");
      }else {
        if(!orders1.getStatus().equals(orders2.getStatus())) {
          System.out.println("TestOrders Error: status not equals !");
        } else {
          if(orders1.getTotal_price()!=orders2.getTotal_price()) {
            System.out.println("TestOrders Error: total_price not equals !");
          } else {
            if(orders1.getInvoice_address().getId_address()!=orders2.getInvoice_address().getId_address()) {
              System.out.println("TestOrders Error: invoice_address not equals !");
            } else {
              if(orders1.getDelivery_address().getId_address()!=orders2.getDelivery_address().getId_address()) {
                System.out.println("TestOrders Error: delivery_address not equals !");
              }
            }
          }
        }
      }
    }

    return equal;

  }
}
