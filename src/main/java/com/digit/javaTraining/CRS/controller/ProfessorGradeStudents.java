package com.digit.javaTraining.CRS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/gradeStudents")
public class ProfessorGradeStudents extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		int allotedMarks;

		try {
			allotedMarks = Integer.parseInt(req.getParameter("marksGiven"));
		} catch (Exception e) {
			session.setAttribute("title", "Add Course Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor curProfessor = (Professor) session.getAttribute("curProfessor");
		if (curProfessor == null) {
			session.removeAttribute("curIndex");
			session.removeAttribute("allStudentsUnderProfessor");
			session.setAttribute("title", "Grade Students Failure!");
			session.setAttribute("message", "Invalid Session! Login Again");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		@SuppressWarnings("unchecked")
		ArrayList<Student> allStudentsUnderProfessor = (ArrayList<Student>) session
				.getAttribute("allStudentsUnderProfessor");

		Student curStudent = allStudentsUnderProfessor.get((int) session.getAttribute("curIndex") - 1);

		Professor.updateStudentMarksOfStudent(curStudent, allotedMarks);

		resp.sendRedirect("/CRS/ProfessorGradeStudents.jsp");
	}
}
