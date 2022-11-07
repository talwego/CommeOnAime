package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.InstructionRecette;

public interface InstructionRecetteRepository extends JpaRepository<InstructionRecette, Integer>{

}
