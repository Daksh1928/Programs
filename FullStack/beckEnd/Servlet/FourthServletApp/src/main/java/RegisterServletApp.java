
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServletApp() {
		super();
		System.out.println("RegisterServletApp constructor called");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("upassword");
		String city = request.getParameter("ucity");
		PrintWriter out = response.getWriter();

		response.sendRedirect("/FourthServletApp/suscess.jsp");
		// out.println("Username: " + username);
		// out.println("Password: " + password);
		// out.println("City: " + city);
		// out.println("<html><head><title>First Servlet</title></head>");
		// out.println("<style>body{background-color:lightblue;}");
		// out.println("h1{color:blue; text-align:center; font-family:verdana;}");
		// out.println("h1{color:blue; text-align:center; font-family:verdana;}</style>");
		// out.println("<style>h1{color:blue; text-align:center; font-family:verdana;}</style>");
		// out.println("</style><body>");

		// out.println("<h1>Welcome to First Servlet</h1>");
		// out.println("<h1>Username: " + username + "</h1>");
		// out.println("<h1>Password: " + password + "</h1>");
		// out.println("<h1>City: " + city + "</h1>");
		// out.println("</body></html>");
		out.close();
	}

}
