package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Student;

@WebServlet("/changeUserName")
public class StudentChangeUserNameController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldUserName = req.getParameter("oldUserName");
		String newUserName = req.getParameter("newUserName");
		String password = req.getParameter("password");
		
		if (oldUserName.equals(newUserName)) {
			// return
		}
		
		HttpSession curSession = req.getSession();
		Student curStudent = (Student) curSession.getAttribute("curStudent");
		
		if (!curStudent.getUserName().equals(oldUserName)) {
			// return
		}
		if (!curStudent.getPassword().equals(password)) {
			// return;
		}
		
		Student.changeStudentUserName(curStudent, newUserName, password);
		
		HttpSession session = req.getSession();
		session.setAttribute("title", "Change UserName");
		session.setAttribute("message", "UserName Updated Successfully!");
		session.setAttribute("redirectLink", "StudentHome.jsp");
		resp.sendRedirect("AppPrintMessage.jsp");
	}
}
