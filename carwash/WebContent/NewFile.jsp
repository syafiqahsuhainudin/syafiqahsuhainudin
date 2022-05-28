<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

--%>
<%@ page import ="java.sql.*"%>
<%

	try{
		String adminusername = request.getParameter("adminusername");
		String adminpass = request.getParameter("adminpass");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:carwash/carwash@localhost");
	
	PreparedStatement pst=con.prepareStatement("select adminusername,adminpass from admin where adminusername=? and adminpass=?");
		pst.setString(1, adminusername);
		pst.setString(2, adminpass);
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{out.println("Valid login credentials");
		response.sendRedirect("index3.jsp");}
		else
			out.println("Invalid login credentials");
	
	}
	catch(Exception e) {
		out.println("Something went wrong !! Please try again");
	}
%>
</body>
</html>