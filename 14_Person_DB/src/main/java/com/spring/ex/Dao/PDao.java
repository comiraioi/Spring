package com.spring.ex.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.spring.ex.Dto.PDto;

public class PDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//싱글톤 패턴
	private static PDao pdao;
	
	public static PDao getInstance() {
		if(pdao == null) {
			pdao = new PDao();
		}
		return pdao;
	}
	
	private PDao() {
		Context initContext;
		
		try {
			//1. 드라이버 로드
			Class.forName(driver);
			//2. 계정 접속
			conn = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}//생성자
	
	/* select */
	public ArrayList<PDto> getAllPerson() {
		ArrayList<PDto> lists = new ArrayList<PDto>();
		String sql = "select * from person order by num";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				PDto pb = new PDto();
				pb.setNum(rs.getInt("num"));
				pb.setId(rs.getString("id"));
				pb.setName(rs.getString("name"));
				pb.setAge(rs.getInt("age"));
				
				lists.add(pb);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
		
	}//getAllPerson
	
	/* insert */
	public void write(String id, String name, int age) {
		String sql = "insert into person values(pseq.nextval,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setInt(3,age);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//write
	
	/* num으로 select */
	public PDto getPersonbyNum(int num) {
		PDto pb = new PDto();
		String sql = "select * from person where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				pb.setNum(rs.getInt("num"));
				pb.setId(rs.getString("id"));
				pb.setName(rs.getString("name"));
				pb.setAge(rs.getInt("age"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		return pb;
		
	}//getPersonbyNum
	
	/* update */
	public void updatePerson(PDto pb) {
		String sql = "update person set id=?, name=?, age=? where num=?";
				
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, pb.getId());
			ps.setString(2, pb.getName());
			ps.setInt(3, pb.getAge());
			ps.setInt(4, pb.getNum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//updatePerson
	
	/* delete */
	public void deletePerson(int num) {
		String sql = "delete from person where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) 
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//deletePerson
	
	
}
