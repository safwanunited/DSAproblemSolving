package dev.safwan.productservice.service;


import dev.safwan.productservice.dto.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class SelfProductServiceImpl implements ProductService{
    public GenericProductDTO getProductById(String id){
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public GenericProductDTO deleteProduct(String id) {
        return null;
    }
}
