package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.bean.MartBean;

public class MartDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	//½Ì±ÛÅæ ÆÐÅÏ
	private static MartDao mdao;
	public static MartDao getInstance() {
		if(mdao == null) {
			mdao = new MartDao();
		}
		return mdao;
	}
	
	private MartDao() {
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
	public ArrayList<MartBean> getAllMart() {
		ArrayList<MartBean> lists = new ArrayList<MartBean>();
		String sql = "select * from emart order by num";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MartBean mb = new MartBean();
				
				mb.setNum(rs.getInt("num"));
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setProduct(rs.getString("product"));
				mb.setTime(rs.getString("time"));
				mb.setApprove(rs.getString("approve"));
				mb.setAgree(rs.getString("agree"));
				
				lists.add(mb);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}
	
	
	/* insert */
	public void insertMart(MartBean mb) {
		String sql = "insert into emart values(e_seq.nextval,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPw());
			ps.setString(3, mb.getProduct());
			ps.setString(4, mb.getTime());
			ps.setString(5, mb.getApprove());
			ps.setString(6, mb.getAgree());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//insertMart
	
	/* select by num */
	public MartBean getMartbyNum(int num) {
		MartBean mb = new MartBean();
		String sql = "select * from emart where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				mb.setId(rs.getString("id"));
				mb.setPw(rs.getString("pw"));
				mb.setProduct(rs.getString("product"));
				mb.setTime(rs.getString("time"));
				mb.setApprove(rs.getString("approve"));
				mb.setAgree(rs.getString("agree"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mb;
	}
	
	/* update */
	public void updateMart(MartBean mb) {
		String sql = "update emart set id=?, pw=?, product=?, time=?, approve=?, agree=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mb.getId());
			ps.setString(2, mb.getPw());
			ps.setString(3, mb.getProduct());
			ps.setString(4, mb.getTime());
			ps.setString(5, mb.getApprove());
			ps.setString(6, mb.getAgree());
			ps.setInt(7, mb.getNum());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//updateMart
	
	/* delete */
	public void deleteMart(int num) {
		String sql = "delete from emart where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//deleteMart
	
	/* checkbox delete */
	public void deleteMartbyChk(String[] numArr) {
		String sql = "delete from emart where num=?";
		for(int i=0; i<numArr.length-1; i++) { 
			sql += " or num=?";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			
			for(int i=0; i<numArr.length; i++) {
				ps.setString(i+1,numArr[i]);
			}
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}//deleteMartbyChk

}
