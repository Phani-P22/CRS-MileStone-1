package com.digit.javaTraining.CRS.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.digit.javaTraining.CRSApp.Helper;

public class Student {

	private int studentID;
	private String studentName;
	private int age;
	private String city;
	private int courseEnrolled;
	private int marksSecured;
	private String gender;
	private String emailID;
	private String phoneNumber;
	private String userName;
	private String password;

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

	public int getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(int courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	public int getMarksSecured() {
		return marksSecured;
	}

	public void setMarksSecured(int marksSecured) {
		this.marksSecured = marksSecured;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public static Student authenticateStudent(String userName, String password) {
		Connection conn = Helper.getConnectionInstance();
		Student curStudent = null;

		String query = "SELECT * FROM Student WHERE userName = ? AND password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curStudent = new Student();
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curStudent;
	}

	public static Student authenticateStudentInRequestsTable(String userName, String password) {
		Connection conn = Helper.getConnectionInstance();
		Student curStudent = null;

		String query = "SELECT * FROM STUDENT_NEW_REQ WHERE userName = ? AND password = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curStudent = new Student();
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
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return curStudent;
	}

	public static boolean studentSignUp(Student curStudent) {
		Connection conn = Helper.getConnectionInstance();
		String query = "INSERT INTO STUDENT_NEW_REQ(studentName, age, city, courseEnrolled,"
				+ " gender, emailID, phoneNumber, userName, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curStudent.getStudentName());
			ps.setInt(2, curStudent.getAge());
			ps.setString(3, curStudent.getCity());
			ps.setInt(4, curStudent.getCourseEnrolled());
			ps.setString(5, curStudent.getGender());
			ps.setString(6, curStudent.getEmailID());
			ps.setString(7, curStudent.getPhoneNumber());
			ps.setString(8, curStudent.getUserName());
			ps.setString(9, curStudent.getPassword());

			int statusCode = ps.executeUpdate();
			if (statusCode > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static ArrayList<Student> getAllStudentSignUpRequestsList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Student> allStudentRequestsList = new ArrayList<Student>();
		String query = "SELECT * FROM STUDENT_NEW_REQ";

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);
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

				allStudentRequestsList.add(curStudent);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return allStudentRequestsList;
	}

	public static void changeStudentUserName(Student curStudent, String newUserName, String password) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE Student SET userName = ? WHERE studentID = ? AND userName = ? AND password = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newUserName);
			ps.setInt(2, curStudent.getStudentID());
			ps.setString(3, curStudent.getUserName());
			ps.setString(4, password);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void changeStudentPassword(Student curStudent, String newPassword) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE Student SET password = ? WHERE studentID = ? AND userName = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setInt(2, curStudent.getStudentID());
			ps.setString(3, curStudent.getUserName());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addStudentCourseChangeRequestToCourseChangeRequestsTable(Student curStudent, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();
		String query = "INSERT INTO STUDENT_COURSE_CHANGE_REQUESTS VALUES (?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curStudent.getUserName());
			ps.setInt(2, curStudent.getStudentID());
			ps.setInt(3, newCourseID);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void withDrawStudentSignUpRequest(Student curStudent) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM STUDENT_NEW_REQ WHERE userName = ? AND studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curStudent.getUserName());
			ps.setInt(2, curStudent.getStudentID());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateCourseIDForStudentInPending(Student curStudent, int newCourse) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE STUDENT_NEW_REQ SET courseEnrolled = ? WHERE userName = ? AND studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, newCourse);
			ps.setString(2, curStudent.getUserName());
			ps.setInt(3, curStudent.getStudentID());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean isValidStudentID(int studentID) {
		Connection conn = Helper.getConnectionInstance();
		String query = "SELECT * FROM Student WHERE studentID = ?";
		try {

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, studentID);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void removeStudentFromTable(int studentID) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM Student WHERE studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, studentID);

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Student> getAllStudentsList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Student> allStudentsList = new ArrayList<Student>();
		String query = "SELECT * FROM Student";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
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

				allStudentsList.add(curStudent);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allStudentsList;
	}

	public static ArrayList<CourseChangeResponse> getAllCourseChangeReqOfStudents() {
		ArrayList<CourseChangeResponse> allRequests = new ArrayList<CourseChangeResponse>();

		Connection conn = Helper.getConnectionInstance();
		String query = "SELECT * FROM student_course_change_requests";

		int studentID, newCourseID;

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				studentID = rs.getInt("studentID");
				newCourseID = rs.getInt("newCourseID");

				CourseChangeResponse ccr = new CourseChangeResponse();
				ccr.setNewCourseID(newCourseID);

				Student curStudent = getStudentFromStudentTableUsingID(studentID);
				ccr.setCurObject(curStudent);

				allRequests.add(ccr);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return allRequests;
	}

	public static Student getStudentFromStudentTableUsingID(int studentID) {
		Connection conn = Helper.getConnectionInstance();
		Student curStudent = null;

		String query = "SELECT * FROM student WHERE studentID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, studentID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				curStudent = new Student();
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
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return curStudent;
	}

	public static void updateStudentCourseInTable(Student curStudent, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "UPDATE Student SET courseEnrolled = ? WHERE studentID = ? AND userName = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, newCourseID);
			ps.setInt(2, curStudent.getStudentID());
			ps.setString(3, curStudent.getUserName());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void deleteStudentCourseChangeRequest(int studentID, int newCourseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "DELETE FROM student_course_change_requests WHERE studentID = ? AND newCourseID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, studentID);
			ps.setInt(2, newCourseID);

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static ArrayList<Student> getAllStudentRequestsList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Student> allStudentRequestsList = new ArrayList<Student>();
		String query = "SELECT * FROM STUDENT_NEW_REQ";

		try {
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(query);
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

				allStudentRequestsList.add(curStudent);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return allStudentRequestsList;
	}

	public static void deleteStudentFromStudentRequestsTable(Student curStudent) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM STUDENT_NEW_REQ WHERE userName = ? AND studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curStudent.getUserName());
			ps.setInt(2, curStudent.getStudentID());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void addStudentToStudentTable(Student curStudent) {
		Connection conn = Helper.getConnectionInstance();

		String query = "INSERT INTO STUDENT(studentName, age, city, courseEnrolled,"
				+ " gender, emailID, phoneNumber, userName, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curStudent.getStudentName());
			ps.setInt(2, curStudent.getAge());
			ps.setString(3, curStudent.getCity());
			ps.setInt(4, curStudent.getCourseEnrolled());
			ps.setString(5, curStudent.getGender());
			ps.setString(6, curStudent.getEmailID());
			ps.setString(7, curStudent.getPhoneNumber());
			ps.setString(8, curStudent.getUserName());
			ps.setString(9, curStudent.getPassword());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void deRegisterStudentGrades(Student curStudent) {
		Connection conn = Helper.getConnectionInstance();
		String query = "UPDATE STUDENT SET marksSecured = -1 WHERE studentID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, curStudent.getStudentID());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
