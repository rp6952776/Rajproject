<%@page import="java.util.List"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.bean.wishlist"%>
<%@page import="com.dao.wishlistdao"%>
<%@ include file="header.jsp" %>

<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=u.getUid();
	wishlist w=new wishlist();
	w.setPid(pid);
	w.setUid(uid);
	wishlistdao.remove_from_wishlist(w);
	List<wishlist> list=wishlistdao.getwishlistbyuser(u.getUid());
	int wishlist_count=list.size();
    session.setAttribute("wishlist_count", wishlist_count);
	response.sendRedirect("wishlist.jsp");
%>