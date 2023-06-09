package com.lgy.spring_project_tester.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lgy.spring_project_tester.dto.MemDto;

// DB SQL 처리
public class MemDao {
	DataSource dataSource;
	
	//DBCP 방식으로 오라클 연결 (혹은 JDBC)
	public MemDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원가입 처리
	public int insertMember(MemDto member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ZHP_TESTER (MEM_UID, MEM_PWD, MEM_NAME, MEM_EMAIL, MEM_ADDRESS) VALUES(?,?,?,?,?)";
		int re = -1;	// 초기값 -1, 회원가입 정상 1
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMem_uid());
			pstmt.setString(2, member.getMem_pwd());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_email());
			pstmt.setString(4, member.getMem_address());
			re = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return re;
	}
}
