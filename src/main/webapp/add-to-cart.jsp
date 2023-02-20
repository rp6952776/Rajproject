<%@page import="com.dao.cartdao"%>
<%@page import="com.bean.cart"%>
<%@page import="com.dao.productDao"%>
<%@page import="com.bean.product"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.dao.wishlistdao"%>
<%@ include file="header.jsp" %>

<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=u.getUid();
	int product_qty=1;
	product p=productDao.getproductbypid(pid);
	int product_price=p.getProduct_price();
	int total_price=p.getProduct_price();
	String payment_status="pending";
	cart c=new cart();
	c.setUid(uid);
	c.setPid(pid);
	c.setProduct_price(product_price);
	c.setProduct_qty(product_qty);
	c.setTotal_price(total_price);
	c.setPayment_status(payment_status);
	cartdao.addtocart(c);
	List<cart> list=cartdao.getcartbyuser(u.getUid());
	int cart_count=list.size();
    session.setAttribute("cart_count", cart_count);
	response.sendRedirect("cart.jsp");
%>