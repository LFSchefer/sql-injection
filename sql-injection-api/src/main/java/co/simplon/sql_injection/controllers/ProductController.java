package co.simplon.sql_injection.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.sql_injection.dtos.ProductDto;
import co.simplon.sql_injection.services.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

	ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> get() {
		return ResponseEntity.ok(service.get());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.get(id));
	}

}
