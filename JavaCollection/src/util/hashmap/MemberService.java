package util.hashmap;
/*
 * @ Date : 2015.07.29
 * @ Author : Chae S W
 * @ Story : 로그인 회원가입등의 예제 인터페이스
 */
public interface MemberService {
//	public void join(Member member);
	public void join(String id, String name, String address, String pass, int age);
	public String login(String id, String pass);
	// 로그인은 리턴값이 있어야 함. (피드백이 있어야하기에)
}
