package co.simplon.sql_injection.mappers;

import java.util.List;

import co.simplon.sql_injection.dtos.ProductDto;
import co.simplon.sql_injection.entities.Product;

public class ProductMapper {

	public static List<ProductDto> entitiesToDtos(List<Product> products) {
		return products.stream().map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice())).toList();
	}

	public static ProductDto entityToDtos(Product product) {
		return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}
}
