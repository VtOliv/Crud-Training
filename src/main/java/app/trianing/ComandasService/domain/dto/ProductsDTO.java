package app.trianing.ComandasService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProductsDTO {
	
	private Long code;
	
	private String description;
	
}
