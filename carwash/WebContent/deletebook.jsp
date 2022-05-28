<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="carwash.dao.BookDAO"%>  
<jsp:useBean id="u" class="carwash.model.BookingBean"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>   
<%  
BookDAO.delete(u);  
response.sendRedirect("bookingdetail.jsp");  
%>
</body>
</html>