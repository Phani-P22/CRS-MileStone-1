package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/changePassword")
public class StudentChangePasswordController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String oldPassword, newPassword, reEnteredNewPassword;
		
		try {
			oldPassword = req.getParameter("oldPassword");
			newPassword = req.getParameter("newPassword");
			reEnteredNewPassword = req.getParameter("reEnterNewPassword");
		} catch (Exception e) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Invalid Parameters");
			session.setAttribute("redirectLink", "StudentHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		
		Student curStudent = (Student) session.getAttribute("curStudent");
		if (curStudent == null) {
			session.setAttribute("title", "Change UserName Failure!");
			session.setAttribute("message", "Invalid Session! Login Again");
			session.setAttribute("redirectLink", "index.html");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		if ((!newPassword.equals(reEnteredNewPassword)) || !curStudent.getPassword().equals(oldPassword)) {
			session.setAttribute("title", "Change Password Failure!");
			session.setAttribute("message", "Invalid Credentials");
			session.setAttribute("redirectLink", "StudentHome.jsp");
			resp.sendRedirect("Failure.jsp");
			return;
		}
		
		Student.changeStudentPassword(curStudent, newPassword);
		curStudent.setPassword(newPassword);
		session.setAttribute("curStudent", curStudent);

		session.setAttribute("title", "Change Password");
		session.setAttribute("message", "Password Updated Successfully!");
		session.setAttribute("redirectLink", "StudentHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
