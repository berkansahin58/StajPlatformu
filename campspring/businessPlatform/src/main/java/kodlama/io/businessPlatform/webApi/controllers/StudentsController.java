package kodlama.io.businessPlatform.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.businessPlatform.business.abstracts.StudentService;
import kodlama.io.businessPlatform.business.responses.GetAllStudentsResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentsController {
	private StudentService studentService;
	
	@GetMapping()
	public List<GetAllStudentsResponse> getAll(){
		return studentService.getAll();
}
}