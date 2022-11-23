package Sopra.DiscuissonAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sopra.DiscuissonAPI.model.Compte;


public interface CompteRepository extends JpaRepository<Compte, Integer>{
	List<Compte> findByLoginContaining(String login);
	List<Compte> findByPasswordContaining(String password);
	Optional<Compte> findByLogin(String login);
	
	@Query("select c from Compte c left join fetch c.messages where c.id=:id")
	Optional<Compte> findByIdFetchMessage(@Param("id")Integer id);

}
