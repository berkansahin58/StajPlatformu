package kodlama.io.businessPlatform.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.businessPlatform.entities.concretes.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}