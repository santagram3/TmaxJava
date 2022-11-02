package ch20.board;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardSelectExample2 {
	public static void main(String[] args) {
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
			  String sql="select bno, btitle,bcontent,bwriter,bdate, "
			  		   + " bfilename,bfiledata from boards where bno=?";
			  System.out.println(sql);
			//3-2. 쿼리문 전달객체 생성
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 
			 //값 세팅
			 //3-2-1.
			   pstmt.setInt(1, 3);			  
			   
			//3-3. 쿼리문 전달 및 실행 
			 ResultSet rs =pstmt.executeQuery();
			 while(rs.next()) {
			   Boards board = new Boards();
			   board.setBno(rs.getInt("bno"));
			   board.setBtitle(rs.getString("btitle"));
			   board.setBcontent(rs.getString("bcontent"));
			   board.setBwriter(rs.getString("bwriter"));
			   board.setBdate(rs.getDate("bdate"));
			   board.setBfilename(rs.getString("bfilename"));
			   board.setBfiledata(rs.getBlob("bfiledata"));
			
			   System.out.println(board);
			   
			  //별도 파일 저장
			  Blob blob = board.getBfiledata();
			  if(blob!=null) {
				  InputStream is = blob.getBinaryStream();
				  OutputStream os = 
			   new FileOutputStream("c:/temp/"+board.getBfilename());
			  is.transferTo(os);
			  os.flush();
			  os.close();
			  is.close();
			  } 
			 }  
			 rs.close();
			 pstmt.close();
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
