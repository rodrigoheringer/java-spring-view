package com.example.demospringjpa.customViews;

import com.example.demospringjpa.entity.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class View2 implements PersonCustomView {

    public Object getView(List<Person> people) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        for (Person person : people) {
            stringObjectHashMap.put(person.getId() + "", person.getName());
        }
        return stringObjectHashMap;
    }
}
