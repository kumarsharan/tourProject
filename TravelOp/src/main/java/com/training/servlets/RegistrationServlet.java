package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.dao.RegisterDao;
import com.training.entity.Register;

/**
 * Servlet implementation class RegistrationServelet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	RegisterDao dao;
    public RegistrationServlet() {
        super();
        this.dao=new RegisterDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Register user=null;
		List<Register> registrationList = null;
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String typeOfUser=request.getParameter("typeOfUser");
		
		boolean status=false;
		
		try {
		user=dao.findById(userName);
		 registrationList=dao.findAll();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user!=null&&user.getPassWord().equals(passWord)&&user.getTypeOfUser().equalsIgnoreCase(typeOfUser)) {
			
			status=true;
			
		}
		
		
		request.setAttribute("registrationList", registrationList);
		if(status) {
			
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("registerTours.jsp");
            HttpSession session=request.getSession(true);
            session.setAttribute("user",user);
            dispatcher.forward(request, response);

		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("loginStatus.jsp");
            request.setAttribute("err", "Invalid user id and password");
            dispatcher.forward(request, response);

		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String typeOfUser=request.getParameter("typeOfUser");
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		String strphoneNumber=request.getParameter("phoneNumber");
		long phoneNumber=Long.parseLong(strphoneNumber);
		
		Register reg = new Register(firstName,lastName,typeOfUser,userName,passWord,phoneNumber);
		
	     try {
			int rowAdded = dao.add(reg);
			if(rowAdded!=1) {
				reg =null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	     	
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
			doGet(request, response);
	}

}
