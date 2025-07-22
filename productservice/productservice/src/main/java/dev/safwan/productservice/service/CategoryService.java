package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.dto.ProductDTO;
import dev.safwan.productservice.dto.ProductsOfCategoryDTO;
import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Product;

public interface CategoryService {

    Category getCategory(Integer Id);

    CategoryRespDTO getAllCategroy();

    ProductsOfCategoryDTO getProductsOfCategory(String categoryType);
}
