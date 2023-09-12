package kodlama.io.businessPlatform.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.businessPlatform.business.abstracts.JobService;
import kodlama.io.businessPlatform.business.requests.CreateJobRequest;
import kodlama.io.businessPlatform.business.responses.GetAllJobsResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/jobs")
@AllArgsConstructor
public class JobsController {
	private JobService jobService;	
	
	@GetMapping()
	public List<GetAllJobsResponse> getAll(){
		return jobService.getAll();
}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add (@RequestBody() @Valid() CreateJobRequest createJobRequest) {
		this.jobService.add(createJobRequest);
	}



}