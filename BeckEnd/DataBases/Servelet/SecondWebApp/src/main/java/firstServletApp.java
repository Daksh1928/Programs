
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstServlet")
public class firstServletApp extends HttpServlet {
public firstServletApp() {
		System.out.println("FirstServletApp constructor called");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String ucity = request.getParameter("ucity");
		PrintWriter writer = response.getWriter();
		writer.println("Hello " + uname);
		writer.println("I know you are form " + ucity);
		writer.close();
	}

}
