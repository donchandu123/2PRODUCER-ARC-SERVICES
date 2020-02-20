package com.cjc.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cjc.Model.Student;
@Service
public interface HomeRepository extends CrudRepository<Student, Integer>
{
public Student findAllByUsernameAndPassword(String un,String pw);
}
