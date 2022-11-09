package Sopra.DiscuissonAPI.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Sopra.DiscuissonAPI.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	Optional<Message> findByDateMessageDate(LocalDate dateMessageDate);

}
