package kodlama.io.businessPlatform.business.abstracts;

import java.util.List;

import kodlama.io.businessPlatform.business.responses.GetAllStudentsResponse;

public interface StudentService {
	List<GetAllStudentsResponse> getAll();
}
