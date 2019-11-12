package com.training.demo.TravelOp;

import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.training.dao.RegisterDao;
import com.training.entity.Register;
import com.training.util.DbConnection;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {
	
	private RegisterDao dao;
	 public MyResource() {
			super();
			
			 this.dao=new RegisterDao();
		}
	  
	
	@Path("/frm")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	
	
			public Response addRegistration(@FormParam("firstName") String firstName,
			 @FormParam("lastName") String lastName,
			 @FormParam("typeOfUser") String typeOfUser,
			 @FormParam("userName") String userName,
			 @FormParam("passWord") String passWord,
			 @FormParam("phoneNumber") Long phoneNumber) {
		
		Register reg = new Register(firstName,lastName,typeOfUser,userName,passWord,phoneNumber);
		
		     try {
				int rowAdded = dao.add(reg);
				if(rowAdded!=1) {
					reg =null;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		     
		return Response.status(201).entity(reg).build();
	}
	
	
	
	@Path("/validate")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String validateLogin(@FormParam("userName") String userName,@FormParam("passWord") String passWord,@FormParam("typeOfUser") String typeOfUser) {
		Register registration=null;
		try {
		registration=dao.findById(userName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(registration!=null&&registration.getPassWord().equals(passWord)&&registration.getTypeOfUser().equalsIgnoreCase(typeOfUser)) {
			
			return "Successfully Logged in";
			
		}
		

		
		return "UserName/Password Incorrect. Please Try again";
		
		
		
	}
	

}
