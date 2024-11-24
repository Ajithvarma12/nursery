package com.codinghub.Service;

import java.io.FileInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.codinghub.Repository.Daoo;
import com.codinghub.exception.DataNotFoundException;
import com.codinghub.model.Plant;

@Service
public class Serviceclasss implements Serviceinterface {
	@Autowired
	private Daoo dao;
	@Override
	public Plant posting(Plant plant) {
		return dao.save(plant);
	}
	@Override
	public List<Plant> getalldata() {
		return dao.findAll();
	}
	@Override
	public Optional<Plant> getone(long id) throws DataNotFoundException {
		Optional<Plant> plant = dao.findById(id);
		if (!plant.isPresent()) {
			throw new DataNotFoundException(String.valueOf(HttpStatus.NOT_FOUND.value()),
					"Plant not found with the provided id");
		}
		return dao.findById(id);
	}
	@Override
	public Optional<Plant> getname(String name) {
		return dao.findByName(name);
	}
	@Override
	public List<Plant> getcategory(String category) {
		return dao.findByCategory(category);
	}
	
	
	@Override
	public List<Plant> getprice(double price) {
		return dao.findByPrice(price);
	}

	@Override
	public List<Plant> getsorting() {
		return dao.findAll(Sort.by("price"));
	}

	@Override
	public List<Plant> getdescsorting() {
		return dao.findAll(Sort.by("price").descending());
	}

	@Override
	public List<Plant> getbetween(long min, long max) {
		return dao.findByPriceBetween(min, max);
	}

	@Override
	public List<Plant> getPlantsByDescription(String keyword) {
//		String keyWord = "%" + keyword + "%";
//		return dao.findByDescriptionContaining(keyword);
		return dao.searchByDescriptionKey(keyword);
		
	}
	
	@Override
	public List<Plant> getbyquantity(int quantity) {
		return dao.findByQuantity(quantity);
	}
	@Override
	public Plant getupadate(long id, Plant plant) throws DataNotFoundException {
		Plant p = getone(id).get();
		p.setName(plant.getName());
		p.setCategory(plant.getCategory());
		p.setQuantity(plant.getQuantity());
		p.setPrice(plant.getPrice());
		p.setDescription(plant.getDescription());
		return dao.save(p);
	}
	@Override
	public String getdelete(long id) {
		dao.deleteById(id);
		return "deleted successfully";
	}
	public String saveImageByPlantId(long id, FileInputStream image)
	{
		return dao.saveImageByPlantId(id, image);
	}
}


