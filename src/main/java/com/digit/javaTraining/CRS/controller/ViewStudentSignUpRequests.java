package com.digit.javaTraining.CRS.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.javaTraining.CRS.model.Student;
import com.digit.javaTraining.CRSApp.Helper;

@WebServlet("/viewStudentSignUpRequests")
public class ViewStudentSignUpRequests extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Student> allStudentSignUpRequestsList = Student.getAllStudentSignUpRequestsList();
		
	}
}
