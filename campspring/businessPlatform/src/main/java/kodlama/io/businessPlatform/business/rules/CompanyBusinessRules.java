package kodlama.io.businessPlatform.business.rules;

import org.springframework.stereotype.Service;

import kodlama.io.businessPlatform.core.utilities.exceptions.BusinessException;
import kodlama.io.businessPlatform.dataAccess.abstracts.CompanyRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompanyBusinessRules {
	private CompanyRepository companyRepository;
	
	public void checkIfCompanyNameExists(String name) {
		if(this.companyRepository.existsByName(name)) {
			throw new BusinessException("Company name already exists"); //Java exception types
		}
	}

}
