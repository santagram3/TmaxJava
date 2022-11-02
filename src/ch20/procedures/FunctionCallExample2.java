package ch20.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class FunctionCallExample2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection conn=null;
		 try{
			  //1-1.드라이버로딩
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			  //2.연결객체 인스턴스 생성
			  String url="jdbc:oracle:thin:@localhost:1521:xe";
			  String user="java";
			  String password="oracle";
			  conn = DriverManager.getConnection(url, user, password);
			  
			  //프로시져 호출 문 작성 및 CallableStatement객체 얻기
			  String sql="{? = call user_login(?,?)}";
			  CallableStatement cstmt = conn.prepareCall(sql);
			  
			  
			  System.out.println("id를 입력하세요>");
			  String id=scanner.next().trim();
			  System.out.println("password를 입력하세요>");
			  String pwd=scanner.next().trim();
			  
			  
			  //값 설정
			  int i=0;
			  cstmt.registerOutParameter(++i,Types.INTEGER);
			  cstmt.setString(++i,id);
			  cstmt.setString(++i,pwd);
			  
			  //실행
			  cstmt.execute();
			  
			  //결과 값 얻기
			  int result = cstmt.getInt(1);
			  //CallableStatement닫기
			  cstmt.close();
			  
			  String message="";
			  switch(result) {
			  case 0: message="로그인 성공"; break;
			  case 1: message="비밀번호가 틀림 "; break;
			  case 2: message="아이디가 존재하지 않음"; break;
			  default: message="오류";
			  }
			  
			  System.out.println(message);
			  
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	}
}
