package carwash.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.carwash.ConnectionManager;


@WebServlet("/checkavailability")

public class checkavailability extends HttpServlet {

 private static final long serialVersionUID = -734503860925086969L;
 static Connection currentCon = null;
 String book_date,book_time,car_plateno,car_name,cartype,car_package;
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

        	currentCon = ConnectionManager.getConnection();
        	
            String book_date = request.getParameter("book_date");
            String book_time = request.getParameter("book_time");
            String car_plateno = request.getParameter("car_plateno");
            String car_name = request.getParameter("car_name");
            String  cartype = request.getParameter("cartype");
            String car_package = request.getParameter("car_package");
            int cust_id = Integer.parseInt(request.getParameter("cust_id"));
            
            PreparedStatement ps = currentCon.prepareStatement("select book_date,book_time from booking where book_date=? AND book_time=? ");
            ps.setString(1,book_date);
            ps.setString(2,book_time);
 
            ResultSet rs = ps.executeQuery();
             
            if (!rs.next()) {
            	ps=currentCon.prepareStatement("insert into booking(book_date,book_time,car_plateno,car_name,cartype,car_package,cust_id)values(?,?,?,?,?,?,?)");
            	
            	ps.setString(1,book_date);
    			ps.setString(2,book_time);
    			ps.setString(3,car_plateno);
    			ps.setString(4,car_name);
    			ps.setString(5,cartype);
    			ps.setString(6,car_package);
    			ps.setInt(7,cust_id);
    			ps.executeUpdate();
    		      response.sendRedirect("bookingdetail.jsp");
            }
            else{
            out.println();
        	JOptionPane.showMessageDialog(null,""+book_date+"  and "+book_time+"  is already in use" );
        	response.sendRedirect("bookingdetail.jsp");
            }
            out.println();

        } catch (Exception ex) {
            out.println("Error ->" + ex.getMessage());
        } finally {
            out.close();
            
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
