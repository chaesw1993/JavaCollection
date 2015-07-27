package util.vector;
/*
 * @ Date : 2015.07.27
 * @ Author : Chae S W
 * @ Story : 성적산출 컨트롤러
 */
public class GradeController {
	public static void main(String[] args) {
		GradeService service = new GradeServiceImpl();
		Grade hong = new Grade("1301", "홍길동", 100, 100, 100);
		Grade kim = new Grade("1302", "김유신", 50, 50, 50);
		Grade lee = new Grade("1303", "이순신", 30, 30, 30);
		
		// Grade 타입의 인스턴스(객체)인 hong이 service 인터페이스를 구현한 serviceimpl 클래스의
		// input()메소드에 할당된다.
		service.input(hong);
		service.input(kim);
		service.input(lee);
		
		// 전체 학생 성적표를 출력
		service.pirntList();
	}
}
