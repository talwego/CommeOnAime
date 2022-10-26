package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.protobuf.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
