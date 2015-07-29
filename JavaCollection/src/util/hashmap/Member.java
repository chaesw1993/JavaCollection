package util.hashmap;
/*
 * @ Date : 2015.07.29
 * @ Author : Chae S W
 * @ Story : 로그인 회원가입등의 예제 객체클래스
 */
public class Member {
	private String id, name, address, pass;
	private int age;
	
	public Member() {}
	public Member(String id, String name, String address, String pass, int age) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.pass = pass;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPass() {
		return pass;
	}
	public int getAge() {
		return age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "ID : " + this.id + "\n"
				+ "PASSWORD : " + this.pass + "\n"
				+ "NAME : " + this.name + "\n"
				+ "AGE : " + this.age + "\n"
				+ "ADDRESS : " + this.address; 
	}
}
