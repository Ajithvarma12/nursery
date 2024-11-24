package com.codinghub.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codinghub.Service.Serviceinterface;
import com.codinghub.exception.DataNotFoundException;
import com.codinghub.model.Plant;

@RestController
@CrossOrigin
public class Mycontroller {
	@Autowired
	private Serviceinterface serviceinterface;
	
	@PostMapping("/")
	public Plant posting(@RequestBody Plant plant)
	{
		return serviceinterface.posting(plant);
	}
	@GetMapping("/")
	public List<Plant>getall()
	{
		return serviceinterface.getalldata();
	}
	@GetMapping("/id/{id}")
	public Optional<Plant> getPlantById(@PathVariable long id) throws DataNotFoundException
	{
		return serviceinterface.getone(id);
	}
	@GetMapping("/name/{name}")
	public Optional<Plant> getname(@PathVariable String name)
	{
		return serviceinterface.getname(name);
	}
	@GetMapping("/category/{category}")
	public List<Plant> getcategory(@PathVariable String category)
	{
		return serviceinterface.getcategory(category);
	}
	@GetMapping("/price/{price}")
	public List<Plant> getprice(@PathVariable double price)
	{
		return serviceinterface.getprice(price);
	}
	@GetMapping("/sorting")
	public List<Plant> getsorting()
	{
		return serviceinterface.getsorting();
	}
	@GetMapping("/sortingdesc")
	public List<Plant> getdescsorting()
	{
		return serviceinterface.getdescsorting();
	}
	@GetMapping("/price-range/{min}/{max}")
	public List<Plant>getpricebetween(@PathVariable long  min,@PathVariable long max)
	{
		return serviceinterface.getbetween(min,max);
	}
	@GetMapping("/description/{keyword}")
	public List<Plant> getPlantsByDescription(@PathVariable String keyword) {
	    return serviceinterface.getPlantsByDescription(keyword);
	}
	@GetMapping("/quantity/{quantity}")
	public List<Plant>getPlantbyquantity(@PathVariable int quantity)
	{
		return serviceinterface.getbyquantity(quantity);
	}
	@PutMapping("/{id}")
	public Plant update(@PathVariable long id,@RequestBody Plant plant) throws DataNotFoundException
	{
		return serviceinterface.getupadate(id,plant);
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable long id)
	{
		return serviceinterface.getdelete(id);
	}
}
