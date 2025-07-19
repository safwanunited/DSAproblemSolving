package dev.safwan.productservice.dto;

import dev.safwan.productservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRespDTO {
    private String status;
    private String message;
    private List<String> categories;
}
