package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	ArrayList<FDto> lists = null;
	
	//½Ì±ÛÅæ ÆÐÅÏ
	private static FDao fdao;
	
	public static FDao getInstance() {
		if(fdao == null) {
			fdao = new FDao();
		}
		return fdao;
	}
	
	private FDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//»ý¼ºÀÚ
	
	/* select */
	public ArrayList<FDto> getAllFootball(){
		lists = new ArrayList<FDto>();
		String sql = "select * from football order by num";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FDto fb = new FDto();
				
				fb.setNum(rs.getInt("num"));
				fb.setId(rs.getString("id"));
				fb.setPw(rs.getString("pw"));
				fb.setWin(rs.getString("win"));
				fb.setRound16(rs.getString("round16"));
				
				lists.add(fb);
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
		
	}//getAllFootball
	
	/* insert */
	public void insertFootball(FDto fb) {
		String sql = "insert into football values(fb_seq.nextval,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, fb.getId());
			ps.setString(2, fb.getPw());
			ps.setString(3, fb.getWin());
			ps.setString(4, fb.getRound16());
			
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
		
	}//insertPerson
	
	/* select by num */
	public FDto getFootballbyNum(int num) {
		FDto fb = new FDto();
		String sql = "select * from football where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				fb.setNum(rs.getInt("num"));
				fb.setId(rs.getString("id"));
				fb.setPw(rs.getString("pw"));
				fb.setWin(rs.getString("win"));
				fb.setRound16(rs.getString("round16"));
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
		
		return fb;
		
	}//getFootballbyNum
	
	/* update */
	public void updateFootball(FDto fb) {
		String sql = "update football set id=?, pw=?, win=?, round16=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, fb.getId());
			ps.setString(2, fb.getPw());
			ps.setString(3, fb.getWin());
			ps.setString(4, fb.getRound16());
			ps.setInt(5, fb.getNum());
			
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
	}//updateFootball
	
	/* delete */
	public void deleteFootball(int num) {
		String sql = "delete from football where num=?";
		
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
		
	}//deleteFootball
	
}
