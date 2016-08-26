package br.com.avelar.bac;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.avelar.bac.model.Model;

@SpringBootApplication
public class BuyACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyACarApplication.class, args);
	}
	
	@Bean(name = "models")
	public List<Model> modelos() {
		return new ArrayList<Model>();
	}
	
	@Bean(name = "photos")
	public List<String> fotos() {
		return new ArrayList<String>();
	}
	
}
