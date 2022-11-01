package ch20.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UserSelectExample6 {
	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 Connection conn=null;  
	try {
		  //1-1.드라이버로딩
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  //2.연결객체 인스턴스 생성
		  String url="jdbc:oracle:thin:@localhost:1521:xe";
		  String user="java";
		  String password="oracle";
		  conn = DriverManager.getConnection(url, user, password);
		  
		  System.out.println("조회할 시작 나이를 입력하세요>");
		  int firstAge = scanner.nextInt();
		  System.out.println("조회할 종료 나이를 입력하세요>");
		  int lastAge = scanner.nextInt();
		  //sql문 작성
		  String sql ="select * from users where userage between ? and ?";
		  System.out.println("완성된 sql문:" +sql);
		  //sql문 전달 객체 를 생성
		  PreparedStatement pstmt = conn.prepareStatement(sql);
		  
		  pstmt.setInt(1, firstAge);
		  pstmt.setInt(2, lastAge);
		  
		  
		  //--select문은 executeQuery()로 실행
		  ResultSet rs= pstmt.executeQuery();
		  
		  //결과보기
		  while(rs.next()) {
			 int i=0;
			 /* 인덱스 번호(1부터 시작)로 접근 */
			 String id=rs.getString(++i);
			 String name=rs.getString(++i);
			 String pwd=rs.getString(++i);
			 int age=rs.getInt(++i);
			 String email=rs.getString(++i);
			System.out.println(id+","+name+","+pwd+","+age+","+email);
		  }
	} catch (Exception e) {
		System.out.println(e);
	}finally {
		
	}	

	}
}
