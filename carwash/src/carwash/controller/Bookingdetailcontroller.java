package carwash.controller;
import java.text.ParseException;  

import java.util.Date;  
import java.util.Locale;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import carwash.dao.Bookingdetaildao;
import carwash.model.Bookingdetailbean;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Bookingdetailcontroller")

public class 	Bookingdetailcontroller extends HttpServlet {
	 /**
     * @see HttpServlet#HttpServlet()
     */
	private static final long serialVersionUID = 1L;
	 private static String ADD = "/package.jsp";
	    private static String UPDATE = "/edit.jsp";
	   
	    private static String LIST_ALL = "/customerdetail.jsp";
	    private Bookingdetaildao dao;
    
    public Bookingdetailcontroller() {
        super();
        dao = new Bookingdetaildao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
        	    int book_id = Integer.parseInt(request.getParameter("book_id"));
	            dao.deleteBooking(book_id);
	            forward = LIST_ALL;
	            request.setAttribute("bookings", dao.getAllBooking());    
        } else if (action.equalsIgnoreCase("update")){
        	    forward = UPDATE;
        	      
        	    int book_id = Integer.parseInt(request.getParameter("book_id"));
        	    Bookingdetailbean booking = dao.getBookingById(book_id);
	            request.setAttribute("booking", booking);
        } else if (action.equalsIgnoreCase("listAll")){
        	forward = LIST_ALL;
        	request.setAttribute("bookings", dao.getAllBooking());
        }else {
            forward = ADD;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bookingdetailbean booking = new Bookingdetailbean();
		booking.setBook_date(request.getParameter("book_date"));
		booking.setBook_time(request.getParameter("book_time"));
		booking.setCar_plateno(request.getParameter("car_plateno"));
		booking.setCar_name(request.getParameter("car_name"));
		booking.setCartype(request.getParameter("cartype"));
		booking.setCar_package(request.getParameter("car_package"));
		booking.setCust_name(request.getParameter("cust_name"));
		booking.setCust_phone(request.getParameter("cust_phone"));
		booking.setCust_email(request.getParameter("cust_email"));

		String book_id = request.getParameter("book_id");
		if(book_id == null || book_id.isEmpty()){
	        dao.add(booking);
	    }
	    else{
	         booking.setBook_id(Integer.parseInt(book_id));
	         dao.updateBooking(booking);
	   }
	        response.sendRedirect("customerdetail.jsp");
	}

}
