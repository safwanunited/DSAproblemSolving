package dev.safwan.productservice.service.sorterService;

import dev.safwan.productservice.dto.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria sortingCriteria){
        return switch (sortingCriteria){
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case PRICE_HIGH_TO_LOW -> new PriceHightToLowSorter();
            case RELEVANCE -> null;
            case POPULARITY -> null;
            case RATING_LOW_TO_HIGH -> null;
            case RATING_HIGH_TO_LOW -> null;
            default -> products -> products;
        };

    }
}
