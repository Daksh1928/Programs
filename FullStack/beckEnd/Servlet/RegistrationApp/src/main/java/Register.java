import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
		System.out.println("Register Servlet Constructor Called");
	}

	public void dopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register Servlet Called");
		String username = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String phone = request.getParameter("uphone");
		String uspassword = request.getParameter("upassword");
		String confirmPassword = request.getParameter("uconfirmPassword");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/registration";
			String Dname = "root";
			String password = "dev@123";
			Connection Conn = DriverManager.getConnection(url, Dname, password);

			PreparedStatement pstmnt = Conn
					.prepareStatement("INSERT INTO users (username, email, phone, password) VALUES (?, ?, ?, ?)");
			pstmnt.setString(1, username);
			pstmnt.setString(2, email);
			pstmnt.setString(3, phone);
			pstmnt.setString(4, uspassword);

			int rowsAffected = pstmnt.executeUpdate();
			if (rowsAffected != 0) {
				System.out.println("<h1>User registered successfully!</h1>");
			} else {
				System.out.println("<h1>User registration failed.</h1>");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}