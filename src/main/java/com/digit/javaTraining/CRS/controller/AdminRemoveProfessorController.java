package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.CRS.model.Course;
import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRSApp.Helper;

@WebServlet("/removeProfessor")
public class AdminRemoveProfessorController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int curProfessorID = Integer.parseInt(req.getParameter("professorID"));

		boolean isValidProfessor = Professor.isValidProfessorID(curProfessorID);
		if (!isValidProfessor) {
			// return error
		}
		

		Professor.deleteProfessorFromProfessorTableUsingID(curProfessorID);
		resp.sendRedirect("/CRS/StudentRemoveSuccess.html");
	}
}
