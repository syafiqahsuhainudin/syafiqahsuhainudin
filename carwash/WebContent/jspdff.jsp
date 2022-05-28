<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.io.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>

<%
       String name[]=request.getParameterValues("name");
       String address[]=request.getParameterValues("address");
       try{
       Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:/data.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(2);
       table.addCell("Name");
       table.addCell("Address");
       for(int i=0;i<name.length;i++){
       table.addCell(name[i]);
       table.addCell(address[i]);
       }
       document.add(table);
       document.close();
       }
       catch(Exception e){}
  %>
</body>
</html>