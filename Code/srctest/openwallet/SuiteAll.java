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
  //, ItemCartTest.class,
  //ItemOrderTest.class
})

public class SuiteAll {}
