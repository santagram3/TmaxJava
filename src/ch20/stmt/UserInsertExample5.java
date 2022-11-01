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
public class UserInsertExample5 {
	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 //1. 
		Connection conn=null;
		//Connection conn2=null;
		
	 try {
		  //1-1.드라이버로딩
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  //2.연결객체 인스턴스 생성
		  String url="jdbc:oracle:thin:@localhost:1521:xe";
		  String user="java";
		  String password="oracle";
		  conn = //factory패턴(GOF)
		 DriverManager.getConnection(url, user, password);
		 
		 System.out.println("id,name,pwd,email,age >");
		 String id=scanner.next();
		 String name=scanner.next();
		 String pwd=scanner.next();
		 String email=scanner.next();
		 int age=scanner.nextInt();
		  String sql="insert into users values('"+id+"','"+name+"','"+pwd+"',"+age+",'"+email+"')";
		  System.out.println(sql);
		  Statement stmt = conn.createStatement();
		  int result =stmt.executeUpdate(sql);
		  if(result>0) System.out.println(result+"행이 입력됨");
		  
		  //입력결과 조회
		  //conn2=DriverManager.getConnection(url, user, password);
		  sql ="select * from users";
		  //sql문 전달 객체 를 생성
		  //stmt = conn2.createStatement();
		  //sql문 실행하고 결과
		  //--select문은 executeQuery()로 실행
		  ResultSet rs= stmt.executeQuery(sql);
		  
		  //결과보기
		  while(rs.next()) {
			  id=rs.getString("userid");
			  name=rs.getString("username");
			  pwd=rs.getString("userpassword");
			  age=rs.getInt("userage");
			  email=rs.getString("useremail");
			System.out.println(id+","+name+","+pwd+","+age+","+email);
		  }
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