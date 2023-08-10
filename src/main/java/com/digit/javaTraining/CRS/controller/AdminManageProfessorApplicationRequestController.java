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

@WebServlet("/manageProfessorApplicationReq")
public class AdminManageProfessorApplicationRequestController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ArrayList<Professor> allRequests = (ArrayList<Professor>) session.getAttribute("allPARRequests");
		int curIndex = (int) session.getAttribute("curIndex");

		Professor curProfessor = allRequests.get(curIndex - 1);

		String operation = req.getParameter("operation");
		if (operation.equalsIgnoreCase("Approve")) {

			Professor.deleteProfessorFromProfessorApplicationsTable(curProfessor);
			Professor.addProfessorToProfessorTable(curProfessor);

		} else if (operation.equalsIgnoreCase("Reject")) {

			Professor.deleteProfessorFromProfessorApplicationsTable(curProfessor);

		}
		resp.sendRedirect("/CRS/AdminViewProfessorApplicationRequests.jsp");
	}
}
