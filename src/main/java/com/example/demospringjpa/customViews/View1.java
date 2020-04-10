package com.example.demospringjpa.customViews;

import com.example.demospringjpa.entity.Person;
import com.example.demospringjpa.service.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class View1 implements PersonCustomView {

    @Autowired
    RequestContext context;

    public Object getView(List<Person> people) {
        ArrayList<String> nameList =new ArrayList<>();
        for (Person person : people) {
            nameList.add(person.getName());
        }
        nameList.add(context.RequestContext("id"));
        return nameList;
    }
}
