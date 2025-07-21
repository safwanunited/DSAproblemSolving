package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.CategoryRespDTO;
import dev.safwan.productservice.dto.ProductsOnCategory;
import dev.safwan.productservice.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(Integer Id);

    CategoryRespDTO getAllCategroy();

    ProductsOnCategory getProductsOfCategory();

}
