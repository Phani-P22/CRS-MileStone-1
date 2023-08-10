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
import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/manageProfessorCourseChangeReq")
public class AdminManageProfessorCourseChangeRequestsController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		System.out.println("Req Came");
		
		@SuppressWarnings("unchecked")
		ArrayList<CourseChangeResponse> allRequests = (ArrayList<CourseChangeResponse>) session
				.getAttribute("allPCCRequests");
		int curIndex = (int) session.getAttribute("curIndex");

		CourseChangeResponse curCourseChangeResponse = allRequests.get(curIndex - 1);
		Professor curProfessor = (Professor) curCourseChangeResponse.getCurObject();
		int newCourseID = curCourseChangeResponse.getNewCourseID();

		String operation = req.getParameter("operation");
		if (operation.equalsIgnoreCase("Approve")) {

			Professor.updateProfessorCourseInTable(curProfessor, newCourseID);
			Professor.deleteProfessorCourseChangeRequest(curProfessor.getProfessorID(), newCourseID);

		} else if (operation.equalsIgnoreCase("Reject")) {

			Professor.deleteProfessorCourseChangeRequest(curProfessor.getProfessorID(), newCourseID);

		}
		resp.sendRedirect("/CRS/AdminViewProfessorCourseChangeRequests.jsp");
	}
}
