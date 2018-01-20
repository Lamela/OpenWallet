package openwallet.servlet;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.util.HtmlUtils;


import openwallet.bean.*;
// import openwallet.comparator.ProductAllComparator;
// import openwallet.comparator.ProductDateComparator;
// import openwallet.comparator.ProductPriceComparator;
// import openwallet.comparator.ProductReviewComparator;
// import openwallet.comparator.ProductSaleCountComparator;
import openwallet.dao.*;
import openwallet.util.Page;

public class ForeServlet extends BaseForeServlet {

	public String home(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<Category> cs= new CategoryDAO().list();
		new ProductDAO().fill(cs);
		new ProductDAO().fillByRow(cs);
		request.setAttribute("cs", cs);
		return "home.jsp";
	}

	public String register(HttpServletRequest request, HttpServletResponse response, Page page) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		email = HtmlUtils.htmlEscape(email);
		System.out.println(email);
		boolean exist = userDAO.isExist(email, password);
		
		if(exist){
			request.setAttribute("msg", "This email has been used, please change another one.");
			return "register.jsp";	
		}
		
		User user = new User();
		String firstname_user = request.getParameter("firstname_user");
		String lastname_user = request.getParameter("lastname_user");
		String[] date = request.getParameter("birthday").split("-");
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
		Date birthday = cal.getTime();
		String type_user = request.getParameter("type_user");
		boolean premium = false;
		String mobile_number = request.getParameter("mobile_number");
		String number_id_card = request.getParameter("number_id_card");

		user.setFirstname_user(firstname_user);
		user.setLastname_user(lastname_user);
		user.setBirthday(birthday);
		user.setType_user(type_user);
		user.setPremium(false);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobile_user(mobile_number);
		user.setNumber_id_card(number_id_card);
		System.out.println(user.getFirstname_user());
		System.out.println(user.getLastname_user());
		System.out.println(user.getPassword());
		userDAO.add(user);
		
