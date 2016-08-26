package br.com.avelar.bac.controllers;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import br.com.avelar.bac.car.Car;
import br.com.avelar.bac.car.CarService;
import br.com.avelar.bac.manufacturer.Manufacturer;
import br.com.avelar.bac.model.Model;

public class CarControllerTest {
	
	private Manufacturer manufacturer;
	private Model model;
	private Car car;
	
	@Before
	public void prepare() {
		manufacturer = new Manufacturer();
		manufacturer.setName("BMW");
		
		model = new Model();
		model.setName("325i");
		model.setManufacturer(manufacturer);
		
		car = new Car();
		car.setLicense("GCA-3294");
		car.setDescription("BMW 325i");
		car.setModel(model);
		car.setMileage(150000l);
		car.setCombustible("Gasoline");
		car.setColor("Black");
		car.setDoorsNumber(4);
		car.setYear(1994);
		car.setPrice(3300.0);
	}
	
	@Test
	public void testFindByLicense() throws Exception {
		CarService service = mock(CarService.class);
		when(service.findOne("GCA-3294")).thenReturn(car);
		
		CarController controller = new CarController(service);
		
		MockMvc mock = standaloneSetup(controller).build();
		
		mock.perform(get("/car/license/GCA-3294"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.license", is(car.getLicense())))
			.andExpect(jsonPath("$.description", is(car.getDescription())))
			.andExpect(jsonPath("$.mileage", is(car.getMileage().intValue())))
			.andExpect(jsonPath("$.combustible", is(car.getCombustible())))
			.andExpect(jsonPath("$.color", is(car.getColor())))
			.andExpect(jsonPath("$.doorsNumber", is(car.getDoorsNumber())))
			.andExpect(jsonPath("$.year", is(car.getYear())))
			.andExpect(jsonPath("$.price", is(car.getPrice())))
				.andExpect(jsonPath("$.model.manufacturer.name", 
							is(car.getModel().getManufacturer().getName())))
				.andExpect(jsonPath("$.model.name", 
							is(car.getModel().getName())));
	}

	@Test
	public void testFindByDescription() throws Exception {
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		
		CarService service = mock(CarService.class);
		when(service.findByDescription("BMW")).thenReturn(cars);
		
		CarController controller = new CarController(service);
		
		MockMvc mock = standaloneSetup(controller).build();
		
		mock.perform(get("/car/description/BMW"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].license", is(car.getLicense())))
			.andExpect(jsonPath("$[0].description", is(car.getDescription())))
			.andExpect(jsonPath("$[0].mileage", is(car.getMileage().intValue())))
			.andExpect(jsonPath("$[0].combustible", is(car.getCombustible())))
			.andExpect(jsonPath("$[0].color", is(car.getColor())))
			.andExpect(jsonPath("$[0].doorsNumber", is(car.getDoorsNumber())))
			.andExpect(jsonPath("$[0].year", is(car.getYear())))
			.andExpect(jsonPath("$[0].price", is(car.getPrice())))
				.andExpect(jsonPath("$[0].model.manufacturer.name", 
							is(car.getModel().getManufacturer().getName())))
				.andExpect(jsonPath("$[0].model.name", 
							is(car.getModel().getName())));
	}

	@Test
	public void testFindByModel() throws Exception {
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		
		CarService service = mock(CarService.class);
		when(service.findByModel("325i")).thenReturn(cars);
		
		CarController controller = new CarController(service);
		
		MockMvc mock = standaloneSetup(controller).build();
		
		mock.perform(get("/car/model/325i"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].license", is(car.getLicense())))
			.andExpect(jsonPath("$[0].description", is(car.getDescription())))
			.andExpect(jsonPath("$[0].mileage", is(car.getMileage().intValue())))
			.andExpect(jsonPath("$[0].combustible", is(car.getCombustible())))
			.andExpect(jsonPath("$[0].color", is(car.getColor())))
			.andExpect(jsonPath("$[0].doorsNumber", is(car.getDoorsNumber())))
			.andExpect(jsonPath("$[0].year", is(car.getYear())))
			.andExpect(jsonPath("$[0].price", is(car.getPrice())))
				.andExpect(jsonPath("$[0].model.manufacturer.name", 
							is(car.getModel().getManufacturer().getName())))
				.andExpect(jsonPath("$[0].model.name", 
							is(car.getModel().getName())));
	}

	@Test
	public void testFindAll() throws Exception {
		List<Car> cars = new ArrayList<Car>();
		cars.add(car);
		
		CarService service = mock(CarService.class);
		when(service.findAll()).thenReturn(cars);
		
		CarController controller = new CarController(service);
		
		MockMvc mock = standaloneSetup(controller).build();
		
		mock.perform(get("/car/all"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].license", is(car.getLicense())))
			.andExpect(jsonPath("$[0].description", is(car.getDescription())))
			.andExpect(jsonPath("$[0].mileage", is(car.getMileage().intValue())))
			.andExpect(jsonPath("$[0].combustible", is(car.getCombustible())))
			.andExpect(jsonPath("$[0].color", is(car.getColor())))
			.andExpect(jsonPath("$[0].doorsNumber", is(car.getDoorsNumber())))
			.andExpect(jsonPath("$[0].year", is(car.getYear())))
			.andExpect(jsonPath("$[0].price", is(car.getPrice())))
				.andExpect(jsonPath("$[0].model.manufacturer.name", 
							is(car.getModel().getManufacturer().getName())))
				.andExpect(jsonPath("$[0].model.name", 
							is(car.getModel().getName())));
	}

}
