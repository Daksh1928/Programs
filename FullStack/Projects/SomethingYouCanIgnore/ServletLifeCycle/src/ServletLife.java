

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletLife")
public class ServletLife extends HttpServlet 
{
	static
	{
		System.out.println("Servlet is loaded....");
	}
	
	public ServletLife()
	{
		System.out.println("Servlet object is created");
	}
	

	
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("Servlet initialized!");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Service method to handle http request and to response back");
	}
	
	public void destroy() 
	{
		
	}

}
