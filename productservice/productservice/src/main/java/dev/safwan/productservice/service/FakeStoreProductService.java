package dev.safwan.productservice.service;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;
import dev.safwan.productservice.thirdpartyclients.producservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }


    @Override
    public GenericProductDTO getProductById(String currId) throws NotFoundException {
        return fakeStoreProductServiceClient.getProductById(currId);
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        return fakeStoreProductServiceClient.createProduct(product);
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return fakeStoreProductServiceClient.getAllProducts();
    }

    @Override
    public GenericProductDTO deleteProduct(String id) {
        return fakeStoreProductServiceClient.deleteProduct(id);
    }
}
