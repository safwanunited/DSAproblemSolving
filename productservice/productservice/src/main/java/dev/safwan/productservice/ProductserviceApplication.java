package dev.safwan.productservice;

import dev.safwan.productservice.model.Category;
import dev.safwan.productservice.model.Order;
import dev.safwan.productservice.model.Price;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.CategoryRepository;
import dev.safwan.productservice.repositories.OrderRepository;
import dev.safwan.productservice.repositories.PriceRepository;
import dev.safwan.productservice.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
@SpringBootApplication
public class ProductserviceApplication{
//	implements CommandLineRunner {

//	private final ProductRepository productRepository;
//	public ProductserviceApplication(ProductRepository productRepository,
//									 CategoryRepository categoryRepository,
//									 PriceRepository priceRepository) {
//		this.productRepository = productRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

//	@Override
//	public void run(String... args) {
//		// --- Create & Save Categories ---
//		Category mobileCategory = new Category("Mobiles");
//		Category laptopCategory = new Category("Laptops");
//		Category accessoryCategory = new Category("Accessories");
//
//		// --- Create & Save Prices ---
//		Price price1 = new Price("Rupee", 79999);
//		Price price2 = new Price("Rupee", 59999);
//		Price price3 = new Price("Rupee", 2499);
//		Price price4 = new Price("Rupee", 89999);
//		Price price5 = new Price("Rupee", 14999);
//		Price price6 = new Price("Rupee", 499);
//
//		// --- Create Products with All Fields ---
//		Product p1 = new Product("iPhone 15 Pro", "Latest iPhone with A17 Pro chip", "iphone.jpg", mobileCategory, price1, 100, 1);
//		Product p2 = new Product("Samsung Galaxy S24", "Flagship Android phone", "samsung.jpg", mobileCategory, price2, 90, 1);
//		Product p3 = new Product("AirPods Pro", "Wireless earbuds with ANC", "airpods.jpg", accessoryCategory, price3, 150, 1);
//		Product p4 = new Product("MacBook Air M2", "Lightweight and powerful", "macbook.jpg", laptopCategory, price4, 60, 1);
//		Product p5 = new Product("Dell XPS 13", "Premium ultrabook with Intel", "dell.jpg", laptopCategory, price5, 50, 1);
//		Product p6 = new Product("iPhone Case", "Protective silicon case", "case.jpg", accessoryCategory, price6, 300, 1);
//
//		// --- Save All Products ---
//		productRepository.saveAll(List.of(p1, p2, p3, p4, p5, p6));
//
//		System.out.println("✅ Seeded 3 categories, 6 prices, and 6 products with inventory fields.");
//	}
}
