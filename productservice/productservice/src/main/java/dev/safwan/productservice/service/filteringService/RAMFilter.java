package dev.safwan.productservice.service.filteringService;

import dev.safwan.productservice.model.Product;
import java.util.List;
import java.util.stream.Collectors;

public class RAMFilter implements Filter {
    @Override
    public List<Product> apply(List<Product> products, List<String> values) {
        return products.stream()
                .filter(p -> values.contains(String.valueOf(p.getInventoryCount())))
                .collect(Collectors.toList());
    }
}
