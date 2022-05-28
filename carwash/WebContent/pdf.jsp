<%@page import="java.io.*"%>
<%@page import="com.lowagie.text.*"%>
<%@page import="com.lowagie.text.pdf.*"%>

<%

	     String book_date[]= request.getParameterValues("book_date");
		 String book_time[]=request.getParameterValues("book_time");
	 String car_plateno[]=request.getParameterValues("car_plateno");
	 String car_name[]=request.getParameterValues("car_name");
		 String cartype[]=request.getParameterValues("cartype");
		 String car_package[]=request.getParameterValues("car_package");
       try{
       Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("C:/data.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(2);
       table.addCell("Date");
       table.addCell("Time");
	   table.addCell("Car Plate");
       table.addCell("Car Name");
	      table.addCell("Car type");
       table.addCell("Car package");
    
  
	    
       document.add(table);
       document.close();
       }
       catch(Exception e){}
  %>