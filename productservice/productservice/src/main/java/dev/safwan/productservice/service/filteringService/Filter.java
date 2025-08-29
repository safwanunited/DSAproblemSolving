package dev.safwan.productservice.service.filteringService;

import dev.safwan.productservice.model.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,List<String>allowedValues);
}
