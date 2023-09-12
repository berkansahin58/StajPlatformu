package kodlama.io.businessPlatform.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.businessPlatform.business.abstracts.CompanyService;
import kodlama.io.businessPlatform.business.requests.CreateCompanyRequest;
import kodlama.io.businessPlatform.business.requests.UpdateCompanyRequest;
import kodlama.io.businessPlatform.business.responses.GetAllCompanysResponse;
import kodlama.io.businessPlatform.business.responses.GetByIdCompanyResponse;
import kodlama.io.businessPlatform.business.rules.CompanyBusinessRules;
import kodlama.io.businessPlatform.core.utilities.mappers.ModelMapperService;
import kodlama.io.businessPlatform.dataAccess.abstracts.CompanyRepository;
import kodlama.io.businessPlatform.entities.concretes.Company;
import lombok.AllArgsConstructor;

@Service //Bu sınıf bir business nesnesidir
@AllArgsConstructor
public class CompanyManager implements CompanyService{
	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;
	private CompanyBusinessRules companyBusinessRules;
	
	@Override
	public List<GetAllCompanysResponse> getAll() {
		
		List<Company> companys = companyRepository.findAll();
		
		List<GetAllCompanysResponse> companysResponse = companys.stream()
				.map(company->this.modelMapperService.forResponse()
						.map(company, GetAllCompanysResponse.class)).collect(Collectors.toList());
		
		return companysResponse;
	}

	@Override
	public void add(CreateCompanyRequest createCompanyRequest) {
		
		this.companyBusinessRules.checkIfCompanyNameExists(createCompanyRequest.getName());
		
		Company company = this.modelMapperService.forRequest().map(createCompanyRequest,Company.class); 
		
		this.companyRepository.save(company);
		
	}

	@Override
	public GetByIdCompanyResponse getById(int id) {
		Company company = this.companyRepository.findById(id).orElseThrow();
		
		GetByIdCompanyResponse response 
		= this.modelMapperService.forResponse().map(company, GetByIdCompanyResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateCompanyRequest updateCompanyRequest) {
		Company company = this.modelMapperService.forRequest().map(updateCompanyRequest,Company.class);
		this.companyRepository.save(company);
		
	}

	@Override
	public void delete(int id) {
		
		this.companyRepository.deleteById(id);
		
	}

}
