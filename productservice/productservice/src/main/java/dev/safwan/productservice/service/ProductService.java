package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
        GenericProductDTO createProduct(GenericProductDTO product);
        GenericProductDTO getProductById(String id) throws NotFoundException;
        List<GenericProductDTO> getAllProducts();
        GenericProductDTO deleteProduct(String id);
}
