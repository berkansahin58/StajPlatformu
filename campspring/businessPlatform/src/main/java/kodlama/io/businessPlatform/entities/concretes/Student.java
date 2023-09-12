package kodlama.io.businessPlatform.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="country")
	private String country;
	
	@Column(name="university")
	private String university;
	
	@Column(name="department")
	private String department;
	
	@Column(name="phoneNumber")
	private int phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "jobs_id")
	private Job jobs;
}
