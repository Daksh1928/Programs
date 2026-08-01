package com.Student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.model.Student;
import com.Student.service.StudentService;

@WebServlet("/list")
public class StudentListServlet extends HttpServlet {
    private final StudentService service = new StudentService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String grade = request.getParameter("grade");
        List<Student> students = (grade == null || grade.isBlank())
                ? service.findAll()
                : service.findByGrade(grade);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (students.isEmpty()) {
            out.println("<tr><td colspan='6'>No students found.</td></tr>");
            return;
        }
        for (Student student : students) {
            out.println("<tr>");
            out.println("<td>" + student.getId() + "</td>");
            out.println("<td>" + student.getName() + "</td>");
            out.println("<td>" + student.getCity() + "</td>");
            out.println("<td>" + student.getMarks() + "</td>");
            out.println("<td>" + student.getGrade() + "</td>");
            out.println(
                    "<td class='row-actions'><button class='secondary' onclick=\"if(confirm('Delete this student?')) window.location='/StudentInfoManager/delete?id="
                            + student.getId() + "'\">Delete</button></td>");
            out.println("</tr>");
        }
    }
}
