package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer>{

	Optional<Nutritionist> findByIdFetchMessage(Integer id);

}
