package com.project1.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project1.member.model.dto.MemberDTO;

public class MemberDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public MemberDTO login(MemberDTO member) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = """
				SELECT
					MEMBER_ID, MEMBER_PW, MEMBER_NAME, EMAIL, ENROLL_DATE
				FROM
					KH_MEMBER
				WHERE
					MEMBER_ID = ? AND MEMBER_PW =?
				""";
		
		MemberDTO loginMember = null;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE", "KH15_LSM", "KH1234");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new MemberDTO(
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PW"),
						rs.getString("MEMBER_NAME"),
						rs.getString("EMAIL"),
						rs.getDate("ENROLL_DATE")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return loginMember;
	}
	
	
	// ID 중복 확인
	public int checkId(String memberId) {
		
		String sql = """
				SELECT
					COUNT(*)
				FROM
					KH_MEMBER
				WHERE
					MEMBER_ID = ?
				""";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE", "KH15_LSM", "KH1234");

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			result = rs.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public void signUp(MemberDTO member) {
		
		String sql = """
				INSERT INTO
					TB_MEMBER
				VALUES
					(?, ?, ?, ?, DEFAULT)
				""";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE", "KH15_LSM", "KH1234");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
