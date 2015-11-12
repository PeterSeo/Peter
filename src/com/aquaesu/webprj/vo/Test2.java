package com.aquaesu.webprj.vo;


import java.sql.SQLException;
import java.util.List;

import com.aquaesu.webprj.dao.Memberdao;



public class Test2 {
	public static void main(String[] args) throws SQLException{
		Memberdao dao=new Memberdao();
		List<Member> list= dao.getMembers();
		for(Member m : list)
			System.out.println("mid : %s, name : %s\n"+m.getMid()+m.getName());
		
	}
}
