

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in second servlet");
		HttpSession session = request.getSession(false);
		String name=(String) session.getAttribute("name");
		PrintWriter writer=response.getWriter();
		writer.println("<h1>Response from Second Servlet</h1>" + "<h1>"+ name + "<h1/>");
		writer.close();
	}

}
