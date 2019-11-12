package com.training.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.dao.TravelDao;
import com.training.entity.Travel;

/**
 * Servlet implementation class TourServlet
 */
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	TravelDao dao;
    public TourServlet() {
        super();
        dao=new TravelDao();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String startPoint=request.getParameter("startPoint");
		String destination=request.getParameter("destination");
		Travel tour=null;
		try {
			 tour=dao.findById(startPoint, destination);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("viewTours.jsp");
		//System.out.println(tour);
		HttpSession tourSession=request.getSession(true);
		tourSession.setAttribute("tour", tour);
		Travel tour1=(Travel)tourSession.getAttribute("tour");
		//Travel tour1=(Travel) request.getSession(false).getAttribute("tourSession");
		//System.out.println(tour1);
        //request.setAttribute("tour",tour);
        
        dispatcher.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		String strCode=request.getParameter("code");
		long code=Long.parseLong(strCode);
		String startPoint=request.getParameter("startPoint");
		String destination=request.getParameter("destination");
		String strStartDate=request.getParameter("startDate");
		LocalDate startDate=LocalDate.parse(strStartDate);
		String strEndDate=request.getParameter("endDate");
		LocalDate endDate=LocalDate.parse(strEndDate);
		String strNoOfDays=request.getParameter("noOfDays");
		long noOfDays=Long.parseLong(strNoOfDays);
		String strNoOfNights=request.getParameter("noOfNights");
		long noOfNights=Long.parseLong(strNoOfNights);
		String place1=request.getParameter("place1");
		String place2=request.getParameter("place2");
		String place3=request.getParameter("place3");
		String strCost=request.getParameter("cost");
		long cost=Long.parseLong(strCost);
		
		Travel tour= new Travel(code, startPoint, destination, startDate, endDate, place1, place2, place3, noOfDays, noOfNights, cost);
		try {
			dao.add(tour);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("registerTours.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
