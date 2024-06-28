package fr.simplon.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.User;

// @Repository pas obligatoire ?
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  public Optional<User> findByUsername(String username);

  public Optional<User> findByUsernameAndPassword(String username, String password);

    // @Query(value = "SELECT * FROM users WHERE username = $1", nativeQuery=true)
  // public Optional<User> bichette(String biche);
}
