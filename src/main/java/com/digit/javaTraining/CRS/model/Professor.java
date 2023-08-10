package com.digit.javaTraining.CRS.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.digit.javaTraining.CRSApp.Helper;

public class Professor {

	private int professorID;
	private String professorName;
	private int age;
	private String city;
	private int yearsOfExpreience;
	private int courseID;
	private String emailID;
	private String phoneNumber;
	private String userName;
	private String password;

	public int getProfessorID() {
		return professorID;
	}

	public void setProfessorID(int professorID) {
		this.professorID = professorID;
	}

	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYearsOfExpreience() {
		return yearsOfExpreience;
	}

	public void setYearsOfExpreience(int yearsOfExpreience) {
		this.yearsOfExpreience = yearsOfExpreience;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Professor authenticateProfessor(String userName, String password) {
		Connection conn = Helper.getConnectionInstance();
		Professor curProfessor = null;

		String query = "SELECT * FROM Professor WHERE userName = ? AND password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curProfessor = new Professor();
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorName(rs.getString("professorName"));
				curProfessor.setAge(rs.getInt("age"));
				curProfessor.setCity(rs.getString("city"));
				curProfessor.setYearsOfExpreience(rs.getInt("yearsOfExperience"));
				curProfessor.setCourseID(rs.getInt("courseID"));
				curProfessor.setEmailID(rs.getString("emailID"));
				curProfessor.setPhoneNumber(rs.getString("phoneNumber"));
				curProfessor.setUserName(rs.getString("userName"));
				curProfessor.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return curProfessor;
	}

	public static Professor authenticateProfessorInRequestsTable(String userName, String password) {
		Connection conn = Helper.getConnectionInstance();
		Professor curProfessor = null;

		String query = "SELECT * FROM PROFESSOR_NEW_REQ WHERE userName = ? AND password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curProfessor = new Professor();
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorName(rs.getString("professorName"));
				curProfessor.setAge(rs.getInt("age"));
				curProfessor.setCity(rs.getString("city"));
				curProfessor.setYearsOfExpreience(rs.getInt("yearsOfExperience"));
				curProfessor.setCourseID(rs.getInt("courseID"));
				curProfessor.setEmailID(rs.getString("emailID"));
				curProfessor.setPhoneNumber(rs.getString("phoneNumber"));
				curProfessor.setUserName(rs.getString("userName"));
				curProfessor.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return curProfessor;
	}

	public static boolean professorSignUp(Professor curProfessor) {
		Connection conn = Helper.getConnectionInstance();

		String query = "INSERT INTO professor_new_req(professorName, age, city, yearsOfExperience, courseID, "
				+ "emailID, phoneNumber, userName, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curProfessor.getProfessorName());
			ps.setInt(2, curProfessor.getAge());
			ps.setString(3, curProfessor.getCity());
			ps.setInt(4, curProfessor.getYearsOfExpreience());
			ps.setInt(5, curProfessor.getCourseID());
			ps.setString(6, curProfessor.getEmailID());
			ps.setString(7, curProfessor.getPhoneNumber());
			ps.setString(8, curProfessor.getUserName());
			ps.setString(9, curProfessor.getPassword());

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isValidProfessorID(int professorID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "SELECT * FROM Professor WHERE professorID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, professorID);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void deleteProfessorFromProfessorTableUsingID(int professorID) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM Professor WHERE professorID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, professorID);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Professor> getAllProfessorsList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Professor> allProfessorsList = new ArrayList<Professor>();
		String query = "SELECT * FROM Professor";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Professor curProfessor = new Professor();
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorName(rs.getString("professorName"));
				curProfessor.setAge(rs.getInt("age"));
				curProfessor.setCity(rs.getString("city"));
				curProfessor.setYearsOfExpreience(rs.getInt("yearsOfExperience"));
				curProfessor.setCourseID(rs.getInt("courseID"));
				curProfessor.setEmailID(rs.getString("emailID"));
				curProfessor.setPhoneNumber(rs.getString("phoneNumber"));
				curProfessor.setUserName(rs.getString("userName"));
				curProfessor.setPassword(rs.getString("password"));

				allProfessorsList.add(curProfessor);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allProfessorsList;
	}

	public static ArrayList<CourseChangeResponse> getAllCourseChangeReqOfProfessors() {
		ArrayList<CourseChangeResponse> allRequests = new ArrayList<CourseChangeResponse>();

		Connection conn = Helper.getConnectionInstance();
		String query = "SELECT * FROM professor_course_change_request";

		int professorID, courseID;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				professorID = rs.getInt("professorID");
				courseID = rs.getInt("newCourseID");

				CourseChangeResponse pccr = new CourseChangeResponse();
				pccr.setNewCourseID(courseID);

				Professor curProfessor = Professor.getProfessorFromProfessorTableUsingID(professorID);
				pccr.setCurObject(curProfessor);

				allRequests.add(pccr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allRequests;
	}

	public static Professor getProfessorFromProfessorTableUsingID(int professorID) {
		Connection conn = Helper.getConnectionInstance();
		Professor curProfessor = null;

		String query = "SELECT * FROM Professor WHERE professorID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, professorID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curProfessor = new Professor();
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorName(rs.getString("professorName"));
				curProfessor.setAge(rs.getInt("age"));
				curProfessor.setCity(rs.getString("city"));
				curProfessor.setYearsOfExpreience(rs.getInt("yearsOfExperience"));
				curProfessor.setCourseID(rs.getInt("courseID"));
				curProfessor.setEmailID(rs.getString("emailID"));
				curProfessor.setPhoneNumber(rs.getString("phoneNumber"));
				curProfessor.setUserName(rs.getString("userName"));
				curProfessor.setPassword(rs.getString("password"));
				return curProfessor;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return curProfessor;
	}

	public static void updateProfessorCourseInTable(Professor curProfessor, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "UPDATE Professor SET courseID = ? WHERE professorID = ? AND userName = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, newCourseID);
			ps.setInt(2, curProfessor.getProfessorID());
			ps.setString(3, curProfessor.getUserName());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteProfessorCourseChangeRequest(int professorID, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "DELETE FROM professor_course_change_request WHERE professorID = ? AND newCourseID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, professorID);
			ps.setInt(2, newCourseID);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Professor> getAllProfessorApplicationsList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Professor> allProfessorApplicationsList = new ArrayList<Professor>();
		String query = "SELECT * FROM PROFESSOR_NEW_REQ";

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				Professor curProfessor = new Professor();
				curProfessor.setProfessorID(rs.getInt("professorID"));
				curProfessor.setProfessorName(rs.getString("professorName"));
				curProfessor.setAge(rs.getInt("age"));
				curProfessor.setCity(rs.getString("city"));
				curProfessor.setYearsOfExpreience(rs.getInt("yearsOfExperience"));
				curProfessor.setCourseID(rs.getInt("courseID"));
				curProfessor.setEmailID(rs.getString("emailID"));
				curProfessor.setPhoneNumber(rs.getString("phoneNumber"));
				curProfessor.setUserName(rs.getString("userName"));
				curProfessor.setPassword(rs.getString("password"));

				allProfessorApplicationsList.add(curProfessor);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return allProfessorApplicationsList;
	}

	public static void deleteProfessorFromProfessorApplicationsTable(Professor curProfessor) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM PROFESSOR_NEW_REQ WHERE userName = ? AND password = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curProfessor.getUserName());
			ps.setString(2, curProfessor.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addProfessorToProfessorTable(Professor curProfessor) {
		Connection conn = Helper.getConnectionInstance();

		String query = "INSERT INTO Professor(professorName, age, city, yearsOfExperience, courseID, "
				+ "emailID, phoneNumber, userName, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curProfessor.getProfessorName());
			ps.setInt(2, curProfessor.getAge());
			ps.setString(3, curProfessor.getCity());
			ps.setInt(4, curProfessor.getYearsOfExpreience());
			ps.setInt(5, curProfessor.getCourseID());
			ps.setString(6, curProfessor.getEmailID());
			ps.setString(7, curProfessor.getPhoneNumber());
			ps.setString(8, curProfessor.getUserName());
			ps.setString(9, curProfessor.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Student> getAllStudentsUnderProfessor(Professor curProfessor) {
		Connection conn = Helper.getConnectionInstance();
		ArrayList<Student> allStudentsUnderProfessor = new ArrayList<Student>();

		String query = "SELECT * FROM Student WHERE courseEnrolled = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, curProfessor.getCourseID());

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student curStudent = new Student();
				curStudent.setStudentID(rs.getInt("studentID"));
				curStudent.setStudentName(rs.getString("studentName"));
				curStudent.setAge(rs.getInt("age"));
				curStudent.setCity(rs.getString("city"));
				curStudent.setCourseEnrolled(rs.getInt("courseEnrolled"));
				curStudent.setMarksSecured(rs.getInt("marksSecured"));
				curStudent.setGender(rs.getString("gender"));
				curStudent.setEmailID(rs.getString("emailID"));
				curStudent.setPhoneNumber(rs.getString("phoneNumber"));
				curStudent.setUserName(rs.getString("userName"));
				curStudent.setPassword(rs.getString("password"));

				allStudentsUnderProfessor.add(curStudent);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allStudentsUnderProfessor;
	}
	
	public static ArrayList<Student> getAllUnGradedStudentsUnderProfessor(Professor curProfessor) {
		Connection conn = Helper.getConnectionInstance();
		ArrayList<Student> allStudentsUnderProfessor = new ArrayList<Student>();

		String query = "SELECT * FROM Student WHERE courseEnrolled = ? AND marksSecured = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, curProfessor.getCourseID());
			ps.setInt(2, -1);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student curStudent = new Student();
				curStudent.setStudentID(rs.getInt("studentID"));
				curStudent.setStudentName(rs.getString("studentName"));
				curStudent.setAge(rs.getInt("age"));
				curStudent.setCity(rs.getString("city"));
				curStudent.setCourseEnrolled(rs.getInt("courseEnrolled"));
				curStudent.setMarksSecured(rs.getInt("marksSecured"));
				curStudent.setGender(rs.getString("gender"));
				curStudent.setEmailID(rs.getString("emailID"));
				curStudent.setPhoneNumber(rs.getString("phoneNumber"));
				curStudent.setUserName(rs.getString("userName"));
				curStudent.setPassword(rs.getString("password"));

				allStudentsUnderProfessor.add(curStudent);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return allStudentsUnderProfessor;
	}

	public static void changeProfessorPassword(Professor curProfessor, String newPassword) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE Professor SET password = ? WHERE professorID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setInt(2, curProfessor.getProfessorID());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void changeProfessorUserName(Professor curProfessor, String newUserName, String password) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE Professor SET userName = ? WHERE professorID = ? AND userName = ? AND password = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newUserName);
			ps.setInt(2, curProfessor.getProfessorID());
			ps.setString(3, curProfessor.getUserName());
			ps.setString(4, password);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addCourseChangeRequestToProfCourseReqTable(Professor curProfessor, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "INSERT INTO professor_course_change_request VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, curProfessor.getCourseID());
			ps.setInt(2, newCourseID);

			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateStudentMarksOfStudent(Student curStudent, int marks) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE STUDENT SET marksSecured = ? WHERE studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, marks);
			ps.setInt(2, curStudent.getStudentID());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void changeCourseForProfessorInRequest(Professor curProfessor, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "UPDATE  professor_new_req SET courseID = ? WHERE professorID = ? AND userName = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, newCourseID);
			ps.setInt(2, curProfessor.getProfessorID());
			ps.setString(3, curProfessor.getUserName());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
