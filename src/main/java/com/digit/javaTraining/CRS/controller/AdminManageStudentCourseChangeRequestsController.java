package com.digit.javaTraining.CRS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.CourseChangeResponse;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/manageStudentCourseChangeReq")
public class AdminManageStudentCourseChangeRequestsController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<CourseChangeResponse> allRequests = (ArrayList<CourseChangeResponse>) session
				.getAttribute("allSCCRequests");
		int curIndex = (int) session.getAttribute("curIndex");

		CourseChangeResponse curCourseChangeResponse = allRequests.get(curIndex - 1);
		Student curStudent = (Student) curCourseChangeResponse.getCurObject();
		int newCourseID = curCourseChangeResponse.getNewCourseID();

		String operation = req.getParameter("operation");
		if (operation.equalsIgnoreCase("Approve")) {

			Student.updateStudentCourseInTable(curStudent, newCourseID);
			Student.deleteStudentCourseChangeRequest(curStudent.getStudentID(), newCourseID);

		} else if (operation.equalsIgnoreCase("Reject")) {

			Student.deleteStudentCourseChangeRequest(curStudent.getStudentID(), newCourseID);

		}
		resp.sendRedirect("/CRS/AdminViewStudentCourseChangeRequests.jsp");
	}
}
