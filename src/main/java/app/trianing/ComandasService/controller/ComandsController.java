package app.trianing.ComandasService.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.trianing.ComandasService.domain.ComandCard;
import app.trianing.ComandasService.domain.dto.ComandCardDTO;
import app.trianing.ComandasService.service.ComandsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ComandsController {

	private final ComandsService service;

	@PostMapping("/create")
	public ResponseEntity<ComandCard> create(@RequestBody ComandCardDTO dto) {
		log.info("ComandsController method={} Values={}", "create", dto);

		var created = service.create(dto);

		log.info("ComandsController SavedObject={}", created);

		return ResponseEntity.ok().body(created);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ComandCard> update(@PathVariable Long id, @RequestBody ComandCardDTO dto) {
		log.info("ComandsController method={} Values={}", "update", dto);

		var updated = service.update(dto, id);

		log.info("ComandsController SavedObject={}", updated);

		return ResponseEntity.ok().body(updated);
	}
	
	@GetMapping
	public ResponseEntity<Page<ComandCard>> search(ComandCardDTO dto,Pageable pageable) {
		log.info("ComandsController method={} Values={}", "search", dto);

		var comandsList = service.search(dto, pageable);

		log.info("ComandsController TotalElements={}", comandsList.getContent().size());
		
		return ResponseEntity.ok().body(comandsList);
	}
}
