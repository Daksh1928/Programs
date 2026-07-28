

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in Servlet");
		
		String uname=request.getParameter("uname");
		String emailId=request.getParameter("email");
		String upassword=request.getParameter("password");
		String ucity=request.getParameter("ucity");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/telusko_db";
			String user="root";
			String password="root123";
			Connection connect=DriverManager.getConnection(url, user, password);
			
			PreparedStatement pstmnt = connect.prepareStatement("INSERT INTO personalinfo (uname, email, upassword, ucity) "
					+ "VALUES(?,?,?,?)");
			
			pstmnt.setString(1, uname);
			pstmnt.setString(2, emailId);
			pstmnt.setString(3, upassword);
			pstmnt.setString(4, ucity);
			
			int rowAffected=pstmnt.executeUpdate();
			
			PrintWriter writer=response.getWriter();
			
			if(rowAffected!=0)
			{
				writer.println("<h1>Registration Success!</h1>");
			}
			else
			{
				writer.println("<h1>Registration fail!</h1>");
			}
			pstmnt.close();
			connect.close();
			
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
	
		
	}

}
