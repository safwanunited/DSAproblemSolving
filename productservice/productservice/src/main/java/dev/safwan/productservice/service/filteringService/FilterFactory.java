package dev.safwan.productservice.service.filteringService;

public class FilterFactory {
    public static Filter getFilterFromKey(String key) {
        return switch (key) {
            case "brand" -> new BrandFilter();
            case "ram" -> new RAMFilter();
            default -> null;
        };
    }
}
