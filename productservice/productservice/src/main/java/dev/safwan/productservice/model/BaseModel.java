package dev.safwan.productservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
}

