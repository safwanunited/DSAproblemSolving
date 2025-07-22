package dev.safwan.productservice.controller;


import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.dto.ProductDTO;
import dev.safwan.productservice.dto.ProductsOfCategoryDTO;
import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{Id}")
    public Category getCategory(@PathVariable Integer Id){
        return categoryService.getCategory(Id);
    }

    @GetMapping
    public ResponseEntity<?>getAllCatgory(){
       CategoryRespDTO result= categoryService.getAllCategroy();
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);

    }
    @GetMapping("/by-name/{type}")
    public ResponseEntity<?>getProductsOfCategory(@PathVariable String type){
            ProductsOfCategoryDTO result=categoryService.getProductsOfCategory(type);
        return ResponseEntity.ok(result);
    }

}
