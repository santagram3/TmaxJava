package ch20.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserSelectExample {
	public static void main(String[] args) {
	 Connection conn=null;  
	 
	 Scanner sc = new Scanner(System.in);
	 
	try {
		  //1-1.드라이버로딩
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  //2.연결객체 인스턴스 생성
		  String url="jdbc:oracle:thin:@localhost:1521:xe";
		  String user="java";
		  String password="oracle";
		  conn = DriverManager.getConnection(url, user, password);
		  //sql문 작성
		  
		  System.out.println("조회할 userid ");
		  String userid = sc.next();
		  
		  String sql ="select * from users where userid=?";
		  //sql문 전달 객체 를 생성
		   PreparedStatement pstmt = conn.prepareStatement(sql);
		   
		   pstmt.setString(1, userid);
		   
		  //sql문 실행하고 결과
		  //--select문은 executeQuery()로 실행
		  ResultSet rs= pstmt.executeQuery();
		  
		  //결과보기
		  while(rs.next()) {
			 String id=rs.getString("userid");
			 String name=rs.getString("username");
			 String pwd=rs.getString("userpassword");
			 int age=rs.getInt("userage");
			 String email=rs.getString("useremail");
			System.out.println(id+","+name+","+pwd+","+age+","+email);
		  }
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		
	}	

	}
}
