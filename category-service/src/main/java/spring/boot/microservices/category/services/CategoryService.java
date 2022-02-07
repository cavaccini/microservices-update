package spring.boot.microservices.category.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import spring.boot.microservices.category.entities.Category;
import spring.boot.microservices.category.repositories.CategoryResository;
import spring.boot.microservices.category.services.exceptions.DataIntegrityException;
import spring.boot.microservices.category.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryResository repository;
	
	public List<Category> findAll(){
		List<Category> list = repository.findAll();
		return list;
	}
	
	public Category findById(Long id) {
		Optional<Category> category = repository.findById(id);
		return category.orElseThrow(() ->  new ObjectNotFoundException(id));
	}
	
	public Category insert(Category category) {
		return repository.save(category);
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
	
	public Category update(Category category) {
		Category newCategory = findById(category.getId());
		updateDate(category, newCategory);
		return repository.save(newCategory);
	}

	private void updateDate(Category category, Category newCategory) {
		newCategory.setName(category.getName());
	}
}
