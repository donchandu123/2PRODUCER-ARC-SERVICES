package com.cjc.serviceIINTE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cjc.Model.Student;
import com.cjc.Repository.HomeRepository;

@Repository
public class ServiceImplment implements ServiceIntr {

	@Autowired
	HomeRepository hr;
	@Override
	public int saveData( Student stu) {
		 hr.save(stu);
		return 1;
	}

	@Override
	public List<Student> getAllData() {
		List<Student>list=(List<Student>) hr.findAll();
		return list;
	}

	@Override
	public Student getSingleData(String un,String pw) {
		Student list=hr.findAllByUsernameAndPassword(un, pw);
		return list;
	}

	@Override
	public int DeleteData(int rollno) {
	hr.deleteById(rollno);
		return 1;
	}

	@Override
	public Student editData(int rollno) {
		Student stu=hr.findById(rollno).get();
		return stu;
	}

	@Override
	public int updateData(Student s) {
		hr.save(s);
		return 1;
	}

}
