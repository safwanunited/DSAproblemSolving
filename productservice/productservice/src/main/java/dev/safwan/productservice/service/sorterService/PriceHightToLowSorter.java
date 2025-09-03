package dev.safwan.productservice.service.sorterService;

import dev.safwan.productservice.model.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceHightToLowSorter implements Sorter {

    @Override
    public List<Product> sort(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                double price1 = p1.getPrice() != null ? p1.getPrice().getAmount() : Double.MIN_VALUE;
                double price2 = p2.getPrice() != null ? p2.getPrice().getAmount() : Double.MIN_VALUE;

                return Double.compare(price2, price1);
            }
        });
        return products;
    }
}
