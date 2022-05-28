<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--

Document	: insertpage
Created on	: Nov 24, 2015, 12:32:42 PM
Author		: hairi

--%>

<%@ page import ="java.sql.*"%>
<%
		String book_date = request.getParameter("book_date");
		String carlimit_perday = request.getParameter("carlimit_perday");
	

		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:carwash/carwash@localhost");
		
		Statement pst=con.createStatement();
		pst.executeUpdate
		("insert into carlimit(book_date,carlimit_perday) values('"+book_date+"','"+carlimit_perday+"')");
		%>
		
		<script type="text/javascript">
		
		alert('Succesfully insert');
		window.location='addcarlimit.jsp';
		</script>
</body>
</html>