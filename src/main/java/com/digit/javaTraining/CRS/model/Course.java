package com.digit.javaTraining.CRS.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.digit.javaTraining.CRSApp.Helper;

public class Course {
	private int courseID;
	private String courseName;
	private String description;
	private int durationInHrs;
	private int fee;
	private float rating;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationInHrs() {
		return durationInHrs;
	}

	public void setDurationInHrs(int durationInHrs) {
		this.durationInHrs = durationInHrs;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public static void addCourseToCourseTable(Course curCourse) {
		Connection conn = Helper.getConnectionInstance();
		String query = "INSERT INTO COURSE(courseName, description, durationInHrs, fee, rating) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, curCourse.getCourseName());
			ps.setString(2, curCourse.getDescription());
			ps.setInt(3, curCourse.getDurationInHrs());
			ps.setInt(4, curCourse.getFee());
			ps.setFloat(5, curCourse.getRating());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean isValidCourseID(int courseID) {
		Connection conn = Helper.getConnectionInstance();

		String query = "SELECT * FROM Course WHERE courseID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, courseID);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static Course getCourseFromCourseTableUsingID(int courseID) {
		Connection conn = Helper.getConnectionInstance();
		Course curCourse = null;

		String query = "SELECT * FROM Course WHERE courseID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, courseID);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("HAS COURSE");
				curCourse = new Course();
				curCourse.setCourseID(rs.getInt("courseID"));
				curCourse.setCourseName(rs.getString("courseName"));
				curCourse.setDescription(rs.getString("description"));
				curCourse.setDurationInHrs(rs.getInt("durationInHrs"));
				curCourse.setRating(rs.getFloat("rating"));
				curCourse.setFee(rs.getInt("fee"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curCourse;
	}
	
	public static boolean deleteCourseFromCourseTableUsingID(int courseID) {
		Connection conn = Helper.getConnectionInstance();
		String query = "DELETE FROM COURSE WHERE courseID = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, courseID);
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public static ArrayList<Course> viewAllCoursesList() {
		Connection conn = Helper.getConnectionInstance();

		ArrayList<Course> allCoursesList = new ArrayList<Course>();
		String query = "SELECT * FROM Course";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Course curCourse = new Course();
				curCourse.setCourseID(rs.getInt("courseID"));
				curCourse.setCourseName(rs.getString("courseName"));
				curCourse.setDescription(rs.getString("description"));
				curCourse.setDurationInHrs(rs.getInt("durationInHrs"));
				curCourse.setFee(rs.getInt("fee"));
				curCourse.setRating(rs.getFloat("rating"));

				allCoursesList.add(curCourse);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return allCoursesList;
	}
}
