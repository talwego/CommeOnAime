package Sopra.DiscuissonAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Sopra.DiscuissonAPI.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	List<Admin> findByLoginContaining(String login);
	List<Admin> findByPasswordContaining(String password);

}
