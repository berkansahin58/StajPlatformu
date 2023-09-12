package kodlama.io.businessPlatform.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.businessPlatform.entities.concretes.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{
	boolean existsByName(String name); //spring jpa keywords(existsByName) true yada false döner
}
