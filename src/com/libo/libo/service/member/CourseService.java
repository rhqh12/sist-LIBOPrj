package com.libo.libo.service.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libo.libo.member.Course;
import com.libo.libo.util.DBConn;

public class CourseService {
	public static void main(String[] args) {

		CourseService courseService = new CourseService();
		Course course = new Course(1, "18/06/27", "Y", "홍대역", "홍대역 주소", "18/06/27", "Y", "구로역", "구로역 주소", "18/06/27",
				"test", "18/06/27");

		courseService.insertCourse(course);

		course = new Course(1, "18/06/27", "Y", "홍대역", "홍대역 주소", "18/06/27", "Y", "구로역", "구로역 주소", "18/06/27", "test",
				"18/06/27");
		courseService.updateCourse(course);

		course = new Course(1, "18/06/27", "N", "홍대역", "홍대역 주소", "18/06/27", "N", "구로역", "구로역 주소", "18/06/27", "test",
				"18/06/27");
		courseService.updateCourseAlarm(course);

		long[] deleteId = { 2, 3 };
		courseService.deleteCourse(deleteId);
		
		courseService.getCourse(1);
		
		courseService.getCourseList("test");

	}

	public Course getCourse(long courseId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course course = new Course();
		String sql = "select * from course where id = ? order by id";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, courseId); // 매개변수 (순번, 넣을 값)
			rs = ps.executeQuery();
			if(rs.next()) {
				course.setId(rs.getInt("ID")); // 매개변수 (순번, 넣을 값)
				course.setStartingTime(rs.getString("STARTING_TIME"));
				course.setStartingAlarm(rs.getString("STARTING_ALARM"));
				course.setWorkplace(rs.getString("WORKPLACE"));
				course.setWorkplaceAddress(rs.getString("WORKPLACE_ADDRESS"));
				course.setEndingTime(rs.getString("ENDING_TIME"));
				course.setEndingAlarm(rs.getString("ENDING_ALARM"));
				course.setHome(rs.getString("HOME"));
				course.setHomeAddress(rs.getString("HOME_ADDRESS"));
				course.setWeek(rs.getString("WEEK"));
				course.setWriterId(rs.getString("WRITER_ID"));
				course.setDueDate(rs.getString("DUE_DATE"));
			}
			// 데이터테스트
			System.out.println(course.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, rs, ps);
		}
		return course;
	}

	public List<Course> getCourseList(String writerId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course where writer_id = ? order by id";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, writerId); // 매개변수 (순번, 넣을 값)
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID")); // 매개변수 (순번, 넣을 값)
				course.setStartingTime(rs.getString("STARTING_TIME"));
				course.setStartingAlarm(rs.getString("STARTING_ALARM"));
				course.setWorkplace(rs.getString("WORKPLACE"));
				course.setWorkplaceAddress(rs.getString("WORKPLACE_ADDRESS"));
				course.setEndingTime(rs.getString("ENDING_TIME"));
				course.setEndingAlarm(rs.getString("ENDING_ALARM"));
				course.setHome(rs.getString("HOME"));
				course.setHomeAddress(rs.getString("HOME_ADDRESS"));
				course.setWeek(rs.getString("WEEK"));
				course.setWriterId(rs.getString("WRITER_ID"));
				course.setDueDate(rs.getString("DUE_DATE"));
				list.add(course);
			}
			// 데이터테스트
			for (Course course : list) {
				System.out.println(course.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, rs, ps);
		}
		return list;
	}

	public void insertCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		sql += "INSERT INTO COURSE \n";
		sql += "(ID,STARTING_TIME,STARTING_ALARM,WORKPLACE,WORKPLACE_ADDRESS, \n";
		sql += "ENDING_TIME,ENDING_ALARM,HOME,HOME_ADDRESS,WEEK,WRITER_ID, DUE_DATE) \n";
		sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, course.getId()); // 매개변수 (순번, 넣을 값)
			ps.setString(2, course.getStartingTime());
			ps.setString(3, course.getStartingAlarm());
			ps.setString(4, course.getWorkplace());
			ps.setString(5, course.getWorkplaceAddress());
			ps.setString(6, course.getEndingTime());
			ps.setString(7, course.getEndingAlarm());
			ps.setString(8, course.getHome());
			ps.setString(9, course.getHomeAddress());
			ps.setString(10, course.getWeek());
			ps.setString(11, course.getWriterId());
			ps.setString(12, course.getDueDate());
			int cnt = ps.executeUpdate();
			if (cnt == 1)
				System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConn.close(conn, ps);
		}

	}

	public void updateCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		sql += "UPDATE COURSE SET \n";
		sql += "STARTING_TIME = ?,STARTING_ALARM = ?,WORKPLACE = ?,WORKPLACE_ADDRESS = ?, \n";
		sql += "ENDING_TIME = ?, ENDING_ALARM = ?, HOME = ?, HOME_ADDRESS = ?, WEEK = ? \n";
		sql += "WHERE ID = ?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getStartingTime());
			ps.setString(2, course.getStartingAlarm());
			ps.setString(3, course.getWorkplace());
			ps.setString(4, course.getWorkplaceAddress());
			ps.setString(5, course.getEndingTime());
			ps.setString(6, course.getEndingAlarm());
			ps.setString(7, course.getHome());
			ps.setString(8, course.getHomeAddress());
			ps.setString(9, course.getWeek());
			ps.setInt(10, course.getId());
			int cnt = ps.executeUpdate();
			if (cnt == 1)
				System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConn.close(conn, ps);
		}

	}

	public void updateCourseAlarm(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		sql += "UPDATE COURSE SET \n";
		sql += "STARTING_ALARM = ?,ENDING_ALARM = ? \n";
		sql += "WHERE ID = ?";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getStartingAlarm());
			ps.setString(2, course.getEndingAlarm());
			ps.setInt(3, course.getId());
			int cnt = ps.executeUpdate();
			if (cnt == 1)
				System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConn.close(conn, ps);
		}

	}

	public void deleteCourse(long[] id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		sql += "DELETE FROM COURSE \n";
		sql += "WHERE ID = ? \n";
		try {
			conn = DBConn.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < id.length; i++) {
				ps.setLong(1, id[i]);
				int cnt = ps.executeUpdate();
				if (cnt == 1)
					System.out.println("성공");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			DBConn.close(conn, ps);
		}
	}
}
