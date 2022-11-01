package ch20.stmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//1. 드라이버 로딩
//2. connection연결객체 얻기
//3. sql문작성 dbms에 전달
//4. 결과 확인
//5. 자원해제
public class UserInsertExample2 {
	public static void main(String[] args) {
	 //1. 
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
		//3. sql문작성 dbms에 전달
		  String sql=new StringBuilder()
				    .append("insert into users ")
				    .append("(userid,username,userpassword,userage,useremail)")
				    .append(" values('kim','김길동','1234',25,'kim@daum.net')").toString();
		  System.out.println(sql);
		//3-2. 쿼리문 전달객체 생성
		  Statement stmt = conn.createStatement();
		//3-3. 쿼리문 전달 및 실행 
		//-- insert/update/delete 일때 executeUpdate()
		//return값은 입력/수정/삭제한 행의 수
		  int result =stmt.executeUpdate(sql);
		  if(result>0) System.out.println(result+"행이 입력됨");
		  //java프로그램은 auto commit모드
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