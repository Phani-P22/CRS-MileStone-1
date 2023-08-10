package com.digit.javaTraining.CRS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/manageStudentSignUpReq")
public class AdminManageStudentSignUpRequestController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Student> allRequests = (ArrayList<Student>) session.getAttribute("allRequests");
		int curIndex = (int) session.getAttribute("curIndex");

		Student curStudent = allRequests.get(curIndex - 1);

		String operation = req.getParameter("operation");
		if (operation.equalsIgnoreCase("Approve")) {

			Student.deleteStudentFromStudentRequestsTable(curStudent);
			Student.addStudentToStudentTable(curStudent);

		} else if (operation.equalsIgnoreCase("Reject")) {

			Student.deleteStudentFromStudentRequestsTable(curStudent);

		}
		resp.sendRedirect("/CRS/AdminViewStudentEnrollmentRequests.jsp");
	}
}
