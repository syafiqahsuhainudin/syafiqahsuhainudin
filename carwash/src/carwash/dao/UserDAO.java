package carwash.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.carwash.ConnectionManager;

import carwash.model.UserBean;
import carwash.model.BookingBean;

public class UserDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;

	static String cust_name,cust_phone,cust_email,cust_password;
	static int cust_id;
	
  //add new user (register)
    public void add(UserBean bean) throws NoSuchAlgorithmException{
    	
      
       cust_name = bean.getCust_name();
       cust_phone = bean.getCust_phone();
       cust_email = bean.getCust_email();
       cust_password = bean.getCust_password();
       
    	try {
    		currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("insert into customer (cust_name,cust_phone,cust_email,cust_password)values(?,?,?,?)");
    	
    		ps.setString(1,cust_name);
    		ps.setString(2,cust_phone);
    		ps.setString(3,cust_email);
    		ps.setString(4,cust_password);
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
    
    
public static UserBean getUser(UserBean bean)  {
    	
        cust_email = bean.getCust_email();
        cust_password = bean.getCust_password();
        cust_name = bean.getCust_name();
        cust_phone = bean.getCust_phone();
        cust_id = bean.getCust_id();
      
        
        String searchQuery = "select * from customer where cust_email='" + cust_email + "'";

        try {
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	String cust_email = rs.getString("cust_email");
            	String cust_name = rs.getString("cust_name");
            	String cust_phone = rs.getString("cust_phone");
            	int cust_id = rs.getInt("cust_id");
            	
            	
                bean.setCust_email(cust_email);
                bean.setCust_name(cust_name);
                bean.setCust_phone(cust_phone);
              
                bean.setCust_id(cust_id);
              
                bean.setValid(true);
               
              
                bean.setValid(true);
           	}
           
            else if (!more) {
            	System.out.println("Sorry");
            	
            	bean.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return bean;
}

//login
public static UserBean login(UserBean bean) throws NoSuchAlgorithmException {
	
  cust_email = bean.getCust_email();
  cust_password = bean.getCust_password();
  cust_name = bean.getCust_name();
  cust_phone = bean.getCust_phone();
  cust_id = bean.getCust_id();


	
  String searchQuery = "select * from customer where cust_email='" + cust_email + "' AND cust_password='" + cust_password + "'"; 

  System.out.println("Your email is " + cust_email);
  System.out.println("Your password is " + cust_password);

  System.out.println("Query: " + searchQuery);

  try {
      currentCon = ConnectionManager.getConnection();
      stmt = currentCon.createStatement();
      rs = stmt.executeQuery(searchQuery);
      boolean more = rs.next();

      // if user exists set the isValid variable to true
      if (more) {
      	String cust_email = rs.getString("cust_email");
    	String cust_name = rs.getString("cust_name");
    	String cust_phone = rs.getString("cust_phone");
    	int cust_id = rs.getInt("cust_id");
    
     		System.out.println("Welcome " + cust_email);
     		System.out.println("Welcome " + cust_name);
     		
     		 bean.setCust_id(cust_id);
          bean.setCust_email(cust_email);
          bean.setCust_name(cust_name);
          bean.setCust_phone(cust_phone);
         
          bean.setValid(true);
     	}
     
      // if user does not exist set the isValid variable to false
      else if (!more) {
      	System.out.println("Sorry, you are not a registered user! Please sign up first");
      	bean.setValid(false);
      }
     
  }

  catch (Exception ex) {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
  }

  finally {
      if (rs != null) {
          try {
              rs.close();
          } catch (Exception e) {
          }
          rs = null;
      }

      if (stmt != null) {
          try {
              stmt.close();
          } catch (Exception e) {
          }
          stmt = null;
      }

      if (currentCon != null) {
          try {
              currentCon.close();
          } catch (Exception e) {
          }

          currentCon = null;
      }
  }

  return bean;
}

}

