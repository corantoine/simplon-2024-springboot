package fr.simplon.api.controllers;

import fr.simplon.api.Messages.CardMessageDto;
import fr.simplon.api.models.Card;
import fr.simplon.api.models.Product;
import fr.simplon.api.models.User;
import fr.simplon.api.repositories.CardRepository;
import fr.simplon.api.repositories.ProductRepository;
import fr.simplon.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

//    public CardController(CardRepository cardRepository) {
//        this.cardRepository = cardRepository;
//    }

    @GetMapping("/{cardId}")
    public Optional<Card> getAllCards(@PathVariable Integer cardId) {
        return cardRepository.findById(cardId);
    }

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @PostMapping
    public Card createCard(@RequestBody CardMessageDto card){
        Card newCard = new Card();
        User user = userRepository.findById(card.getUsers()).get();
        newCard.setUsers(user);
        Product product = productRepository.findById(card.getProducts()).get();
        List<Product> listDeProduits = new ArrayList<>();
        listDeProduits.add(product);
        newCard.setProducts(listDeProduits);
        newCard.setCreationDate(LocalDateTime.now());
        return cardRepository.save(newCard);
    }


}
