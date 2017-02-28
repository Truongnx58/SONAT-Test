package bean;

public class User {
	private String id;
	private String name;
	private String gender;
	private String age;
	public User(){
		this.id=null;
		this.name=null;
		this.gender=null;
		this.age=null;
	}
	public User(String id, String name, String gen, String age){
		this.id=id;
		this.name=name;
		this.gender=gen;
		this.age=age;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setGen(String gen){
		this.gender=gen;
	}
	public void setAge(String age){
		this.age=age;
	}
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getGen(){
		return this.gender;
	}
	public String getAge(){
		return this.age;
	}
}
