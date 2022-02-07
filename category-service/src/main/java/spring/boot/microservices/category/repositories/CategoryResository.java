package spring.boot.microservices.category.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.boot.microservices.category.entities.Category;

@Repository
public interface CategoryResository extends JpaRepository<Category, Long>{

}
