package br.com.avelar.bac.manufacturer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {

	@Autowired
	private ManufacturerRepository dao;
	
	public Manufacturer save(Manufacturer montadora) {
		return dao.save(montadora);
	}
	
	public Manufacturer findOne(Long id) {
		return dao.findOne(id);
	}
	
	public List<Manufacturer> findAll() {
		return dao.findAll();
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public void delete(Manufacturer montadora) {
		dao.delete(montadora);
	}
	
}
