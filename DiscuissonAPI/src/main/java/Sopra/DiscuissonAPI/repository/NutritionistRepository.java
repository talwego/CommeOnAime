package Sopra.DiscuissonAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Sopra.DiscuissonAPI.model.Nutritionist;

public interface NutritionistRepository extends JpaRepository<Nutritionist, Integer>{

	

}
