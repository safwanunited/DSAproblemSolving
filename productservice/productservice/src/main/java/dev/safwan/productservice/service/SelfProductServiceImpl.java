package dev.safwan.productservice.service;


import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.dto.ProductDTO;
import dev.safwan.productservice.dto.ProductsOfCategoryDTO;
import dev.safwan.productservice.exceptions.NotFoundException;
import dev.safwan.productservice.mapper.Mapper;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Primary
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

    @Override
    public ProductsOfCategoryDTO updateProduct(ProductDTO pro) {
        int productId = pro.getId();
        Optional<Product> productDb = productRepository.findById(productId);

        if (productDb.isEmpty()) {
            return new ProductsOfCategoryDTO("FAILURE", "The ID " + productId + " is invalid", null);
        }
        Product existingProduct = productDb.get();

        if (Objects.nonNull(pro.getDescription())) {
            existingProduct.setDescription(pro.getDescription());
        }
        if (Objects.nonNull(pro.getImage())) {
            existingProduct.setImage(pro.getImage());
        }

        Product updatedProduct = productRepository.save(existingProduct);

        ProductDTO pro2 = new ProductDTO();
        pro2.setId(updatedProduct.getId());
        pro2.setDescription(updatedProduct.getDescription());
        pro2.setImage(updatedProduct.getImage());

        return new ProductsOfCategoryDTO("SUCCESS", "Product updated successfully", List.of(pro2));
    }
}
