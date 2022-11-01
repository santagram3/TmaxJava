package ch20;
//https://m.blog.naver.com/gongtong/150135598792
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	public static void main(String[] args) {
		//1.dbms와의 연결객체 얻기(singleton)
		Connection conn=null;
		try {
			//2. jdbc드라이버 로딩
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			//3.연결객체 인스턴스 생성
			  String url="jdbc:oracle:thin:@localhost:1521:xe";
			  String user="java";
			  String password="oracle";
			  conn = //factory패턴(GOF)
			     DriverManager.getConnection(url, user, password);

			  System.out.println("연결성공");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				conn.close();
				System.out.println("연결끊기");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}