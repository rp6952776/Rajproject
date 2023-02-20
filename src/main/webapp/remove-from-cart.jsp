<%@page import="com.bean.cart"%>
<%@page import="com.dao.cartdao"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.dao.wishlistdao"%>
<%@ include file="header.jsp" %>

<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=u.getUid();
	cartdao.removefromcart(uid, pid);
	List<cart> list=cartdao.getcartbyuser(u.getUid());
	int cart_count=list.size();
    session.setAttribute("cart_count", cart_count);
	response.sendRedirect("cart.jsp");
%>