package kodlama.io.businessPlatform.business.abstracts;

import java.util.List;

import kodlama.io.businessPlatform.business.requests.CreateJobRequest;
import kodlama.io.businessPlatform.business.responses.GetAllJobsResponse;

public interface JobService {
	List<GetAllJobsResponse> getAll();
	void add(CreateJobRequest createJobRequest);
}
