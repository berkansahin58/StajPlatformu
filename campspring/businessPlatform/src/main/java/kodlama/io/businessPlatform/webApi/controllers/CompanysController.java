package kodlama.io.businessPlatform.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.businessPlatform.business.abstracts.CompanyService;
import kodlama.io.businessPlatform.business.requests.CreateCompanyRequest;
import kodlama.io.businessPlatform.business.requests.UpdateCompanyRequest;
import kodlama.io.businessPlatform.business.responses.GetAllCompanysResponse;
import kodlama.io.businessPlatform.business.responses.GetByIdCompanyResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/companys")
@AllArgsConstructor
public class CompanysController {
	private CompanyService companyService;

	
	@GetMapping()
	public List<GetAllCompanysResponse> getAll(){
		return companyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdCompanyResponse getById(@PathVariable int id){
		return companyService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add (@RequestBody() @Valid() CreateCompanyRequest createCompanyRequest) {
		this.companyService.add(createCompanyRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() UpdateCompanyRequest updateCompanyRequest) {
		
		this.companyService.update(updateCompanyRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.companyService.delete(id);
	}
	
	
}
