package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
        GenericProductDTO createProduct(GenericProductDTO product);
        GenericProductDTO getProductById(Integer id) throws NotFoundException;
        List<GenericProductDTO> getAllProducts();
        GenericProductDTO deleteProduct(Integer id);
}
