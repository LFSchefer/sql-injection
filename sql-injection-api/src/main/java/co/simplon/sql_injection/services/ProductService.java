package co.simplon.sql_injection.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.sql_injection.dtos.ProductDto;
import co.simplon.sql_injection.entities.Product;
import co.simplon.sql_injection.repositories.CustomRepository;

@Service
public class ProductService {

	CustomRepository repo;

	public ProductService(CustomRepository repo) {
		this.repo = repo;
	}

	public List<ProductDto> getProducts() {
		List<Product> products = repo.getProducts();
		return products.stream().map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice())).toList();
	}

	public ProductDto getProduct(String id) {
		Product product = repo.getProduct(id);
		return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

}
