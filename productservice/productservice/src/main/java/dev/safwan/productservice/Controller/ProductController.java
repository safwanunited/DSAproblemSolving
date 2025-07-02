package dev.safwan.productservice.Controller;

import dev.safwan.productservice.DTOs.GenericProductDTO;
import dev.safwan.productservice.Service.ProductService;
import dev.safwan.productservice.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable String id){
       return productService.getProductById(id);
    }

    @PostMapping("")
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
        return  productService.createProduct(product);
    }
    
}
