

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet 
{
	

	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       System.out.println("Control in first Servlet");
	       String name=request.getParameter("uname");
	       String city=request.getParameter("ucity");
	      RequestDispatcher reqDispatch = request.getRequestDispatcher("/SecondServlet");
	      
	     HttpSession session = request.getSession();
	     session.setAttribute("name", name);
	      
	      reqDispatch.forward(request, response);
	      //reqDispatch.include(request, response);
	      
	      PrintWriter writer = response.getWriter();
	      writer.println("<h1>Response from Servlet One </h1>");
	      writer.close();
	      //System.out.println("Control again in first servlet");
	}

}
