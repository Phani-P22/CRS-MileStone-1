package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Course;
import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRSApp.Helper;

@WebServlet("/removeProfessor")
public class AdminRemoveProfessorController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		int curProfessorID;
		try {
			curProfessorID = Integer.parseInt(req.getParameter("professorID"));
		} catch (Exception e) {
			session.setAttribute("title", "Remove Professor Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		boolean isValidProfessor = Professor.isValidProfessorID(curProfessorID);
		if (!isValidProfessor) {
			session.setAttribute("title", "Remove Professor Failure!");
			session.setAttribute("message", "Invalid ProfessorID");
			session.setAttribute("redirectLink", "AdminHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor.deleteProfessorFromProfessorTableUsingID(curProfessorID);
		resp.sendRedirect("/CRS/StudentRemoveSuccess.html");
	}
}
