package fr.simplon.api.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name =  "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime creationDate;

    @OneToMany
    private List<ProductRow> products;
}