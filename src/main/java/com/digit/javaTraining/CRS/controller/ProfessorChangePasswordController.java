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

@WebServlet("/changePasswordProfessor")
public class ProfessorChangePasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String oldPassword, newPassword, reEnteredNewPassword;

		try {
			oldPassword = req.getParameter("oldPassword");
			newPassword = req.getParameter("newPassword");
			reEnteredNewPassword = req.getParameter("reEnterNewPassword");
		} catch (Exception e) {
			session.setAttribute("title", "Change Password Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "ProfessorHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		Professor curProfessor = (Professor) session.getAttribute("curProfessor");
		if (curProfessor == null) {
			session.setAttribute("title", "Change Password Failure!");
			session.setAttribute("message", "Invalid Session! Login Again");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		if ((!newPassword.equals(reEnteredNewPassword)) || !curProfessor.getPassword().equals(oldPassword)) {
			session.setAttribute("title", "Change Password Failure!");
			session.setAttribute("message", "Invalid Credentials");
			session.setAttribute("redirectLink", "ProfessorHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}

		Professor.changeProfessorPassword(curProfessor, newPassword);
		curProfessor.setPassword(newPassword);
		session.setAttribute("curProfessor", curProfessor);

		session.setAttribute("title", "Password Change");
		session.setAttribute("message", "Password Changed Successfully!");
		session.setAttribute("redirectLink", "ProfessorHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
