
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Register")
public class Register extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Model model = new Model();
        model.setUsername(username);
        model.setEmail(email);
        model.setPassword(password);
        model.setPhone(phone);

        int row = model.register();
    	HttpSession session = request.getSession();

		session.setAttribute("name",username);

        if (row == 0) {
            response.sendRedirect("/RegistrationAppMVC/faliure.jsp");
        } else {
            response.sendRedirect("/RegistrationAppMVC/success.jsp");
        }

    }

}
