package dev.safwan.productservice.thirdpartyclients.producservice.fakestore;

import dev.safwan.productservice.dto.GenericProductDTO;
import dev.safwan.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceClient {

    private final RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreProductUrl;
    @Value("${fakestore.api.path.product}")
    private String fakeStoreProductApiPath;

    private String getSpecificProductUrl;
    private String productRequestBaseUrl;
    private GenericProductDTO convertToGenericProductDto(FakeStoreProductDTO fakeStoreProductDto){
        GenericProductDTO product=new GenericProductDTO();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}")
    String fakeStoreProductUrl, @Value("${fakestore.api.path.product}") String fakeStoreProductApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.getSpecificProductUrl=fakeStoreProductUrl+fakeStoreProductApiPath+"/{id}";
        this.productRequestBaseUrl=fakeStoreProductUrl+fakeStoreProductApiPath;
    }

    public GenericProductDTO getProductById(String currId) throws NotFoundException {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response=restTemplate.getForEntity(getSpecificProductUrl, FakeStoreProductDTO.class,currId);
        FakeStoreProductDTO fakeStoreProductDto=response.getBody();
        if(fakeStoreProductDto==null){
            throw new NotFoundException("Product with"+ currId +" is not found");
        }
        GenericProductDTO product=new GenericProductDTO();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public GenericProductDTO createProduct(GenericProductDTO product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO>response=restTemplate.postForEntity(productRequestBaseUrl,product, GenericProductDTO.class);
        return response.getBody();
    }

    public List<GenericProductDTO> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]>response=restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductDTO[].class);

        List<GenericProductDTO>answer=new ArrayList<>();
        for(FakeStoreProductDTO fakeStoreProductDto:response.getBody()){
            GenericProductDTO product=new GenericProductDTO();
            product.setId(fakeStoreProductDto.getId());
            product.setImage(fakeStoreProductDto.getImage());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());
            answer.add(product);
        }
        return answer;
    }

    public GenericProductDTO deleteProduct(String id) {

        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDTO.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDTO.class);
        ResponseEntity<FakeStoreProductDTO>response=restTemplate.execute(getSpecificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        FakeStoreProductDTO fakeStoreProductDto=response.getBody();
        return convertToGenericProductDto(fakeStoreProductDto);
    }


}
