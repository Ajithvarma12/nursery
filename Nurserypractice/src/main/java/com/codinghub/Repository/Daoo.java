package com.codinghub.Repository;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codinghub.model.Plant;

public interface Daoo extends JpaRepository<Plant,Long> {

	Optional<Plant> findByName(String name);

	List<Plant> findByCategory(String category);

	List<Plant> findByPrice(double price);

	List<Plant> findByPriceBetween(long min, long max);

	
	List<Plant> findByDescriptionContaining(String keyword);

	List<Plant> findByQuantity(int quantity);

	@Query("select p from Plant p where description like %:keyword%")
	List<Plant> searchByDescriptionKey(String keyword);

	@Query("update Plant set image = :image where id = :id")
	String saveImageByPlantId(long id, FileInputStream image);

}
