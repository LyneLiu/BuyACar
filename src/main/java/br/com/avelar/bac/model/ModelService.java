package br.com.avelar.bac.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    @Autowired
    private ModelRepository repository;

    public Model save(Model model) {
        return repository.save(model);
    }

    public Model findOne(Long id) {
        return repository.findOne(id);
    }

    public List<Model> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void delete(Model model) {
        repository.delete(model);
    }

}
