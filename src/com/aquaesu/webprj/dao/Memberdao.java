package com.aquaesu.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aquaesu.webprj.vo.Member;

public class Memberdao {
	public List<Member> getMembers() throws SQLException{
		return getMembers(1);
	}
	public List<Member> getMembers(int page) throws SQLException{
		List<Member> list =new ArrayList<Member>();
		int start = 1+(page-1)*10;//1,11,21,31
		int end = 10*page;//20
		String sql = "SELECT * FROM(SELECT ROW_NUMBER() OVER "
                + "(ORDER BY REGDATE DESC) NUM, * FROM MEMBERS)"
                + "A WHERE NUM BETWEEN " + start  +" AND " + end;
		
		String url="jdbc:oracle:thin:@211.238.142.251:1433;databaseName=edudb;";
		
		Connection con=DriverManager.getConnection(url,"edu","class2d");
	/*	System.out.println(con.isClosed());
		con.close();
		System.out.println(con.isClosed());*/
		
		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		Member member=null;
		while(rs.next()){
			member=new Member();
			member.setName(rs.getString("name"));
			member.setMid(rs.getString("mid"));
			list.add(member);
		System.out.println();
		}
		rs.close();
		stm.close();
		con.close();
		return list;
	}
}
