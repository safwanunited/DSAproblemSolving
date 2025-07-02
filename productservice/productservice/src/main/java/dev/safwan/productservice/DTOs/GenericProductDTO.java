package dev.safwan.productservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericProductDTO {
    private Integer id;
    private String title;
    private Float  price;
    private String description;
    private String category;
    private String image;
}
