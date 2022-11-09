package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	List<Compte> findByLoginContaining(String login);
	List<Compte> findByPasswordContaining(String password);

}
