package com.devanshu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletLife")
public class ServletLife extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static 
      {
    	  System.out.println("Servlet is  loaded....");
      }
       public ServletLife() {
    	   System.out.print("Servlet  object is created ");
    	   
       }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet is initialized....");
	}

	
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet is servicing....");	
	}
	public void destroy() {
		System.out.println("Servlet is destroyed....");
	}

}
