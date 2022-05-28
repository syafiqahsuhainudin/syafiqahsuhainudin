package carwash.dao;


import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import carwash.model.BookingBean;
import com.carwash.ConnectionManager;
public class BookDAO {  
  
	static Connection currentCon = null;	
public static int save(BookingBean u){  
    int status=0; 
    
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement(  
        		"insert into booking(book_date,book_time,car_plateno,car_name,cartype,car_package)values(?,?,?,?,?,?)");  
        ps.setString(1,u.getBook_date());  
        ps.setString(2,u.getBook_time());  
        ps.setString(3,u.getCar_plateno());  
        ps.setString(4,u.getCar_name());  
        ps.setString(5,u.getCartype());  
        ps.setString(5,u.getCar_package()); 
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(BookingBean u){  
    int status=0;  
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement(  
 
        "update booking set book_date = ?, book_time=?, car_plateno=?, car_name=?, cartype=? ,car_package=? where book_id= ?");
        ps.setString(1,u.getBook_date());  
        ps.setString(2,u.getBook_time());  
        ps.setString(3,u.getCar_plateno());  
        ps.setString(4,u.getCar_name());  
        ps.setString(5,u.getCartype());  
        ps.setString(5,u.getCar_package()); 
        ps.setInt(6,u.getBook_id());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int delete(BookingBean u){  
    int status=0;  
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement("delete from booking where book_id=?");  
        ps.setInt(1,u.getBook_id());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<BookingBean> getAllRecords(){  
    List<BookingBean> list=new ArrayList<BookingBean>();  
      
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement("select * from booking");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	BookingBean u=new BookingBean();  
            u.setBook_id(rs.getInt("book_id"));  
            u.setBook_date(rs.getString("book_date"));  
            u.setBook_time(rs.getString("book_time"));  
            u.setCar_plateno(rs.getString("car_plateno"));  
            u.setCar_name(rs.getString("car_name"));  
            u.setCartype(rs.getString("cartype"));
            u.setCar_package(rs.getString("car_package")); 
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static BookingBean getRecordById(int book_id){  
	BookingBean u=null;  
    try{  
    	currentCon = ConnectionManager.getConnection();   
        PreparedStatement ps=currentCon .prepareStatement("select * from booking where book_id=?");  
        ps.setInt(1,book_id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new BookingBean();  
            u.setBook_id(rs.getInt("book_id"));  
            u.setBook_date(rs.getString("book_date"));  
            u.setBook_time(rs.getString("book_time"));  
            u.setCar_plateno(rs.getString("car_plateno"));  
            u.setCar_name(rs.getString("car_name"));  
            u.setCartype(rs.getString("cartype"));
            u.setCar_package(rs.getString("car_package")); 
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}