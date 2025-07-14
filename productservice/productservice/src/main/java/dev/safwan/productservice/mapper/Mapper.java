package dev.safwan.productservice.mapper;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.model.Product;

public class Mapper {
    public static GenericProductDTO mapToDto(Product product){

        GenericProductDTO result=new GenericProductDTO();
        result.setId(product.getId());
        result.setTitle(product.getTitle());
        result.setDescription(product.getDescription());
        result.setImage(product.getImage());
        return result;

    }
}
