package spring.boot.microservices.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import spring.boot.microservices.product.repositories.ProductRepository;
import spring.boot.microservices.product.services.exceptions.DataIntegrityException;
import spring.boot.microservices.product.services.exceptions.ObjectNotFoundException;
import spring.boot.microservices.productservice.entities.Product;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		List<Product> list = repository.findAll();
		return list;
	}
	
	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public Product insert(Product product) {
		return repository.save(product);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException  e) {
			throw new DataIntegrityException("Cannot delete a category that contains products");
		}
		catch(RuntimeException e) {
			throw new ObjectNotFoundException("Object not found. Id: " + id);
		}
	}
	
	public Product update(Product product) {
			Product newProduct = new Product();
			updateData(product, newProduct);
			repository.save(newProduct);
			return newProduct;
	}

	private void updateData(Product product, Product newProduct) {
		newProduct.setName(product.getName());
		newProduct.setPrice(product.getPrice());
	}
}
