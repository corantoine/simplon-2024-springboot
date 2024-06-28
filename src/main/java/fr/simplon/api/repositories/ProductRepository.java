package fr.simplon.api.repositories;

import fr.simplon.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    public Optional<Product> findByName(String name);

   // public Optional<Product> deleteProductById(int id);
}

