package co.simplon.sql_injection.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.sql_injection.dtos.ProductDto;
import co.simplon.sql_injection.mappers.ProductMapper;
import co.simplon.sql_injection.repositories.CustomRepository;

@Service
public class ProductService {

	CustomRepository repo;

	public ProductService(CustomRepository repo) {
		this.repo = repo;
	}

	public List<ProductDto> get() {
		return ProductMapper.entitiesToDtos(repo.getProducts());
	}

	public ProductDto get(String id) {
		return ProductMapper.entityToDtos(repo.getProducts(id));
	}

}
