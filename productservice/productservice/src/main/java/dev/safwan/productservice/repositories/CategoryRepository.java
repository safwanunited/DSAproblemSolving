package dev.safwan.productservice.repositories;

import dev.safwan.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Override
    Optional<Category> findById(Integer integer);
}
