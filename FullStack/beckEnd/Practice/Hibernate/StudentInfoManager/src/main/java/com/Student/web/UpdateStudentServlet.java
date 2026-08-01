package com.Student.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.model.Student;
import com.Student.service.StudentService;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
    private final StudentService service = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Student student = service.findById(id).orElse(null);
            if (student == null) {
                response.setContentType("text/plain;charset=UTF-8");
                response.getWriter().write("Student not found.");
                return;
            }

            String name = request.getParameter("name");
            String city = request.getParameter("city");
            String marksParam = request.getParameter("marks");

            if (name != null && !name.isBlank())
                student.setName(name);
            if (city != null && !city.isBlank())
                student.setCity(city);
            if (marksParam != null && !marksParam.isBlank())
                student.setMarks(Integer.parseInt(marksParam));

            service.update(student);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Student updated successfully.");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("Failed to update student: " + e.getMessage());
        }
    }
}
