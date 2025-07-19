package dev.safwan.productservice;

import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Order;
import dev.safwan.productservice.model.Price;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.CategoryRepository;
import dev.safwan.productservice.repositories.OrderRepository;
import dev.safwan.productservice.repositories.PriceRepository;
import dev.safwan.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner loadData(
//			CategoryRepository categoryRepository,
//			ProductRepository productRepository,
//			PriceRepository priceRepository,
//			OrderRepository orderRepository
//	) {
//		return args -> {
//			// --- Create and Save Categories First ---
//			Category electronics = categoryRepository.save(new Category("Electronics"));
//			Category books = categoryRepository.save(new Category("Books"));
//			Category furniture = categoryRepository.save(new Category("Furniture"));
//
//			// --- Create and Save Prices ---
//			Price price1 = priceRepository.save(new Price(199.99, "USD"));
//			Price price2 = priceRepository.save(new Price(199.99, "USD"));
//			Price price3 = priceRepository.save(new Price(89.99, "USD"));
//			Price price4 = priceRepository.save(new Price(15.99, "USD"));
//			Price price5 = priceRepository.save(new Price(499.99, "USD"));
//			Price price6 = priceRepository.save(new Price(39.49, "USD"));
//
////			 --- Create Products using saved Category and Price entities ---
////			Category electronics = new Category("Electronics");
////			Category furniture = new Category("Furniture");
////			Category books = new Category("Books");
////			Price price1 = new Price(199.99, "USD");
////			Price price2 = new Price(199.99, "USD");
////			Price price3 = new Price(89.99, "USD");
////			Price price4 = new Price(15.99, "USD");
////			Price price5 = new Price(499.99, "USD");
////			Price price6 = new Price(39.49, "USD");
//
//			Product p1 = new Product("Wireless Mouse", "Ergonomic mouse", "mouse.jpg", electronics, price1, 100);
//			Product p2 = new Product("Mechanical Keyboard", "RGB backlit keyboard", "keyboard.jpg", electronics, price2, 50);
//			Product p3 = new Product("Bookshelf", "Wooden 5-tier bookshelf", "shelf.jpg", furniture, price3, 25);
//			Product p4 = new Product("Java Book", "Learn Java programming", "java.jpg", books, price4, 200);
//			Product p5 = new Product("Office Chair", "Ergonomic mesh office chair", "chair.jpg", furniture, price5, 15);
//			Product p6 = new Product("Notebook", "A5 size ruled notebook", "notebook.jpg", books, price6, 300);
//
//			productRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6));
//
//			// --- Create Orders using saved Products ---
//			Order order1 = new Order();
//			order1.setProducts(List.of(p1, p2, p4));
//
//			Order order2 = new Order();
//			order2.setProducts(List.of(p3, p5, p6));
//
//			orderRepository.saveAll(List.of(order1, order2));
//
//			System.out.println("✅ Seeded categories, prices, products, and orders.");
//		};
//	}

}
