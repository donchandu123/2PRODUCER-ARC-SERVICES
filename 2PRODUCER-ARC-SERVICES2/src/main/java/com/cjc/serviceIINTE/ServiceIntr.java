package com.cjc.serviceIINTE;

import java.util.List;

import com.cjc.Model.Student;

public interface ServiceIntr {

	public int saveData(Student stu);
	public List<Student> getAllData();
	public Student getSingleData(String un,String pw);
	public int DeleteData( int rollno);
	public Student editData(int rollno);
	public int updateData(Student s);
	
}
