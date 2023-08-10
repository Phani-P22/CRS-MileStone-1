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
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		String reEnteredNewPassword = req.getParameter("reEnterNewPassword");
		
		if (!newPassword.equals(reEnteredNewPassword)) {
			// return
			return;
		}
		
		HttpSession curSession = req.getSession();
		Student curStudent = (Student) curSession.getAttribute("curStudent");
		
		if (!curStudent.getPassword().equals(oldPassword)) {
			// return;
		}
		
		Student.changeStudentPassword(curStudent, newPassword);
		HttpSession session = req.getSession();
		session.setAttribute("title", "Change Password");
		session.setAttribute("message", "Password Updated Successfully!");
		session.setAttribute("redirectLink", "StudentHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
