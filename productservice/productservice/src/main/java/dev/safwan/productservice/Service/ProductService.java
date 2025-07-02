package dev.safwan.productservice.Service;

import dev.safwan.productservice.DTOs.GenericProductDTO;

public interface ProductService {
        GenericProductDTO createProduct(GenericProductDTO product);
        GenericProductDTO getProductById(String id);
}
