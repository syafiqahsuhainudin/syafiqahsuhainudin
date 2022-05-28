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
import carwash.dao.BookingDao;
import carwash.model.BookingBean;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/bookingcontroller")

public class bookingcontroller extends HttpServlet {
	 /**
     * @see HttpServlet#HttpServlet()
     */
	private static final long serialVersionUID = 1L;
	 private static String ADD = "/package.jsp";
	    private static String UPDATE = "/edit.jsp";
	   
	    private static String LIST_ALL = "/bookingdetail.jsp";
	    private BookingDao dao;
    
    public bookingcontroller() {
        super();
        dao = new BookingDao();
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
	            BookingBean booking = dao.getBookingById(book_id);
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
		BookingBean booking = new BookingBean();
		booking.setBook_date(request.getParameter("book_date"));
		booking.setBook_time(request.getParameter("book_time"));
		booking.setCar_plateno(request.getParameter("car_plateno"));
		booking.setCar_name(request.getParameter("car_name"));
		booking.setCartype(request.getParameter("cartype"));
		booking.setCar_package(request.getParameter("car_package"));

		String book_id = request.getParameter("book_id");
		if(book_id == null || book_id.isEmpty()){
	        dao.add(booking);
	    }
	    else{
	         booking.setBook_id(Integer.parseInt(book_id));
	         dao.updateBooking(booking);
	   }
	        response.sendRedirect("bookingdetail.jsp");
	}

}
