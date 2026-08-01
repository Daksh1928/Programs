package com.Student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.model.Student;
import com.Student.service.StudentService;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    private final StudentService service = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("id")));
            student.setName(request.getParameter("name"));
            student.setCity(request.getParameter("city"));
            student.setMarks(Integer.parseInt(request.getParameter("marks")));

            service.save(student);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Student added successfully.");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Failed to save student: " + e.getMessage());
        }
    }
}
