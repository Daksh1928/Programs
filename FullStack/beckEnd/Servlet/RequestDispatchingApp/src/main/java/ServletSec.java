
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletSec")
public class ServletSec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				System.out.println("Control is in ServletSec");
				HttpSession session = request.getSession(false);
				String username = (String) session.getAttribute("username");
				String city = (String) session.getAttribute("city");
				String password = (String) session.getAttribute("password");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Control is in ServletSec</h1>");
		writer.println("<p>Username: " + username + "</p>");
		writer.println("<p>City: " + city + "</p>");
		writer.println("<p>Password: " + password + "</p>");
		writer.close();
	}

}
