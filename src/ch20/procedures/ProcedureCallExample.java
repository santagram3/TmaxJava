package ch20.procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureCallExample {
	public static void main(String[] args) {
		Connection conn=null;
		 try {
			  //1-1.드라이버로딩
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			  //2.연결객체 인스턴스 생성
			  String url="jdbc:oracle:thin:@localhost:1521:xe";
			  String user="java";
			  String password="oracle";
			  conn = DriverManager.getConnection(url, user, password);
			  
			  //프로시져 호출 문 작성 및 CallableStatement객체 얻기
			  String sql="{call user_create(?,?,?,?,?,?)}";
			  CallableStatement cstmt = conn.prepareCall(sql);
			  
			  //값 설정
			  cstmt.setString(1,"summber");
			  cstmt.setString(2,"한여름");
			  cstmt.setString(3,"12345");
			  cstmt.setInt(4,26);
			  cstmt.setString(5,"summber@mycom.com");
			  cstmt.registerOutParameter(6,Types.INTEGER);
			  
			  //실행
			  cstmt.execute();
			  
			  //결과 값 얻기
			  int rows = cstmt.getInt(6);
			  System.out.println("저장된 행 수: "+rows);
			  
			  //CallableStatement닫기
			  cstmt.close();
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
