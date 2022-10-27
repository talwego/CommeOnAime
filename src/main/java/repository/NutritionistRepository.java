package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer>{

	@Query("select n from Nutritionist n left join fetch n.messages where n.id=:id")
	Optional<Nutritionist> findByIdFetchMessage(@Param("id")Integer id);

}
