package ch20.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//1. 드라이버 로딩
//2. connection연결객체 얻기
//3. sql문작성 dbms에 전달
//4. 결과 확인
//5. 자원해제
public class UserDeleteExample1 {
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
		  conn = //factory패턴(GOF)
		 DriverManager.getConnection(url, user, password);
		 
		 System.out.println("삭제할 유저 id >");
		 String id=scanner.next();
		  String sql="delete from users where userid='"+id+"'";
		  System.out.println(sql);
		  
		  Statement stmt = conn.createStatement();
		  int result =stmt.executeUpdate(sql);
		  if(result>0) System.out.println(result+"행이 입력됨");
		 
	 }catch(Exception e) {
		 System.out.println(e.getMessage());
	 }finally {
		 try {
			 conn.close();
		 }catch (Exception e) {
            System.out.println(e.getMessage());
		}
	 }
	}
}