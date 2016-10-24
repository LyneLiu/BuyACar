package br.com.avelar.bac.manufacturer;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import br.com.avelar.bac.model.Model;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Manufacturer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @Resource(name = "models")
    @JsonBackReference
    private List<Model> models;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getModels() {
        return models;
    }

}
