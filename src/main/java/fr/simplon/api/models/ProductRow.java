package fr.simplon.api.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
//@RequiredArgsConstructor()
@Table(name = "products-row")
public class ProductRow {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Product product;
    private int quantity;
    private float price;
    private float discount;

public ProductRow(){

}
}