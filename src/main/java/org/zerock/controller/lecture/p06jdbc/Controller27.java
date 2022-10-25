package org.zerock.controller.lecture.p06jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex27")
public class Controller27 {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("sub01")
	public void method1() throws Exception {
		String sql1 = "UPDATE Bank "
				+ "SET balance = balance - 100 "
				+ "WHERE customerId = 2";
		String sql2 = "UPDATE Bank SET balance = balance + 100 "
				+ "WHERE customerId = 1";
		
		try (Connection con = dataSource.getConnection()) {
			
			try {
				// autocommit : disabled
				con.setAutoCommit(false);
				
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql1);
				
//				int a = 0;
//				int b = 3 / a; // ArithmeticException;
				
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate(sql2);
				
				con.commit();
				
			} catch (Exception e) {
				con.rollback();
			}
		}
	}
	
	@GetMapping("sub02")
	public void method2() {
		
	}
	
	@PostMapping("sub02")
	public void method3(String fname, String lname, int salary) throws SQLException {
		// Employee 테이블 INSERT 쿼리 실행
		// Salary 테이블 INSERT 쿼리 실행
		
		// 위 두 쿼리가 모두 실행되거나
		//              모두 실패할 수 있는 코드 작성
		String sql1 = "INSERT INTO Employees "
				+ "(FirstName, LastName) "
				+ "VALUES (?, ?)";
		String sql2 = "INSERT INTO Salary "
				+ "(EmployeeID, Salary)"
				+ "VALUES (?, ?)";
		try(Connection con = dataSource.getConnection();){
			con.setAutoCommit(false);
			
			try (PreparedStatement pstmt1 = con.prepareStatement(sql1, 1);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);) {
				
				pstmt1.setString(1, fname);
				pstmt1.setString(2, lname);
				pstmt1.executeUpdate();
				
//				int a = 0;
//				int b = 3/a;
				
				try(ResultSet rs = pstmt1.getGeneratedKeys();){
					if(rs.next()) {
						int key = rs.getInt(1);
						pstmt2.setInt(1, key);
					}				
					pstmt2.setInt(2, salary);				
					pstmt2.executeUpdate();
				}
				
				con.commit();
				
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
			}
			
		}
		
	}
}













