package dev.safwan.productservice.controller;

import dev.safwan.productservice.dto.ProductDTO;
import dev.safwan.productservice.dto.search.FilterDto;
import dev.safwan.productservice.dto.search.SearchResponseDTO;
import dev.safwan.productservice.dto.search.SortingCriteria;
import dev.safwan.productservice.model.Product;
import dev.safwan.productservice.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/")
    public SearchResponseDTO search(@RequestParam("query") String query,
                       @RequestParam("filters") List<FilterDto> filters,
                       @RequestParam("sortBy") SortingCriteria sortingCriteria,
                                    @RequestParam("pageNumber")int pageNumber,
                                    @RequestParam("pageSize")int pageSize) {
        Page<Product> productsPage = searchService.search(query, filters, sortingCriteria, pageNumber, pageSize);
        Page<ProductDTO> dtoPage = productsPage.map(ProductDTO::new);
        return new SearchResponseDTO(dtoPage);
    }

}
