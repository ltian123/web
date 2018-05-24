package entity;

import java.io.Serializable;

import util.StringUtil;

public class Emp implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double salary;
	private String gender;
	private String edu;
	private String[] hobbies;
	
	public void setHob(String hobbies){
		if(hobbies!=null){
			this.hobbies=hobbies.split(",");
		}
	}
	
	public String getHob(){
		if(hobbies!=null){
			return StringUtil.arrayToString(hobbies, ",");
		}
		return null;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEdu() {
		return edu;
	}
	public void setEdu(String edu) {
		this.edu = edu;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
