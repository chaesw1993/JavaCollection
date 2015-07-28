package util.vector;

import java.util.Scanner;

/*
 * @ Date : 2015.07.27
 * @ Author : Chae S W
 * @ Story : 성적산출 컨트롤러
 */
public class GradeController {
	public static void main(String[] args) {
		GradeService service = new GradeServiceImpl();
		
	/*	// 개발과정에서 테스트를 위한 임시값 : 더미값(쓰레기)
		Grade hong = new Grade("1301", "홍길동", 100, 100, 100);
		Grade kim = new Grade("1302", "김유신", 50, 50, 50);
		Grade lee = new Grade("1303", "이순신", 30, 30, 30);

		// Grade 타입의 인스턴스(객체)인 hong이 service 인터페이스를 구현한 serviceimpl 클래스의
		// input()메소드에 할당된다.
		service.input(hong);
		service.input(kim);
		service.input(lee);*/

		/* 지시값을 전달할 스캐너 */
		Scanner scanner = new Scanner(System.in);
		int input = 0, key = 0;
		/* 무한루프 엔진 */
		while (true) {
			/* 메뉴 */
			System.out.println("1. 성적 입력 2. 성적 조회(학번) 3. 성적 조회(이름) " + "4. 전체 성적 조회 5. 성적순 정렬 6.이름순 정렬 0. 종료");
			input = scanner.nextInt();
			/* 입력값 체크(밸류데이션) */
			key = inputCheck(input, 0, 6);
			if (input != 0) {
				switch (key) {
				case 1: // 성적 입력
					System.out.println("학번 : ");
					String hakbun = scanner.next();
					System.out.println("이름 : ");
					String name = scanner.next();
					System.out.println("국어점수 : ");
					int kor = scanner.nextInt();
					System.out.println("영어점수 : ");
					int eng = scanner.nextInt();
					System.out.println("수학점수 : ");
					int math = scanner.nextInt();
					Grade grade = new Grade(hakbun, name, kor, eng, math);
					service.input(grade);
					break;
				case 2: // 성적 조회(학번)
					System.out.println("학번 : ");
					System.out.println(service.serachGradeByHakbun(scanner.next()));
					break;
				case 3: // 성적 조회(이름)
					System.out.println("이름 : ");
					System.out.println(service.serachGradeByName(scanner.next()));
					break;
				case 4: // 전체 성적 조회
					service.printList();
					break;
				case 5: // 성적순 정렬
					service.descByTotal();
					break;
				case 6: // 이름순 정렬
					service.ascByName();
					break;
				default:
					System.out.println("에러 발생");
					break;
				}
			} else {
				System.out.println("시스템 종료");
				break;
			}
		}
	}
	private static int inputCheck(int input, int i, int j) {
		if (input < i || input > j) {
			System.out.println("숫자를 잘 못 입력하였습니다.");
			return 0;
		} else {
			return input;
		}
	}
}
/*
 * (인터페이스 구현한) 객체 + 스캐너 + input변수... 장착
 * 
 * while(true){ if(input != 0){
 * 
 * } else{ break; } }
 */