package util.vector;
/*
	프로그램을 코딩하다 보면 자료구조를 다루는 데 있어서
	CRUD 액션의 반복을 경험하게 된다.
	Create : 입력, 생산
	Read : 조회, 출력
	Update : 수정 -> 저장된 값을 수정 (DB)
	Delete : 삭제 -> 완전삭제 (DB), null 값으로 바꾸는 삭제
*/
import java.util.Vector;

/*
 * @ Date : 2015.07.27
 * @ Author : Chae S W
 * @ Story : Vector를 이용한 성적산출 인터페이스를 구현한 클래스
 */
public class GradeServiceImpl implements GradeService{
	// 필드에 아래 메소드들이 공유할 자료구조를 뭘 쓸까 ?
	// 1. ArrayList 2. Vector 3. Stack 4. HashMap
	// 순서 O, 중복 O -- 성적순 정렬, 동명이인 
	
	private Vector<Grade> vec = new Vector<Grade>();
	Grade grade = new Grade();
	
	@Override
	public void input(Grade grade) {
		// 성적표 입력
//		만약 배열을 사용했다면 옆의 코딩대로 해야한다. / arr[0] = grade;
//		필드에 자료구조를 박아놓고 이렇게 한줄로 코딩을 해야 한다.
		vec.add(grade);
	}

	@Override
	public void pirntList() {
		// 전체 출력
//		vec.toString(); -- vec안에 들어있는것들을 출력하는 메소드 = toString
		System.out.println(vec.toString());
	}

	
	
	// 존나 중요!!
	@Override
	public String serachGradeByHakbun(String hakbun) {
		String msg="";
		Grade grade = null;	// 지변으로 인스턴스(객체)를 선언했으므로 초기화 해야 함.
		// 검색할땐 일반 for문을 사용하고 , 출력할땐 확장 for문을 사용한다!!!
		
		// List 계열의 클래스길이는 size()로 구한다.
		for (int i = 0; i < vec.size(); i++) {
			// 만약 vec가 배열이라면
			// vec.get(i)
			String searchHakbun = vec.elementAt(i).getHakbun();
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.elementAt(i).getName();
				// 객체.메소드.메소드.메소드.메소드 이런 패턴이 가능할 때는 반드시 return 값이 있는 메소드들 끼리 연결시에만 가능하다.
				// 이런 방식을 메소드 체인이라고 한다.
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(searchHakbun, name, kor, eng, math);
				msg = grade.toString();
				break;	// 중간이라도 학번이 일치하면 빠져나오도록
			} else {
				msg = "조회한 학번이 없습니다.";
			}
			
		}
		return msg;
	}

	
	
	@Override
	public void ascGradeTotal() {
		// 성적 정렬
	}

}
