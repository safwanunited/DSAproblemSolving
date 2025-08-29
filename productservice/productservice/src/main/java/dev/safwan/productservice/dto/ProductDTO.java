package dev.safwan.productservice.dto;

import dev.safwan.productservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String title;
    private String description;
    private String image;
    private String categoryName;

    public ProductDTO(Product product) {
        if (product == null) return;
        Integer pid = product.getId();
        this.id = pid == null ? 0 : pid;
        this.title = product.getTitle();
        this.description = product.getDescription();
        this.image = product.getImage();
        this.categoryName = product.getCategory() == null ? null : product.getCategory().getName();
    }
}