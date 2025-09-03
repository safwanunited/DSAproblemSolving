package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.search.FilterDto;
import dev.safwan.productservice.dto.search.SortingCriteria;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.repositories.ProductRepository;
import dev.safwan.productservice.service.filteringService.FilterFactory;
import dev.safwan.productservice.service.sorterService.SorterFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(
            String query,
            List<FilterDto> filters,
            SortingCriteria sortingCriteria,
            int pageNumber,
            int pageSize
    ) {
        List<Product> products = productRepository.findByTitleContainingIgnoreCase(query);

        for (FilterDto filterDto : filters) {
            products = FilterFactory.getFilterFromKey(filterDto.getKey())
                    .apply(products, filterDto.getValues());
        }

        products = SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);

        int start = Math.min(pageSize * (pageNumber - 1), products.size());
        int end = Math.min(start + pageSize, products.size());
        List<Product> productsOnPage = products.subList(start, end);

        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize); // 0-based
        return new PageImpl<>(productsOnPage, pageable, products.size());
    }
}
