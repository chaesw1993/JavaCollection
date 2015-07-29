package util.hashmap;

import java.util.Scanner;

/*
 * @ Date : 2015.07.29
 * @ Author : Chae S W
 * @ Story : 로그인 회원가입등의 예제 컨트롤러
 */
public class MemberController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberService service = new MemberServiceImpl();
		String input="";
		
		while (true) {
			System.out.println("[join] 회원가입  [login]로그인  [logout]시스템 종료");
			input = scanner.next();
			if (input.equals("logout")) {
				System.out.println("로그아웃");
				break;
			} else {
				switch (input) {
				case "join":
					System.out.println("아이디 : ");
					String id = scanner.next();
					System.out.println("비밀번호 : ");
					String pass = scanner.next();
					System.out.println("이름 : ");
					String name = scanner.next();
					System.out.println("나이 : ");
					int age = scanner.nextInt();
					System.out.println("주소 : ");
					String address = scanner.next();
//					Member member = new Member(id, name, address, pass, age);
					service.join(id, name, address, pass, age);
					System.out.println("회원가입 성공");
					break;
				case "login":
					System.out.println("아이디 : ");
					String loginId = scanner.next();
					System.out.println("비밀번호 : ");
					String loginPass = scanner.next();
					String msg = service.login(loginId, loginPass);
					String flag = msg.substring(0,5);	// 0부터 5"미만"
					// 리턴값이 String이기때문에 출력문을 보려면 String 타입으로 값을 저장해야할것이 있어야한다.
					if (flag.equals("환영합니다")) {
						System.out.println(msg);
						break;
					} else if(flag.equals("비밀번호가")) {
						System.out.println(msg);
						break;
					} else{
						System.out.println(msg);
					}
					break;
				default:
					System.out.println("오류 발생");
					break;
				}
			}
		}
	}
	
}
