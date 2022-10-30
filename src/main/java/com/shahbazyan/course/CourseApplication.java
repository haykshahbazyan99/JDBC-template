package com.shahbazyan.course;

import com.shahbazyan.course.dao.DAO;
import com.shahbazyan.course.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CourseApplication {

	private static DAO<Course> dao;

	public CourseApplication(DAO<Course> dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);



//		List<Course> courses = dao.list();
//		courses.forEach(System.out::println);


//
//		Course course = new Course("My course", "New course", "www.www.www");
//		dao.create(course);



		dao.delete(1);

	}

}
