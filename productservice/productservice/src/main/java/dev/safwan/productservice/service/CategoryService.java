package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.dto.ProductsOfCategoryDTO;
import dev.safwan.productservice.model.Category;

public interface CategoryService {

    Category getCategory(Integer Id);

    CategoryRespDTO getAllCategroy();

    ProductsOfCategoryDTO getProductsOfCategory(String categoryType);

}
