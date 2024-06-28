package fr.simplon.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;


@Entity
@Data
@RequiredArgsConstructor
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NonNull
    private String name;
    private float price;

    @JsonIgnore
    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Card> cards;
    public Product(){}

}
