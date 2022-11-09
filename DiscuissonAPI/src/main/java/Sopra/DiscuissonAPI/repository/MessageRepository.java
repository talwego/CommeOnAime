package repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

	Optional<Message> findByDateMessageDate(LocalDate dateMessageDate);

}
