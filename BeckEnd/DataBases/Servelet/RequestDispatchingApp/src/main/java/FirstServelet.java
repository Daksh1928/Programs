

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServelet
 */
@WebServlet("/FirstServelet")
public class FirstServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in first Servlet");
		
		RequestDispatcher reqDispatcher =   request.getRequestDispatcher("/SecondServele");
//		reqDispatcher.forward(request, response);
		reqDispatcher.include(request, response);
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from Servlet One</h1>");
		writer.close();
	}

}
