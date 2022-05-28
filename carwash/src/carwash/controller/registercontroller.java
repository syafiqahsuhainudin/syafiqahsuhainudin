package carwash.controller;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import carwash.dao.UserDAO;
import carwash.model.UserBean;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;


@WebServlet("/registercontroller")
public class registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO dao;   
    JFrame frame;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registercontroller() {
        super();
        dao=new UserDAO();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String cust_name=request.getParameter("cust_name");
		String cust_phone=request.getParameter("cust_phone");
		String cust_email=request.getParameter("cust_email");
		String cust_password=request.getParameter("cust_password");
	
		
		UserBean user = new UserBean();
	
		user.setCust_name(cust_name);
		user.setCust_phone(cust_phone);
		user.setCust_email(cust_email);
		user.setCust_password(cust_password);
		
		
		user=UserDAO.getUser(user);
		
		if(!user.isValid()) {
			try {
				dao.add(user);
			} catch (NoSuchAlgorithmException e) {
				
				e.printStackTrace();
			}
			response.sendRedirect("login.jsp");
		}
		
		else
		{
	
			
			JOptionPane.showMessageDialog(null,"Email already exist." );
			response.sendRedirect("register.jsp");
			

		}
		
		
	}

}
