package br.com.zup.challenge.apiRest.controller;

import br.com.zup.challenge.apiRest.domain.People;
import br.com.zup.challenge.apiRest.repository.PeopleRepository;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import br.com.zup.challenge.apiRest.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PeopleController {

    @Autowired
    private Service service;

    private PeopleRepository repository;

    public PeopleController(Service service) {
        this.service = service;
    }

    public PeopleController(){}

    @PostMapping("/people")
    public People savePeople(@RequestBody @Valid People people){
        return service.savePeople(people);
    }
    @GetMapping("/people")
    public List<People> listPeople(){
        return service.listPeople();
    }
    @PutMapping("/people/{cpf}")
    public People updatePeople(@RequestBody @Valid People people)
    {
        return service.updatePeople(people);
    }
    @DeleteMapping("/people/{id}")
    public void deletePeople(@PathVariable  Long id)
    {
        service.deleteById(id);
    }

    public void setPeopleRepository(PeopleRepository peopleRepository) {
        this.repository = peopleRepository;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setPeople(People people) {
    }
}
