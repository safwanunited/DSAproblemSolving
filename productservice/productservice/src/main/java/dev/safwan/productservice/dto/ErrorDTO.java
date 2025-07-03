package dev.safwan.productservice.dto;


import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorDTO {
    private HttpStatus errorCode;
    private String message;

    public ErrorDTO(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
