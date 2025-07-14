package dev.safwan.productservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{
    private String title;
    private String Description;
    private String image;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    @OneToOne
    private Price price;

    @ManyToMany(mappedBy = "products")
    private List<Order>orders=new ArrayList<>();
}
