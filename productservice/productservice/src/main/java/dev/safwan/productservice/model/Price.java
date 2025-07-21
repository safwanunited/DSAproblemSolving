package dev.safwan.productservice.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.datatransfer.FlavorEvent;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel {
    private double amount;
    private String currency;

    public Price( String currency,double amount) {
        this.currency = currency;
        this.amount = amount;

    }
}
