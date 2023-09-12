package kodlama.io.businessPlatform.business.abstracts;

import java.util.List;

import kodlama.io.businessPlatform.business.requests.CreateCompanyRequest;
import kodlama.io.businessPlatform.business.requests.UpdateCompanyRequest;
import kodlama.io.businessPlatform.business.responses.GetAllCompanysResponse;
import kodlama.io.businessPlatform.business.responses.GetByIdCompanyResponse;

public interface CompanyService {
	List<GetAllCompanysResponse> getAll();
	GetByIdCompanyResponse getById(int id);
	void add(CreateCompanyRequest createCompanyRequest);
	void update(UpdateCompanyRequest updateCompanyRequest);
	void delete(int id);
}
