<%
     session.removeAttribute("u");
     session.invalidate();
     request.setAttribute("msg",request.getAttribute("msg"));
     request.getRequestDispatcher("login.jsp").forward(request, response); 
%>