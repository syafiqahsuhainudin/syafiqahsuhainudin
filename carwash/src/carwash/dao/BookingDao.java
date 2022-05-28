package carwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.carwash.ConnectionManager;
import carwash.model.BookingBean;

public class BookingDao {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int book_id;
	String book_date,book_time,car_plateno,car_name,cartype,car_package;
	
	
	
	public void add(BookingBean bean){
		book_id = bean.getBook_id();
		book_date = bean.getBook_date();
		book_time = bean.getBook_time();
		car_plateno = bean.getCar_plateno();
		car_name = bean.getCar_name();
		cartype = bean.getCartype();
		car_package = bean.getCar_package();
		
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into booking(book_date,book_time,car_plateno,car_name,cartype,car_package)values(?,?,?,?,?,?)");
			ps.setString(1,book_date);
			ps.setString(2,book_time);
			ps.setString(3,car_plateno);
			ps.setString(4,car_name);
			ps.setString(5,cartype);
			ps.setString(6,car_package);
			ps.executeUpdate();
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		}
	
	public void deleteBooking(int book_id) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps=currentCon.prepareStatement("delete from booking where book_id=?");
	        ps.setInt(1, book_id);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateBooking(BookingBean bean) {

		book_id = bean.getBook_id();
		book_date = bean.getBook_date();
		book_time = bean.getBook_time();
		car_plateno = bean.getCar_plateno();
		car_name = bean.getCar_name();
		cartype = bean.getCartype();
		car_package = bean.getCar_package();
		
		String searchQuery = "UPDATE booking SET book_date = '" + book_date + "', book_time='" + book_time+ "', car_plateno='" +car_plateno + "', car_name='" + car_name + "', cartype='" + cartype + "' ,car_package='" +car_package+"' WHERE book_id= '" + book_id + "'";
		
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<BookingBean> getAllBooking() {
	    List<BookingBean> bookings = new ArrayList<BookingBean>();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	stmt = currentCon.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from booking where cust_id=?");
	        
	        while (rs.next()) {
	            BookingBean booking = new BookingBean();
	            booking.setBook_id(rs.getInt("book_id"));
	            booking.setBook_date(rs.getString("book_date"));
	            booking.setBook_time(rs.getString("book_time"));
	            booking.setCar_plateno(rs.getString("car_plateno"));
	            booking.setCar_name(rs.getString("car_name"));
	            booking.setCartype(rs.getString("cartype"));
	            booking.setCar_package(rs.getString("car_package"));
	            booking.setCust_id(rs.getInt("cust_id"));
	            bookings.add(booking);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return bookings;
	}
	
	public BookingBean getBookingById(int book_id) {
		BookingBean booking = new BookingBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from booking where book_id=?");
	        
	        ps.setInt(1, book_id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
	        	 booking.setBook_id(rs.getInt("book_id"));
		            booking.setBook_date(rs.getString("book_date"));
		            booking.setBook_time(rs.getString("book_time"));
		            booking.setCar_plateno(rs.getString("car_plateno"));
		            booking.setCar_name(rs.getString("car_name"));
		            booking.setCartype(rs.getString("cartype"));
		            booking.setCar_package(rs.getString("car_package"));
	          
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return booking;
	}
}
