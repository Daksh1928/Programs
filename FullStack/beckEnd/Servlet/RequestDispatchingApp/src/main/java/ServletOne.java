

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control is in ServletOne");
		PrintWriter writer = response.getWriter();
       writer.println("<h1>Control is in ServletOne</h1>");
	RequestDispatcher reqdispatcher = request.getRequestDispatcher("/ServletSec");
	reqdispatcher.forward(request, response);

	writer.println("<h1>Control is in ServletOne</h1>");
	writer.close();
	}

}
