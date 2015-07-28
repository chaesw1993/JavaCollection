package util.vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
	
	private List<Grade> vec = new ArrayList<Grade>();
	Grade grade = new Grade();
	
	@Override
	public void input(Grade grade) {
		// 성적표 입력
//		만약 배열을 사용했다면 옆의 코딩대로 해야한다. / arr[0] = grade;
//		필드에 자료구조를 박아놓고 이렇게 한줄로 코딩을 해야 한다.
		vec.add(grade);
	}

	@Override
	public void printList() {
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
			String searchHakbun = vec.get(i).getHakbun();
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.get(i).getName();
				// 객체.메소드.메소드.메소드.메소드 이런 패턴이 가능할 때는 반드시 return 값이 있는 메소드들 끼리 연결시에만 가능하다.
				// 이런 방식을 메소드 체인이라고 한다.
				int kor = vec.get(i).getKor();
				int eng = vec.get(i).getEng();
				int math = vec.get(i).getMath();
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
	public Vector<Grade> serachGradeByName(String name) {
		Vector<Grade> temp = new Vector<Grade>();
		Grade grade = null;
		for (int i = 0; i < vec.size(); i++) {
			String searchName = vec.get(i).getName();
			// 고정값을 (파리미터 값 name). equals 변수값(for문이 돌때마다 바뀜)
			if (name.equals(searchName)) {
				grade = new Grade(vec.get(i).getHakbun(), searchName, vec.get(i).getKor(),
						vec.get(i).getEng(), vec.get(i).getMath());
				temp.add(grade);
				// List계열 담는건 무.조.건 add
			} else {
				// temp라는 벡터를 완전히 비워서 null로 리턴
				temp.remove(new Grade());
			}
		}
		return temp;
	}
	
	@Override
	public void descByTotal() {
		// Java API 중에서 정렬담당 클래스 Comparator
		// 인터페이스를 구현한 익명 내부 클래스 (anonymous inner class)
		Comparator<Grade> desc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				/*
				 * int temp = 0;
				if (g1.getTotal() < g2.getTotal()) {
					temp = 1;
				} else {
					if (g1.getTotal() == g2.getTotal()) {
						temp = 0;
					} else {
						temp = -1;
					}
					return temp;
				}
				*/
				return (g1.getTotal() < g2.getTotal()) ? 1 : 
						(g1.getTotal() == g2.getTotal()) ? 0 : -1;
			}
		};
		Collections.sort(vec, desc);
		System.out.println(vec.toString());
	}

	@Override
	public void ascByName() {
		// 이름 오른차순 정렬(ㄱ,ㄴ,ㄷ...)
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 값이 int타입이 아니고 String타입의 우선순위 결정할땐...
				// compareTo라는 메소드를 사용해야 한다.
				return g1.getName().compareTo(g2.getName());
			}
		};
		Collections.sort(vec, asc);
		System.out.println(vec.toString());
	}
}
