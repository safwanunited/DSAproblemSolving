package dev.safwan.productservice.dto;

import dev.safwan.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsOfCategoryDTO {
    private String status;
    private String message;
    private List<ProductDTO>products;
}
