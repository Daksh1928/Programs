
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class ServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		String ucity = request.getParameter("ucity");

		if(uname.equals("Devanshu Rana") && ucity.equals("Bangalore")) {
			response.getWriter().append("Welcome to servlet life cycle");
		}
		else {
			response.getWriter().append("Another user");
		}
	}

}
