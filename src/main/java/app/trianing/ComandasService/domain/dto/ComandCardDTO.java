package app.trianing.ComandasService.domain.dto;

import java.util.Set;

import app.trianing.ComandasService.domain.Products;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComandCardDTO {

	private Long id;
	
	private String name;
	
	private Set<Products> products;
	
}
