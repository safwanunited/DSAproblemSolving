package dev.safwan.productservice.service;


import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;
import dev.safwan.productservice.mapper.Mapper;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("productService")
public class SelfProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        Product c=new Product();
        c.setTitle(product.getTitle());
        c.setDescription(product.getDescription());
        c.setImage(product.getImage());
        Product result=productRepository.save(c);
        System.out.println(result.getId());
        return Mapper.mapToDto(result);
    }


    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<Product> allProducts=productRepository.findAll();
        return allProducts.stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public GenericProductDTO getProductById(Integer id) throws NotFoundException {
        return null;
    }

    @Override
    public GenericProductDTO deleteProduct(Integer id) {
        Product proToBeRemoved=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
        productRepository.delete(proToBeRemoved);
        return Mapper.mapToDto(proToBeRemoved);
    }
}
