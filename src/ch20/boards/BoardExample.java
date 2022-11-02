package ch20.boards;

import java.util.Scanner;

public class BoardExample {
	// 스캐너 받기 
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// 메인메소드 실행 ! 
		BoardExample boardExample = new BoardExample();
		boardExample.list();
	}

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("----------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("----------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s \n", "2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
		mainMenu();
	}// list() 끝.

	public void mainMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.println("----------------------------------------------------------");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1":
			create();
			break;
		case "2":
			read();
			break;
		case "3":
			clear();
			break;
		case "4":
			exit();
			break;
		}

	}

	private void exit() {
		System.exit(0);
	}

	public void clear() {
		System.out.println("***clear()메소드 실행 ");
		list();
	}

	public void read() {
		System.out.println("***read()메소드 실행 ");
		list();
	}

	public void create() {
		System.out.println("***create()메소드 실행 ");
		list();
	}
}
