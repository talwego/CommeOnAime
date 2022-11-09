package Sopra.DiscuissonAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Sopra.DiscuissonAPI.model.Genre;
import Sopra.DiscuissonAPI.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findByGenreContaining(Genre genre);
	List<User> findByAgeContaining(int age);
	List<User> findByTailleContaining(double taille);
	List<User> findByPoidsContaining(double poids);
	List<User> findByCompteVIPContaining(boolean compteVIP);
	List<User> findByVegetarienContaining(boolean vegetarien);
	List<User> findByVeganContaining(boolean vegan);

}
