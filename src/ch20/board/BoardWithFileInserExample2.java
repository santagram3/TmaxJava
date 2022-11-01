package ch20.board;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardWithFileInserExample2 {

	public static void main(String[] args) {

		// 1.
		Connection conn = null;
	
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
			  String sql="insert into board values(seq_bno.nextval,?,?,?,sysdate,?,?)";
			  System.out.println(sql);
		
			//3-2. 쿼리문 전달객체 생성
			 PreparedStatement pstmt = conn.prepareStatement(sql,new String[]{"bno"});
			 
			 //값 세팅
			 //3-2-1.
			   pstmt.setString(1,"눈 오는 날" );
			   pstmt.setString(2, "함박눈이 내려요");
			   pstmt.setString(3, "winter");
			   pstmt.setString(4, "snow.jpg");
			   pstmt.setBlob(5,new FileInputStream("src/ch20/picture/snow.jpg"));
			   
			//3-3. 쿼리문 전달 및 실행 
			//-- insert/update/delete 일때 executeUpdate()
			//return값은 입력/수정/삭제한 행의 수
			  int result =pstmt.executeUpdate();
			  if(result==1) { 
				  System.out.println(result+"행이 입력됨");
				 ResultSet rs=pstmt.getGeneratedKeys();
				 if(rs.next()) {
					 int bno=rs.getInt(1);
					 System.out.println("저장된 bno:"+bno);
				 }
			  }  
			  //java프로그램은 auto commit모드

		} catch (Exception e) {
			 System.out.println(e.getMessage());
		}finally {
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
