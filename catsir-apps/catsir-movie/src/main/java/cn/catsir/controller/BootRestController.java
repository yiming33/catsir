package cn.catsir.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YiMing on 2017/7/12.
 */
@RestController
@RequestMapping("/")
public class BootRestController {
//
//	@Autowired
//	private RedisCacheService redisCacheService;

	// @Autowired
	// private StudentService studentService;

	@RequestMapping("/")
	public String hello() {
		return "hello world";
	}

//	@RequestMapping("/student")
//	public Student student() {
//		Student student = new Student();
//		student.setId(5);
//		student.setName("易明6");
//		student.setAge(22);
//		int a = studentService.add(student);
//		return student;
//	}

//	@RequestMapping("/findAll")
//	public List<Student> findAll(int page) {
////		PageHelper.startPage(page, 2);
////		List<Student> students = studentService.findAll();
////		Student student = studentService.findOne(1l);
////		redisCacheService.save("11", "22");
////		String a = (String) redisCacheService.findOne("11");
//		return students;
//	}

}
