package Sopra.DiscuissonAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sopra.DiscuissonAPI.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	
	@Query("SELECT obj FROM Message obj WHERE (obj.envoyeur.id = :idd OR obj.recepteur.id = :idd)")
	List<Message> findByUserQuiVoit(@Param("idd") Integer idd);
}
