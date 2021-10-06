package app.trianing.ComandasService.domain.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

	private Long id;
	
	private String name;
	
	private Long cpf;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
}
