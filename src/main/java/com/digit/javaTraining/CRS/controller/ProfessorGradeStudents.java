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

@SuppressWarnings("serial")
@WebServlet("/gradeStudents")
public class ProfessorGradeStudents extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int allotedMarks = Integer.parseInt(req.getParameter("marksGiven"));

		HttpSession session = req.getSession();
		Professor curProfessor = (Professor) session.getAttribute("curProfessor");

		ArrayList<Student> allStudentsUnderProfessor = (ArrayList<Student>) session
				.getAttribute("allStudentsUnderProfessor");

		Student curStudent = allStudentsUnderProfessor.get((int) session.getAttribute("curIndex") - 1);

		Professor.updateStudentMarksOfStudent(curStudent, allotedMarks);

		resp.sendRedirect("/CRS/ProfessorGradeStudents.jsp");
	}
}
