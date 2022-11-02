package ch20.boards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class BoardExample2 {
	
	Scanner scanner = new Scanner(System.in);
	
	
	public static void main(String[] args) {
	
		BoardExample2 boardExample = new BoardExample2();
		boardExample.list();
		
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n ", "no" ,"writer", "date","title");
		System.out.println("------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n",
				"1" ,"writer", "2022-06-16","게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s\n",
				"2" ,"writer", "2022-06-19","올 겨울은 많이 춥습니다.");
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit ");
		System.out.println("------------------------------");
		System.out.println("메뉴선택 : ");
		String menuNo = scanner.nextLine();
		System.out.println();
	
		switch(menuNo) {
		case "1": Create(); break;
		case "2": Read(); break;
		case "3": Clear(); break;
		case "4": Exit(); break;
		
		
		}
		
	
	}

	public void Exit() {
		System.exit(0);
	}

	public void Clear() {
	System.out.println("***Clear()메소드 실행"); 
	list();
		
	}

	public void Read() {
		System.out.println("***Read()메소드 실행"); 
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
			  String sql="select bno, btitle, bwriter , bdate from board ";
			  System.out.println(sql);
			//3-2. 쿼리문 전달객체 생성
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 
			 //값 세팅
			 //3-2-1.
			  
			   
			//3-3. 쿼리문 전달 및 실행 
			 ResultSet rs =pstmt.executeQuery();
			 while(rs.next()) {
			  Board board = new Board();
			   board.setBno(rs.getInt("bno"));
			   board.setBtitle(rs.getString("btitle"));
			   board.setBcontent(rs.getString("bcontent"));
			   board.setBwriter(rs.getString("bwriter"));
			   board.setBdate(rs.getDate("bdate"));
			
			   System.out.printf("%-6s%-12s%-16s%-40s\n ", board.getBno() ,board.getBwriter(), board.getBcontent(),board.getBtitle());
			 }
			   
			   list();
		
	}

	public void Create() {
		System.out.println("***Creat()메소드 실행"); 
		list();
		
	}
	
	
	
	
	
	

}
