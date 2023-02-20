<%@page import="com.dao.productDao"%>
<%
   int pid=Integer.parseInt(request.getParameter("pid"));
   productDao.deleteproductbypid(pid);
   response.sendRedirect("seller-view-product.jsp");

%>