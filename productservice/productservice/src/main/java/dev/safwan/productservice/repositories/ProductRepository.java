package dev.safwan.productservice.repositories;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByTitle(String Title);
    List<Product> findAllByTitleLike(String titleRegex);
}
