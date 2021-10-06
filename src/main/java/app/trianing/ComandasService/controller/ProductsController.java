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

import app.trianing.ComandasService.domain.Products;
import app.trianing.ComandasService.domain.dto.ProductsDTO;
import app.trianing.ComandasService.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductsController {

	private final ProductService service;

	@PostMapping("/product/create")
	public ResponseEntity<Products> create(@RequestBody ProductsDTO dto) {
		log.info("ProductsController method={} Values={}", "create", dto);

		var created = service.create(dto);

		log.info("ProductsController SavedObject={}", created);

		return ResponseEntity.ok().body(created);
	}

	@PutMapping("product/update/{id}")
	public ResponseEntity<Products> update(@PathVariable Long id, @RequestBody ProductsDTO dto) {
		log.info("ProductsController method={} Values={}", "update", dto);

		var updated = service.update(dto, id);

		log.info("ProductsController SavedObject={}", updated);

		return ResponseEntity.ok().body(updated);
	}
	
	@GetMapping("/products")
	public ResponseEntity<Page<Products>> search(ProductsDTO dto,Pageable pageable) {
		log.info("ProductsController method={} Values={}", "search", dto);

		var comandsList = service.search(dto, pageable);

		log.info("ProductsController TotalElements={}", comandsList.getContent().size());
		
		return ResponseEntity.ok().body(comandsList);
	}
}
