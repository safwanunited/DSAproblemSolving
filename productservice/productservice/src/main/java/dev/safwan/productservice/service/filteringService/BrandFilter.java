package dev.safwan.productservice.service.filteringService;

import dev.safwan.productservice.model.Product;

import java.util.List;

public class BrandFilter implements Filter{
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
    return List.of();
    }
}