		return "@registerSuccess.jsp";	
	}	

	public String login(HttpServletRequest request, HttpServletResponse response, Page page) {
		String email = request.getParameter("email");
		email = HtmlUtils.htmlEscape(email);
		String password = request.getParameter("password");		
		
		User user = userDAO.get(email, password);
		 
		if(null==user){
			request.setAttribute("msg", "Wrong email or password");
			return "login.jsp";	
		}
		request.getSession().setAttribute("user", user);
		return "@forehome";	
	}	
	
	public String product(HttpServletRequest request, HttpServletResponse response, Page page) {
		int pid = Integer.parseInt(request.getParameter("id_product"));
		Product p = productDAO.get(pid);
		
		//List<ProductImage> productSingleImages = productImageDAO.list(p, ProductImageDAO.type_single);
		//List<ProductImage> productDetailImages = productImageDAO.list(p, ProductImageDAO.type_detail);
		//p.setProductSingleImages(productSingleImages);
		//p.setProductDetailImages(productDetailImages);
		
		//List<PropertyValue> pvs = propertyValueDAO.list(p.getId());		
	
		List<Comment> comments = commentDAO.list(p.getId_product());
		
		//productDAO.setSaleAndReviewNumber(p);

		request.setAttribute("comments", comments);

		request.setAttribute("p", p);
		// request.setAttribute("pvs", pvs);
		return "product.jsp";		
	}

	public String logout(HttpServletRequest request, HttpServletResponse response, Page page) {
		request.getSession().removeAttribute("user");
		return "@forehome";	
	}

	public String checkLogin(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user =(User) request.getSession().getAttribute("user");
		if(null!=user)
			return "%success";
		return "%fail";
	}

	public String loginAjax(HttpServletRequest request, HttpServletResponse response, Page page) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");		
		User user = userDAO.get(email,password);
		
		if(null==user){
			return "%fail";	
		}
		request.getSession().setAttribute("user", user);
		return "%success";	
	}

	public String category(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("id_cagetory"));
		
		Category c = new CategoryDAO().get(cid);
		new ProductDAO().fill(c);
		// new ProductDAO().setSaleAndReviewNumber(c.getProducts());		
	/*	
		String sort = request.getParameter("sort");
		if(null!=sort){
		switch(sort){
			case "review":
				Collections.sort(c.getProducts(),new ProductReviewComparator());
				break;
			case "date" :
				Collections.sort(c.getProducts(),new ProductDateComparator());
				break;
				
			case "saleCount" :
				Collections.sort(c.getProducts(),new ProductSaleCountComparator());
				break;
				
			case "price":
				Collections.sort(c.getProducts(),new ProductPriceComparator());
				break;
				
			case "all":
				Collections.sort(c.getProducts(),new ProductAllComparator());
				break;
			}
		}
	*/	
		request.setAttribute("c", c);
		return "category.jsp";		
	}
	
	public String search(HttpServletRequest request, HttpServletResponse response, Page page){
		String keyword = request.getParameter("keyword");
		List<Product> ps= new ProductDAO().search(keyword,0,20);
		//productDAO.setSaleAndReviewNumber(ps);
		request.setAttribute("ps",ps);
		return "searchResult.jsp";
	}

	public String buyone(HttpServletRequest request, HttpServletResponse response, Page page) {
		int pid = Integer.parseInt(request.getParameter("id_product"));
		int num = Integer.parseInt(request.getParameter("num"));
		Product p = productDAO.get(pid);
		int oiid = 0;
		
		User user =(User) request.getSession().getAttribute("user");
		boolean found = false;
		List<ItemOrder> ois = itemOrderDAO.listByUser(user.getId_user());
		for (ItemOrder oi : ois) {
			if(oi.getProduct().getId_product() == p.getId_product()){
				oi.setNumber_item_order(oi.getNumber_item_order()+num);
				itemOrderDAO.update(oi);
				found = true;
				oiid = oi.getId_item_order();
				break;
			}
		}		

		if(!found){
			ItemOrder oi = new ItemOrder();
			oi.setUser(user);
			oi.setNumber_item_order(num);
			oi.setProduct(p);
			itemOrderDAO.add(oi);
			oiid = oi.getId_item_order();
		}
		return "@forebuy?oiid="+oiid;
	}

	
	public String buy(HttpServletRequest request, HttpServletResponse response, Page page){
		String[] oiids=request.getParameterValues("oiid");
		List<ItemOrder> ois = new ArrayList<>();
		float total = 0;

		for (String strid : oiids) {
			int oiid = Integer.parseInt(strid);
			ItemOrder oi= itemOrderDAO.get(oiid);
			total +=oi.getProduct().getPrice()*oi.getNumber_item_order();
			ois.add(oi);
		}
		
		request.getSession().setAttribute("ois", ois);
		request.setAttribute("total", total);
		return "buy.jsp";
	}	

	public String addCart(HttpServletRequest request, HttpServletResponse response, Page page) {
		int pid = Integer.parseInt(request.getParameter("id_product"));
		Product p = productDAO.get(pid);
		int num = Integer.parseInt(request.getParameter("num"));
		
		User user =(User) request.getSession().getAttribute("user");
		boolean found = false;

		List<ItemOrder> ois = itemOrderDAO.listByUser(user.getId_user());
		for (ItemOrder oi : ois) {
			if(oi.getProduct().getId_product() == p.getId_product()){
				oi.setNumber_item_order(oi.getNumber_item_order()+num);
				itemOrderDAO.update(oi);
				found = true;
				break;
			}
		}		
		

		if(!found){
			ItemOrder oi = new ItemOrder();
			oi.setUser(user);
			oi.setNumber_item_order(num);
			oi.setProduct(p);
			itemOrderDAO.add(oi);
		}
		return "%success";
	}

	public String cart(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user =(User) request.getSession().getAttribute("user");
		List<ItemOrder> ois = itemOrderDAO.listByUser(user.getId_user());
		request.setAttribute("ois", ois);
		return "cart.jsp";
	}

	public String changeItemOrder(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user =(User) request.getSession().getAttribute("user");
		if(null==user)
			return "%fail";

		int pid = Integer.parseInt(request.getParameter("id_product"));
		int number = Integer.parseInt(request.getParameter("number"));
		List<ItemOrder> ois = itemOrderDAO.listByUser(user.getId_user());
		for (ItemOrder oi : ois) {
			if(oi.getProduct().getId_product() == pid){
				oi.setNumber_item_order(number);
				itemOrderDAO.update(oi);
				break;
			}
			
		}		
		return "%success";
	}

	public String deleteItemOrder(HttpServletRequest request, HttpServletResponse response, Page page){
		User user =(User) request.getSession().getAttribute("user");
		if(null==user)
			return "%fail";
		int oiid = Integer.parseInt(request.getParameter("oiid"));
		itemOrderDAO.delete(oiid);
		return "%success";
	}

	public String createOrder(HttpServletRequest request, HttpServletResponse response, Page page){
		User user =(User) request.getSession().getAttribute("user");

		String firstname_receiver = request.getParameter("firstname_receiver");
		String lastname_receiver = request.getParameter("lastname_receiver");
		String mobile_receiver = request.getParameter("mobile_receiver");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String post_address = request.getParameter("post_address");
		Address delivery_address = new Address();
		delivery_address.setUser(user);
		delivery_address.setFirstname_receiver(firstname_receiver);
		delivery_address.setLastname_receiver(lastname_receiver);
		delivery_address.setMobile_receiver(mobile_receiver);
		delivery_address.setStreet(street);
		delivery_address.setCity(city);
		delivery_address.setCountry(country);
		delivery_address.setPost_address(post_address);
		Address invoice_address = delivery_address;
		String user_message = request.getParameter("user_message");
		
		
		Orders order = new Orders();
		order.setUser(user);
		List<ItemOrder> ois= (List<ItemOrder>) request.getSession().getAttribute("ois");		
		double total =0;
		int totalNumber = 0;
		for (ItemOrder oi: ois) {
			oi.setOrders(order);
			itemOrderDAO.update(oi);
			total+=oi.getProduct().getPrice()*oi.getNumber_item_order();
			totalNumber += oi.getNumber_item_order();
		}
		order.setTotal_price(total);
		order.setDelivery_address(delivery_address);
		order.setInvoice_address(invoice_address);
		order.setUser_message(user_message);
		order.setCreate_date_order(new Date());
		order.setStatus(OrdersDAO.waitPay);
		order.setTotal_number(totalNumber);
		order.setItemOrders(ois);

		orderDAO.add(order);

		
		return "@forealipay?oid="+order.getId_order() +"&total="+total;
	}
	
	public String payed(HttpServletRequest request, HttpServletResponse response, Page page) {
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders order = orderDAO.get(oid);
		order.setStatus(OrdersDAO.waitDelivery);
		order.setPay_date(new Date());
		new OrdersDAO().update(order);
		request.setAttribute("o", order);
		return "payed.jsp";		
	}	

	public String bought(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user =(User) request.getSession().getAttribute("user");
		List<Orders> os= orderDAO.list(user.getId_user(), OrdersDAO.delete);
		
		itemOrderDAO.fill(os);
		
		request.setAttribute("os", os);
		
		return "bought.jsp";		
	}

	public String confirmPay(HttpServletRequest request, HttpServletResponse response, Page page) {
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders o = orderDAO.get(oid);
		itemOrderDAO.fill(o);
		request.setAttribute("o", o);
		return "confirmPay.jsp";		
	}
	
	public String orderConfirmed(HttpServletRequest request, HttpServletResponse response, Page page) {
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders o = orderDAO.get(oid);
		o.setStatus(OrdersDAO.waitReview);
		o.setConfirm_date(new Date());
		orderDAO.update(o);
		return "orderConfirmed.jsp";
	}	
	
	
	public String deleteOrder(HttpServletRequest request, HttpServletResponse response, Page page){
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders o = orderDAO.get(oid);
		o.setStatus(OrdersDAO.delete);
		orderDAO.update(o);
		return "%success";		
	}

	public String comment(HttpServletRequest request, HttpServletResponse response, Page page) {
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders o = orderDAO.get(oid);
		itemOrderDAO.fill(o);
		Product p = o.getItemOrders().get(0).getProduct();
		List<Comment> comment = commentDAO.list(p.getId_product());
		//productDAO.setSaleAndReviewNumber(p);
		request.setAttribute("p", p);
		request.setAttribute("o", o);
		request.setAttribute("comment", comment);
		return "comment.jsp";		
	}

	public String docomment(HttpServletRequest request, HttpServletResponse response, Page page) {
		int oid = Integer.parseInt(request.getParameter("oid"));
		Orders o = orderDAO.get(oid);
		o.setStatus(OrdersDAO.finish);
		orderDAO.update(o);
		int pid = Integer.parseInt(request.getParameter("id_product"));
		Product p = productDAO.get(pid);
		
		String content = request.getParameter("content");
		
		content = HtmlUtils.htmlEscape(content);
		double note = Double.parseDouble(request.getParameter("note"));

		User user =(User) request.getSession().getAttribute("user");
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setProduct(p);
		comment.setDate_comment(new Date());
		comment.setUser(user);
		comment.setNote(note);
		commentDAO.add(comment);
		
		return "@forecomment?oid="+oid+"&showonly=true";		
	}
	
}
