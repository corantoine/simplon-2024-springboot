package fr.simplon.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime creationDate;
//    private Map<Product, Integer> products;
    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Product> products;

    @OneToOne
    private User users;


}
