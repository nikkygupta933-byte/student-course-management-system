package com.student.crud.entity;
import jakarta.persistence.*;
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="studentGroup")
	private String studentGroup;
	
	@Column(name="course")
	private String course;
	
	@Column(name="age")
	private Integer age;
	public Student() {}
	public Student(String name, String studentGroup, String course, Integer age) {
		this.name=name;
		this.studentGroup=studentGroup;
		this.course=course;
		this.age=age;
		}
	public Student( long id,String name, String studentGroup, String course, Integer age) {
		this.id=id;
		this.name=name;
		this.studentGroup=studentGroup;
		this.course=course;
		this.age=age;
		}
	public void setId(long id) {
	this.id=id;
	}
	public long getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void  setStudentGroup(String studentGroup) {
		this.studentGroup=studentGroup;
	}
	public String getStudentGroup() {
		return studentGroup;
	}
	public void setCourse(String course) {
		this.course=course;
	}
	public  String getCourse() {
		return course;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	public Integer getAge() {
		return age;	
	}
	
	
	
	

	
	
	
	

}
