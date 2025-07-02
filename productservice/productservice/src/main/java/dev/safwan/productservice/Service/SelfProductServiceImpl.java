package dev.safwan.productservice.Service;


import dev.safwan.productservice.DTOs.GenericProductDTO;
import org.springframework.stereotype.Service;

@Service("productService")
public class SelfProductServiceImpl implements ProductService{
    public GenericProductDTO getProductById(String id){
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return null;
    }
}
