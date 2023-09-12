package kodlama.io.businessPlatform.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.businessPlatform.business.abstracts.StudentService;
import kodlama.io.businessPlatform.business.responses.GetAllStudentsResponse;
import kodlama.io.businessPlatform.core.utilities.mappers.ModelMapperService;
import kodlama.io.businessPlatform.dataAccess.abstracts.StudentRepository;
import kodlama.io.businessPlatform.entities.concretes.Student;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentManager implements StudentService{
	
	private StudentRepository studentRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllStudentsResponse> getAll() {
		List<Student> students = studentRepository.findAll();
		
		List<GetAllStudentsResponse> studentsResponse = students.stream()
				.map(student->this.modelMapperService.forResponse()
						.map(student, GetAllStudentsResponse.class)).collect(Collectors.toList());
		
		return studentsResponse;
	}

}
