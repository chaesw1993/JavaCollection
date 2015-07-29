package util.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * @ Date : 2015.07.29
 * @ Author : Chae S W
 * @ Story : 로그인 회원가입등의 예제 인터페이스를 구현한 클래스
 */
public class MemberServiceImpl implements MemberService{
	
//	Map<String, Member> map = new HashMap<String, Member>();
	Map<String, String> map = new HashMap<String, String>();
	// 위처럼 하는것이 정석이다. JSP, DB를 만지게 되면 <String, Object>가 정석이지만
	// 이 예제는 쉽게하기 위하여 <String, String>으로 한다.
	
	Member member = new Member();
	String id, pass, name, address;
	int age;
	
	@Override
	public void join(String id, String name, String address, String pass, int age) {
		member.setId(id);
		member.setAddress(address);
		member.setAge(age);
		member.setName(name);
		member.setPass(pass);
		
		map.put("id", member.getId());
		map.put("pass", member.getPass());
		map.put("name", member.getName());
		map.put("address", member.getAddress());
		map.put("age", String.valueOf(member.getAge()));	// int -> String == String.valueOf
	}

	@Override
	public String login(String id, String pass) {
		String login="";
		if (map.get("id").equals(id) &&  map.get("pass").equals(pass)) {
			login = "환영합니다." + member.getAddress() + "에 사시고 " 
					+ member.getAge() + "세 되시는"
					+ member.getName() + "님.";
		} else if(map.get("id").equals(id) &&  !map.get("pass").equals(pass)) {	// 아이디는 같은데 비밀번호가 다른경우
			login = "비밀번호가 틀렸습니다.";
		} else{
			login = "입력한 ID는 존재하지 않습니다.";
		}
		return login;
	}
}
