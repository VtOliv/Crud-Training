package app.trianing.ComandasService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import app.trianing.ComandasService.domain.ComandCard;
import app.trianing.ComandasService.domain.dto.ComandCardDTO;
import app.trianing.ComandasService.repository.ComandsRepository;
import app.trianing.ComandasService.util.Conditions;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ComandsService extends Conditions<ComandCard> {

	private final ComandsRepository repository;

	public ComandCard create(ComandCardDTO dto) {

		var card = ComandCard.builder().name(dto.getName()).productCode(dto.getProducts()).build();

		return repository.save(card);
	}
	
	public ComandCard update(ComandCardDTO dto, Long id) {
		var card = repository.findById(id);
		
		if(card.isPresent()) {
			var item = card.get();
			
			item.setName(dto.getName());
			item.setProductCode(dto.getProducts());
			
			return repository.save(item);
		} else {
			return null;
		}
	}
	
	public Page<ComandCard> search(ComandCardDTO dto, Pageable pageable) {
		return repository.findAll(Specification.where(equals("id", dto.getId()))
				.and(like("name", dto.getName())), pageable);
	}
}