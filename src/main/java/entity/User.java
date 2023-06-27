package entity;

public class User {
	private String UserName;
	private String Messager;
	private int age;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String messager, int age) {
		super();
		UserName = userName;
		Messager = messager;
		this.age = age;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getMessager() {
		return Messager;
	}
	public void setMessager(String messager) {
		Messager = messager;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", Messager=" + Messager + ", age=" + age + "]";
	}

}
