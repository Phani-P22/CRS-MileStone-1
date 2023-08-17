package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;
import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/changeUserNameProfessor")
public class ProfessorChangeUserNameController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String oldUserName, newUserName, password;

		try {
			oldUserName = req.getParameter("oldUserName");
			newUserName = req.getParameter("newUserName");
			password = req.getParameter("password");
		} catch (Exception e) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "ProfessorHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		Professor curProfessor = (Professor) session.getAttribute("curProfessor");
		if (curProfessor == null) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Invalid Session! Login Again");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		if (oldUserName.equals(newUserName) || curProfessor.getUserName().equals(newUserName)) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Old and New UserName is Same");
			session.setAttribute("redirectLink", "ProfessorHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		if (!curProfessor.getPassword().equals(password)) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Invalid Credentials");
			session.setAttribute("redirectLink", "ProfesssorHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor.changeProfessorUserName(curProfessor, newUserName, password);
		curProfessor.setUserName(newUserName);
		session.setAttribute("curProfessor", curProfessor);
		session.setAttribute("title", "Change UserName");
		session.setAttribute("message", "UserName Updated Successfully!");
		session.setAttribute("redirectLink", "ProfessorHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
