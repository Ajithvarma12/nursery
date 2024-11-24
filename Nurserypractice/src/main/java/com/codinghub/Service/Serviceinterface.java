package com.codinghub.Service;

import java.util.List;
import java.util.Optional;

import com.codinghub.exception.DataNotFoundException;
import com.codinghub.model.Plant;

public interface Serviceinterface {

	Plant posting(Plant plant);

	List<Plant> getalldata();

	Optional<Plant> getone(long id) throws DataNotFoundException;

	Optional<Plant> getname(String name);

	List<Plant> getcategory(String category);

	List<Plant> getprice(double price);

	List<Plant> getbetween(long min, long max);

	List<Plant> getPlantsByDescription(String keyword);

	List<Plant> getbyquantity(int quantity);

	Plant getupadate(long id, Plant plant) throws DataNotFoundException;

	String getdelete(long id);
	
	List<Plant> getsorting();

	List<Plant> getdescsorting();




}
