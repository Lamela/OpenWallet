package openwallet.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import openwallet.bean.*;
import openwallet.util.*;
  
public class ProductDAO {
    
    //get the total number of product of the category
    public int getTotal(int id_category) {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from Product where id_category = " + id_category;
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }

	public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from Product";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public void add(Product bean) {
 
        String sql = "insert into Product values(null,?,?,?,?,?,?,?, ?, ?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, bean.getCategory().getId_category());
            ps.setInt(2, bean.getUser().getId_user());
            ps.setString(3, bean.getName_product());
            ps.setString(4, bean.getDescription());
            ps.setDouble(5, bean.getPrice());
            ps.setInt(6, bean.getStock());
            ps.setTimestamp(7, DateUtil.d2t(bean.getCreate_date_product()));
            ps.setString(8, bean.getOrigin());
            ps.setInt(9, bean.getSold());
            ps.setString(10, bean.getBrand());
            ps.setString(11, bean.getColor());
            ps.setString(12, bean.getMaterial());
            ps.execute();
  
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId_product(id);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public void update(Product bean) {
 
        String sql = "update Product set id_category = ?, id_user = ?, name_product = ?, description = ?, price = ?, stock = ?, create_date_product = ?, origin = ?, sold = ?, brand = ?, color = ?, material = ? where id_product = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, bean.getCategory().getId_category());
            ps.setInt(2, bean.getUser().getId_user());
            ps.setString(3, bean.getName_product());
            ps.setString(4, bean.getDescription());
            ps.setDouble(5, bean.getPrice());
            ps.setInt(6, bean.getStock());
            ps.setTimestamp(7, DateUtil.d2t(bean.getCreate_date_product()));
            ps.setString(8, bean.getOrigin());
            ps.setInt(9, bean.getSold());
            ps.setString(10, bean.getBrand());
            ps.setString(11, bean.getColor());
            ps.setString(12, bean.getMaterial());
            ps.setInt(14, bean.getId_product());
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
  
    public void delete(int id_product) {
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from Product where id_product = " + id_product;
  
            s.execute(sql);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
    }
  
    public Product get(int id_product) {
        Product bean = new Product();
  
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from Product where id_product = " + id_product;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {

                int id_category = rs.getInt("id_category");
                Category category = new CategoryDAO().get(id_category);
                int id_user = rs.getInt("id_user");
                User user = new UserDAO().get(id_user);
                String name_product = rs.getString("name_product");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                Date create_date_product = DateUtil.t2d(rs.getTimestamp("create_date_product"));
                String origin = rs.getString("origin");
                int sold = rs.getInt("sold");
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String material = rs.getString("material");
               
                bean.setCategory(category);
                bean.setUser(user);
                bean.setName_product(name_product);
                bean.setDescription(description);
                bean.setPrice(price);
                bean.setStock(stock);
                bean.setCreate_date_product(create_date_product);
                bean.setOrigin(origin);
                bean.setSold(sold);
                bean.setBrand(brand);
                bean.setColor(color);
                bean.setMaterial(material);
                bean.setId_product(id_product);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return bean;
    }
  
    public List<Product> list(int id_category) {
        return list(id_category,0, Short.MAX_VALUE);
    }
  
    public List<Product> list(int id_category, int start, int count) {
        List<Product> beans = new ArrayList<Product>();
        Category category = new CategoryDAO().get(id_category);
        String sql = "select * from Product where id_category = ? order by id_product desc limit ?,? ";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id_category);
            ps.setInt(2, start);
            ps.setInt(3, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                Product bean = new Product();
                int id_product = rs.getInt(1);
                int id_user = rs.getInt("id_user");
                User user = new UserDAO().get(id_user);
                String name_product = rs.getString("name_product");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                Date create_date_product = DateUtil.t2d(rs.getTimestamp("create_date_product"));
                String origin = rs.getString("origin");
                int sold = rs.getInt("sold");
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String material = rs.getString("material");
 
                bean.setCategory(category);
                bean.setUser(user);
                bean.setName_product(name_product);
                bean.setDescription(description);
                bean.setPrice(price);
                bean.setStock(stock);
                bean.setCreate_date_product(create_date_product);
                bean.setOrigin(origin);
                bean.setSold(sold);
                bean.setBrand(brand);
                bean.setColor(color);
                bean.setMaterial(material);
                bean.setId_product(id_product);
                beans.add(bean);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }
    public List<Product> list() {
        return list(0,Short.MAX_VALUE);
    }
    public List<Product> list(int start, int count) {
        List<Product> beans = new ArrayList<Product>();
 
        String sql = "select * from Product limit ?,? ";
  
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
 
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                Product bean = new Product();
                int id_product = rs.getInt(1);
                int id_category = rs.getInt("id_category");
                Category category = new CategoryDAO().get(id_category);
                int id_user = rs.getInt("id_user");
                User user = new UserDAO().get(id_user);
                String name_product = rs.getString("name_product");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                Date create_date_product = DateUtil.t2d(rs.getTimestamp("create_date_product"));
                String origin = rs.getString("origin");
                int sold = rs.getInt("sold");
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String material = rs.getString("material");
               
                bean.setCategory(category);
                bean.setUser(user);
                bean.setName_product(name_product);
                bean.setDescription(description);
                bean.setPrice(price);
                bean.setStock(stock);
                bean.setCreate_date_product(create_date_product);
                bean.setOrigin(origin);
                bean.setSold(sold);
                bean.setBrand(brand);
                bean.setColor(color);
                bean.setMaterial(material);
                bean.setId_product(id_product);
                beans.add(bean);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return beans;
    }    
 
    public void fill(List<Category> cs) {
        for (Category c : cs) 
            fill(c);
    }
    public void fill(Category c) {
            List<Product> ps = this.list(c.getId_category());
            c.setProducts(ps);
    }
 
    public void fillByRow(List<Category> cs) {
        int productNumberEachRow = 8;
        for (Category c : cs) {
            List<Product> products =  c.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }
     
    // public void setFirstProductImage(Product p) {
    //     List<ProductImage> pis= new ProductImageDAO().list(p, ProductImageDAO.type_single);
    //     if(!pis.isEmpty())
    //         p.setFirstProductImage(pis.get(0));     
    // }
     
    public void setCommentNumber(Product p) {        
        int commentCount = new CommentDAO().getCount(p.getId_product());
        p.setComment_count(commentCount);
         
    }
 
    public void setCommentNumber(List<Product> products) {
        for (Product p : products) {
            setCommentNumber(p);
        }
    }
 
    public List<Product> search(String keyword, int start, int count) {
         List<Product> beans = new ArrayList<Product>();
          
         if(null==keyword||0==keyword.trim().length())
             return beans;
            String sql = "select * from Product where name_product like ? limit ?,? ";
      
            try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, "%"+keyword.trim()+"%");
                ps.setInt(2, start);
                ps.setInt(3, count);
      
                ResultSet rs = ps.executeQuery();
      
                while (rs.next()) {
                    Product bean = new Product();
                    int id = rs.getInt(1);
                    int id_category = rs.getInt("id_category");
                    Category category = new CategoryDAO().get(id_category);
                    int id_user = rs.getInt("id_user");
                    User user = new UserDAO().get(id_user);
                    String name_product = rs.getString("name_product");
                    String description = rs.getString("description");
                    double price = rs.getDouble("price");
                    int stock = rs.getInt("stock");
                    Date create_date_product = DateUtil.t2d(rs.getTimestamp("create_date_product"));
                    String origin = rs.getString("origin");
                    int sold = rs.getInt("sold");
                    String brand = rs.getString("brand");
                    String color = rs.getString("color");
                    String material = rs.getString("material");

                    bean.setCategory(category);
                    bean.setUser(user);
                    bean.setName_product(name_product);
                    bean.setDescription(description);
                    bean.setPrice(price);
                    bean.setStock(stock);
                    bean.setCreate_date_product(create_date_product);
                    bean.setOrigin(origin);
                    bean.setSold(sold);
                    bean.setBrand(brand);
                    bean.setColor(color);
                    bean.setMaterial(material);
                    bean.setId_product(id);             
                    beans.add(bean);
                }
            } catch (SQLException e) {
      
                e.printStackTrace();
            }
            return beans;
    }
}
