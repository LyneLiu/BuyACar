package br.com.avelar.bac.car;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import br.com.avelar.bac.model.Model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Car {

    @Id
    private String license;

    @ManyToOne
    @Autowired
    private Model model;

    private String description;

    private Long mileage;

    private Integer year;

    private String color;

    private Integer doorsNumber;

    private String combustible;

    private Double price;

    @Resource(name = "photos")
    @ElementCollection
    @JsonManagedReference
    private List<String> photos;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getDoorsNumber() {
        return doorsNumber;
    }

    public void setDoorsNumber(Integer doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String toString() {
        return model.getManufacturer().getName() + " " + model.getName();
    }

    public boolean equals(Car car) {
        return this.license.equals(car.getLicense());
    }

}
