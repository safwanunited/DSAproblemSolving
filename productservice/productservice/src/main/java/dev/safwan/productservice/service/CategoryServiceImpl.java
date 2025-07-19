package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl  implements CategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
        List<String> categoryNames = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());

        CategoryRespDTO dto = new CategoryRespDTO();
        dto.setStatus("SUCCESS");
        dto.setMessage("WE HAVE " + categoryNames.size() + " CATEGORIES");
        dto.setCategories(categoryNames);

        return dto;
    }

}
