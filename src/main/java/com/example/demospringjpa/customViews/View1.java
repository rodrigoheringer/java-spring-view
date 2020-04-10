package com.example.demospringjpa.customViews;

import com.example.demospringjpa.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class View1 implements PersonCustomView {

    public Object getView(List<Person> people) {
        ArrayList<String> nameList =new ArrayList<>();
        for (Person person : people) {
            nameList.add(person.getName());
        }
        return nameList;
    }
}
