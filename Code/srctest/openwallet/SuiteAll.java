package openwallet;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
  User.class,
  AddressTest.class,
  ProductTest.class,
  CommentTest.class,
  OrdersTest.class,
  CategoryTest.class
  //, Item_CartTest.class,
  //Item_OrderTest.class
})

public class SuiteAll {}
