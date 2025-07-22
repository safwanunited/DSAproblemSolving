package dev.safwan.productservice.repositories;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByTitle(String Title);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Integer categoryId);
    List<Product> findAllByTitleLike(String titleRegex);

    @Query(value = CustomRepository.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String naman);

    List<Product> findAllByCategoryIn(List<Category> categories);

}
