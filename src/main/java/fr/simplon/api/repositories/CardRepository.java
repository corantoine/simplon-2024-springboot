package fr.simplon.api.repositories;

import fr.simplon.api.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Optional<Card> findById(int id);

}
