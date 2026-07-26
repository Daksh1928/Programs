
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletOne")
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String city = request.getParameter("city");
		String password = request.getParameter("password");
		PrintWriter writer = response.getWriter();
		RequestDispatcher reqdispatcher = request.getRequestDispatcher("/ServletSec");

		HttpSession session = request.getSession();
		session.setAttribute("username", request.getParameter("uname"));
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("password", request.getParameter("password"));

		reqdispatcher.forward(request, response);

		writer.println("<h1>Control is in ServletOne</h1>");
		writer.close();
	}

}
