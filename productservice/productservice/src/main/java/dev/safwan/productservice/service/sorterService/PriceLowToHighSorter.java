package dev.safwan.productservice.service.sorterService;

import dev.safwan.productservice.model.Product;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PriceLowToHighSorter implements Sorter {
    @Override
    public List<Product> sort(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparingDouble(
                        p -> p.getPrice() != null ? p.getPrice().getAmount() : Double.MAX_VALUE
                ))
                .collect(Collectors.toList());
    }
}
