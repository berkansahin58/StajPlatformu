package kodlama.io.businessPlatform.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.businessPlatform.entities.concretes.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
