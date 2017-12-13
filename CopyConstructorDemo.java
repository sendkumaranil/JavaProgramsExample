package com.example.serialization;

public class CopyConstructorDemo {

	public static void main(String[] args) throws Exception {

		Addr add=new Addr();
		add.setCity("Bangalore");
		
		MyEmp emp1=new  MyEmp();
		emp1.setId(100);
		emp1.setName("Anil");
		emp1.setAdd(add);
		
		MyEmp emp2=new MyEmp(emp1);
		
		System.out.println("Checking for same object (emp1==emp2):"+(emp2==emp1));
				
		//changing original object state here
		emp1.setName("Kumar"); 
		add.setCity("Pune");  
		
		System.out.println(emp1); //Original object
		System.out.println(emp2); //Copied object
	}

}

class MyEmp{
	private final int orgregno=101;
	private int id;
	private String name;
	private Addr add;
	
	public MyEmp(){
		
	}
	
	public MyEmp(MyEmp myemp){
		this.id=myemp.getId();
		this.name=myemp.getName();
		this.add=new Addr(myemp.getAdd());		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Addr getAdd() {
		return add;
	}
	public void setAdd(Addr add) {
		this.add = add;
	}
	public int getOrgregno() {
		return orgregno;
	}
	@Override
	public String toString() {
		return "MyEmp [orgregno=" + orgregno + ", id=" + id + ", name=" + name
				+ ", add=" + add + "]";
	}
}

class Addr{
	
	private String city;

	public Addr(){
		
	}
	public Addr(Addr add){
		this.city=add.getCity();
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Addr [city=" + city + "]";
	}
}