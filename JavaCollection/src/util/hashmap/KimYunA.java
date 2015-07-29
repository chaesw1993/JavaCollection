package util.hashmap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * @ Date : 2015.07.29
 * @ Author : Chae S W
 * @ Story : java.util.HashMap의 예제
 */
public class KimYunA {
	public static void main(String[] args) {
		/*
			Map은 인터페이스
			HashMap은 Map을 구현(implements)한 클래스
			
			자료구조에선 원시타입을 넣을 수 없다.
		*/
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		// Key값이 스트링이고, Value값은 숫자인 HashMap 객체를 생성!
		// List 계열은 추가할때 add, Map 계열은 추가할때 put
		map.put("김연아", new Integer(98));	// int 타입은 Map에 들어 올 수 없다.
		map.put("아사다 마오", new Integer(60));
		map.put("소트니코바", new Integer(30));
		/*
			디자인패턴 23가지 중에서 Iterator 패턴을 사용해서 Map의 값을 출력한다.
			지금까지는 객체를 생성하라고하면 Set set = new Set();으로 만들었는데
			Set, Iterator는 이처럼 생성(생성자를 통한 생성)하지 않고
			다른 객체를 통해 리턴받는 방식으로 생성을 하고
			이를 팩토리 패턴이라고 한다.
		*/
		Set set = map.entrySet();
		// 위에서 만든 map객체를 통하여 entrySet의 메소드를 사용하여 set 객체에 그 리턴값을 넣음
		
		/* 1. Key와 Value를 동시에 출력 */
		Iterator it = set.iterator();
		// Iterator = 순환기 -- 지하철 2호선
		while (it.hasNext()) {
			// it.hasNext는 Value가 커서(Iterator) 다음에 있는지 없는지를 따져서 있으면 While-loop을 돌리고 없으면 break
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("참가자 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		// 2. Key만(<K,V>) 출력하는 경우
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		// set은 toString이 내부적으로 오버라이딩 되어 있다.
		// 따라서 set.toString하지않아도 출력된다.
		
		// 3. Value만 (<K,V>) 출력하는 경우
		Collection values = map.values();
		Iterator it2 = values.iterator();
		int total = 0;
		while (it2.hasNext()) {
			// 앱 내부에서는 int 가 기본형이라 올 수 없고
			// 반드시 Integer(기본형 int의 Wrapper 클래스) 타입으로 와야한다.
			Integer i = (Integer) it2.next();
			total += i.intValue();
		}
		System.out.println("이번 대회 평균 점수 : " + total/set.size());
		System.out.println("최고 점수 : " + Collections.max(values));
		System.out.println("최저 점수 : " + Collections.min(values));
		// 위쪽에 있는 Collection 은 인터페이스
		// 아래쪽에 있는 Collections 는 클래스
		// 클래스.메소드() 이런 형태로 나오면 이 메소드는 클래스 메소드라고 부르고
		// 다른말로는 static method라고 부른다.
	}
}
