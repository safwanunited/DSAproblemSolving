package dev.safwan.productservice.repositories;

public interface CustomRepository {
    String FIND_ALL_BY_TITLE = "select * from product join product_orders " +
            "on product.id = product_orders.product_id where title = :test";
}
