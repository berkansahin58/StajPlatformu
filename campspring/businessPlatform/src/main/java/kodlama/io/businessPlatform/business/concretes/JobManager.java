package kodlama.io.businessPlatform.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.businessPlatform.business.abstracts.JobService;
import kodlama.io.businessPlatform.business.requests.CreateJobRequest;
import kodlama.io.businessPlatform.business.responses.GetAllJobsResponse;
import kodlama.io.businessPlatform.core.utilities.mappers.ModelMapperService;
import kodlama.io.businessPlatform.dataAccess.abstracts.JobRepository;
import kodlama.io.businessPlatform.entities.concretes.Job;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JobManager implements JobService{
	
	private JobRepository jobRepository;
	private ModelMapperService modelMapperService;

	
	@Override
	public List<GetAllJobsResponse> getAll() {
		List<Job> jobs = jobRepository.findAll();
		
		List<GetAllJobsResponse> jobsResponse = jobs.stream()
				.map(job->this.modelMapperService.forResponse()
						.map(job, GetAllJobsResponse.class)).collect(Collectors.toList());
		
		return jobsResponse;
		
	}


	@Override
	public void add(CreateJobRequest createJobRequest) {
		Job job = this.modelMapperService.forRequest().map(createJobRequest,Job.class); 
		
		this.jobRepository.save(job);
		
	}

}
