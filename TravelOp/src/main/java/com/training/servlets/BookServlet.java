package com.training.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.entity.Travel;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Travel> bookingList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        bookingList=new ArrayList<>();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Travel tour=(Travel)request.getAttribute("tour");
		Travel tour=(Travel) request.getSession(false).getAttribute("tour");
		//Travel tour1=(Travel)tourSession.getAttribute("tour");
		//System.out.println(tour);
		
		bookingList.add(tour);
		HttpSession bookingListSession=request.getSession(true);
		bookingListSession.setAttribute("bookingList", bookingList);
		List<Travel> bookingList1=(List<Travel>)bookingListSession.getAttribute("bookingList");
		System.out.println(bookingList1);
       // request.setAttribute("bookingList",bookingList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("viewTours.jsp");
        
        dispatcher.forward(request, response);
		
	
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doGet(request, response);
	}

}
