package com.digit.javaTraining.CRS.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.javaTraining.CRS.model.Professor;

@WebServlet("/changePasswordProfessor")
public class ProfessorChangePasswordController extends HttpServlet {
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
		Professor curProfessor = (Professor) curSession.getAttribute("curProfessor");

		if (!curProfessor.getPassword().equals(oldPassword)) {
			// return;
		}

		Professor.changeProfessorPassword(curProfessor, newPassword);
	}
}
