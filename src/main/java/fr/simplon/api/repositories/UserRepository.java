package fr.simplon.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
