package app.trianing.ComandasService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import app.trianing.ComandasService.domain.Products;
import app.trianing.ComandasService.domain.dto.ProductsDTO;
import app.trianing.ComandasService.repository.ProductRepository;
import app.trianing.ComandasService.util.Conditions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService extends Conditions<Products> {

	private final ProductRepository repository;
	
	public Products create(ProductsDTO dto) {

		var card = Products.builder().description(dto.getDescription()).build();

		return repository.save(card);
	}
	
	public Products update(ProductsDTO dto, Long id) {
		var card = repository.findById(id);
		
		if(card.isPresent()) {
			var item = card.get();
			
			item.setDescription(dto.getDescription());
			
			return repository.save(item);
		} else {
			return null;
		}
	}
	
	public Page<Products> search(ProductsDTO dto, Pageable pageable) {
		return repository.findAll(Specification.where(equals("id", dto.getCode()))
				.and(like("description", dto.getDescription())), pageable);
	}
}
