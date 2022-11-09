package Sopra.DiscuissonAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Sopra.DiscuissonAPI.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, Integer>{
	List<Compte> findByLoginContaining(String login);
	List<Compte> findByPasswordContaining(String password);
	Optional<Compte> findByLogin(String login);

}
