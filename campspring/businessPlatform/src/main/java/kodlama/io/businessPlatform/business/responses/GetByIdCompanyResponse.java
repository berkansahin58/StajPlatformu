package kodlama.io.businessPlatform.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCompanyResponse {
	private int id;
	private String name;
}
