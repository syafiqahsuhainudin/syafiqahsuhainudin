package carwash.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import pizza.dao.OrderDAO;
import carwash.dao.UserDAO;
import carwash.model.UserBean;


	@WebServlet("/logincontroller")

	public class logincontroller extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    private UserDAO dao;
	    HttpServletRequest request;
	    HttpServletResponse response;
	    String forward="";
	    String action="";
	    
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public logincontroller() {
	        super();
	        dao = new UserDAO();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			action = request.getParameter("action");
	        
			
	        	try {
	    			
	    			UserBean user = new UserBean();
	    			user.setCust_email(request.getParameter("cust_email"));
	    			user.setCust_password(request.getParameter("cust_password"));
	    	
	    			user = UserDAO.login(user);

	    			if(user.isValid())
	    			{
	    				HttpSession session = request.getSession(true);
	    				session.setAttribute("currentSessionUser", user.getCust_email());
	    				session.setAttribute("currentSessionUsers",user.getCust_name());
	    				session.setAttribute("currentSessionUserrr",user.getCust_phone());
	    				Integer cust_id = (Integer) session.getAttribute("is_new");
	    				session.setAttribute("is_new",user.getCust_id());
	    				
	    				response.sendRedirect("index.jsp"); // logged-in page
	    			}
	    			else
	    			{
	    				response.sendRedirect("invalidlogin.jsp");
	    			}
	    			
	    		}

	    		catch (Throwable ex) {
	    			System.out.println(ex);
	    		}
	 
		}

	}
