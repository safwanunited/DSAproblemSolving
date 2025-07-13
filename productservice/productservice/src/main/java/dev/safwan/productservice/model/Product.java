package dev.safwan.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
