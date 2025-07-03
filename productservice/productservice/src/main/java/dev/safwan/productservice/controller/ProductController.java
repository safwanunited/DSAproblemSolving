package dev.safwan.productservice.controller;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;
import dev.safwan.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable String id) throws NotFoundException {
       return productService.getProductById(id);
    }

    @PostMapping("")
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
        return  productService.createProduct(product);
    }

    @GetMapping("")
    public List<GenericProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProduct(@PathVariable String id){
        return productService.deleteProduct(id);
    }
    
}
