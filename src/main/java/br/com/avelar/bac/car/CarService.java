package br.com.avelar.bac.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;
	
	public Car save(Car carro) {
		return repository.save(carro);
	}
	
	public Car findOne(String license) {
		return repository.findOne(license);
	}
	
	public List<Car> findByDescription(String description) {
		return repository.findByDescriptionContaining(description);
	}
	
	public List<Car> findByModel(String name) {
		return repository.findByModelName(name);
	}
	
	public List<Car> findAll() {
		return repository.findAll();
	}
	
	public void delete(String placa) {
		repository.delete(placa);
	}
	
	public void delete(Car carro) {
		repository.delete(carro);
	}
	
}
