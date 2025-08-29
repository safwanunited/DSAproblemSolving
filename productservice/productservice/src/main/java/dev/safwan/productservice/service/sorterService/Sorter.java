package dev.safwan.productservice.service.sorterService;

import dev.safwan.productservice.model.Product;

import java.util.List;

public interface Sorter {
    List<Product>sort(List<Product>products);
}