package util.vector;

import java.util.Scanner;
import java.util.Vector;

/*
 * @ Date : 2015.07.24
 * @ Author : Chae S W
 * @ Story : java.util.Vector의 메소드 중에 추가기능을 담당하는 add()
 */
public class AddDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<String> avengers = new Vector<String>();
//		vec.add("홍길동");
		// 크기가 4인 String 배열의 선언과 생성
		String[] heros = {"iron", "thor", "hulk", "hawk"};
		for (int i = 0; i < heros.length; i++) {
			avengers.add(heros[i]);
		}
		// 자료구조는 저장과 검색이라는 기능을 위해 만들어진 클래스이다.
		// thor 가 avengers 회원인지 검색 ?
		System.out.println("어벤져스 회원검색\n이름 입력 : ");
		String thor = scanner.next();
		if (avengers.contains(thor)) {
			int idx = avengers.indexOf(thor);
			System.out.println(thor + "은(는)" + (idx+1) + "번째 입니다.");
		} else {
			System.out.println(thor + "은(는)" +  "어벤져스가 아닙니다.");
		}
		// 첫번째 요소 삭제
		avengers.remove(0);	// 인덱스값을 파라미터로 전달하면 삭제 완료~~
	}
}
