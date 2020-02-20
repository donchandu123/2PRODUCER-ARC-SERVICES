package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.Model.Student;
import com.cjc.serviceIINTE.ServiceIntr;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin("*")
@RestController
public class HomeController {

	@Autowired
	ServiceIntr si;
	
	ObjectMapper obj=new ObjectMapper();
	
	@RequestMapping(value = "/log/{username}/{password}",method = RequestMethod.GET)
	public String login(@PathVariable String username,@PathVariable String password) throws JsonProcessingException
	{
		List<Student>list1=si.getAllData();
		String list=obj.writeValueAsString(list1);
		return list;
	}
	
	@RequestMapping(value ="/reg",produces ="application/json",method = RequestMethod.POST)

	public String registerData(@RequestBody Student st)
	{

		si.saveData(st);
		
		return "successfully saved"  ;
		
	}
	
	@RequestMapping(value = "/getAllData",produces= "application/json",method =RequestMethod.GET)
	public List<Student> getAllData() throws JsonProcessingException
	{
		List<Student>list=si.getAllData();
		
		String s=obj.writeValueAsString(list);
		return list;
	}
	
	@RequestMapping(value = "/getSingelData/{username}/{password}",produces= "application/json",method =RequestMethod.GET)
	public Student getSingleData(@PathVariable("username")String un,@PathVariable("password")String pw) throws JsonProcessingException
	{
		Student list=si.getSingleData(un, pw);
		ObjectMapper obj=new ObjectMapper();
		String s=obj.writeValueAsString(list);
		return list;
		
	}
	
	  @RequestMapping(value = "/Delete/{rollno}",produces="application/json")  
	  public String deleteData(@PathVariable int rollno) throws JsonProcessingException
	  {
		  System.out.println("in delet producer");
		  si.DeleteData(rollno);
		  List<Student>list1=si.getAllData();
		  String list=obj.writeValueAsString(list1);
	      return list;
	  }
	  
	  

  @RequestMapping(value = "/editData/{rollno}",produces="application/json",method =RequestMethod.GET) 
  public String editD(@PathVariable("rollno")int rollno) throws JsonProcessingException 
  {
	  Student stu=si.editData(rollno);
	  String stu1=obj.writeValueAsString(stu);
	  return stu1 ; 
  
  }

  @RequestMapping(value = "updateD",produces="application/json",method =RequestMethod.PUT)
  public String updateData(@RequestBody Student s)
  {
	  si.updateData(s);
	return "Data updated successfully";
  }
  
  }
 
