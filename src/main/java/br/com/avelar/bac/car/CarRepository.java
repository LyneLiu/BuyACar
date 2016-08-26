package br.com.avelar.bac.car;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
	public List<Car> findByDescriptionContaining(String description);
	public List<Car> findByModelName(String name);
}
