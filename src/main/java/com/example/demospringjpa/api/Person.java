package com.example.demospringjpa.api;

import com.example.demospringjpa.aggregators.PersonAggregator;
import com.example.demospringjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Person {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/")
    public Object get() {
        return personRepository.get();
    }

    @GetMapping("/view/{viewName}")
    public Object customView(
            @PathVariable("viewName") String viewName
    ) {
        System.out.println(viewName);
        List<com.example.demospringjpa.entity.Person> people = personRepository.get();
        PersonAggregator customView = applicationContext.getBean(viewName, PersonAggregator.class);
        return customView.getView(people);
    }
}
