package dev.safwan.productservice.repositories;

import dev.safwan.productservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
