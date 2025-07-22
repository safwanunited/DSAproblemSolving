package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.dto.ProductDTO;
import dev.safwan.productservice.dto.ProductsOfCategoryDTO;
import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.CategoryRepository;
import dev.safwan.productservice.repositories.PriceRepository;
import dev.safwan.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CategoryServiceImpl  implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository,
                               PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public Category getCategory(Integer Id) {
         Optional<Category> categoryOptional=categoryRepository.findById(Id);

         if(categoryOptional.isEmpty()){
             return null;
         }
         Category category=categoryOptional.get();
         List<Product> products=category.getProducts();
        return category;
    }

    @Override
    public CategoryRespDTO getAllCategroy() {
        List<Category> categories = categoryRepository.findAll();
       List<String>categoryNames=categories.stream().map(Category::getName).collect(Collectors.toList());

        CategoryRespDTO dto = new CategoryRespDTO();
        dto.setStatus("SUCCESS");
        dto.setMessage("WE HAVE " + categoryNames.size() + " CATEGORIES");
        dto.setCategories(categoryNames);

        return dto;
    }

    @Override
    public ProductsOfCategoryDTO getProductsOfCategory(String categoryType) {
        Optional<Category> categoryOpt = categoryRepository.findByName(categoryType);

        if (categoryOpt.isEmpty()) {
            System.out.println("Category not found");
            return new ProductsOfCategoryDTO("Failure", "Category not found", null);
        }

        Category category = categoryOpt.get();
        int categoryId = category.getId();
        System.out.println("Category ID found: " + categoryId);

        List<Product> productsOfCategory = productRepository.findAllByCategoryId(categoryId);

        List<ProductDTO> dtos = productsOfCategory.stream()
                .map(p -> new ProductDTO(
                        p.getId(),
                        p.getTitle(),
                        p.getDescription(),
                        p.getImage(),
                        p.getCategory().getName()
                ))
                .collect(Collectors.toList());

        if (!dtos.isEmpty()) {
            System.out.println(dtos.get(0));
        }
        return new ProductsOfCategoryDTO("Success", "Products Found", dtos);
    }

}
