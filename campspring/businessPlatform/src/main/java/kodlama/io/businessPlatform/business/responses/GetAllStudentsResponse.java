package kodlama.io.businessPlatform.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStudentsResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private String country;
	private String university;
	private String department;
	private int phoneNumber;
}
