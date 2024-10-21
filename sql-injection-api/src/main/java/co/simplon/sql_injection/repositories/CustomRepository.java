package co.simplon.sql_injection.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.simplon.sql_injection.dtos.LoginDto;
import co.simplon.sql_injection.entities.Product;
import co.simplon.sql_injection.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CustomRepository {

	@PersistenceContext
	EntityManager entityManager;

	public User login(LoginDto input) {
		String QUERY = "SELECT * FROM users WHERE user_name ='" + input.userName() + "' AND user_password = '" + input.password() + "';";
		return (User) entityManager.createNativeQuery(QUERY, User.class).getSingleResult();
	}

	public List<Product> getProducts() {
		String QUERY = "SELECT * FROM products";
		return entityManager.createNativeQuery(QUERY, Product.class).getResultList();
	}

	public Product getProduct(String id) {
		String QUERY = "SELECT * FROM products WHERE id = " + id;
		return (Product) entityManager.createNativeQuery(QUERY, Product.class).getSingleResult();
	}

}
