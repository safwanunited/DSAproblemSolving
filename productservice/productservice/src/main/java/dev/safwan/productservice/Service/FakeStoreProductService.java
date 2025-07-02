package dev.safwan.productservice.Service;

import dev.safwan.productservice.DTOs.FakeStoreProductDTO;
import dev.safwan.productservice.DTOs.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl="https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl="https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDTO getProductById(String currId){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO>response=restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDTO.class,currId);
        FakeStoreProductDTO fakeStoreProductDto=response.getBody();

        GenericProductDTO product=new GenericProductDTO();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO>response=restTemplate.postForEntity(createProductRequestUrl,product, GenericProductDTO.class);
        return response.getBody();
    }
}
