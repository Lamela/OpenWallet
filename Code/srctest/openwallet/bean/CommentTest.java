package openwallet.bean;

import openwallet.bean.Comment;
import openwallet.dao.CommentDAO;
import org.junit.*;

public class CommentTest {
  private Comment comment;
  private CommentDAO commentDAO;
  private User user;
  private Product product;
  private Date date_comment;
  private double note;
  private int id_comment;

  @Before
  public void avantTest(){
    this.user = new User("Open","Wallet",new Date(0).valueOf("1995-11-21"),
    "normalType", false, "open.wallet@gmail.com", "mdp", "0611111111", "123456");
    this.date_comment = new Date(0).valueOf("2018-01-20");
    this.product = new Product();
    this.note = 0.0;
    this.comment = new Comment(user,product,date_comment,note);

    this.commentDAO = new CommentDAO();
    this.id_comment = commentDAO.add(comment);
  }

  @Test
  public void testAdd() {
    Comment comment2= commentDAO.get(id_comment);

    assertEquals(this.assertCommentEquals(this.comment, comment2), true);
  }

  @Test
  public void testUpdate(){
    this.comment.setDate_comment(new Date(0).valueOf("2018-01-18"));
    this.commentDAO.update(this.comment);
    Comment comment2= commentDAO.get(id_comment);

    assertEquals(comment2.getDate_comment().equals(new Date(0).valueOf("2018-01-18")), true);
  }

  @Test
  public void testDelete(){
    Comment comment2= commentDAO.get(id_comment);

    id_comment2 = commentDAO.add(comment2);
    commentDAO.delete(id_comment2);

    assertEquals(commentDAO.get(id_comment2), null);
  }

  private boolean assertCommentEquals(Comment comment1,Comment comment2) {

    if(comment1.getId_comment()!=comment2.getId_comment()) {
      System.out.println("TestComment Error: id_comment not equals !");
    } else {
      if(!comment1.getUser().equals(comment2.getUser())) {
        System.out.println("TestComment Error: User not equals !");
      }else {
        if(!comment1.getProduct().equals(comment2.getProduct())) {
          System.out.println("TestComment Error: Product not equals !");
        } else {
          if(!comment1.getNote().equals(comment2.getNote())) {
            System.out.println("TestComment Error: Note not equals !");
          } else {
            if(!comment1.getDate_comment().equals(comment2.getDate_comment())) {
              System.out.println("TestComment Error: Date_comment not equals !");
            }
          }
        }
      }
    }

    return equal;

  }
}
