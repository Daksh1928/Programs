package com.Student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.service.StudentService;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
    private final StudentService service = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            boolean deleted = service.deleteById(id);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write(deleted ? "Student deleted successfully." : "Student not found.");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Failed to delete student: " + e.getMessage());
        }
    }
}
