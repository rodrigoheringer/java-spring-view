package com.example.demospringjpa.customViews;

import com.example.demospringjpa.entity.Person;
import com.example.demospringjpa.service.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class View2 implements PersonCustomView {

    @Autowired
    private RequestContext requestContext;

    public Object getView(List<Person> people) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        for (Person person : people) {
            stringObjectHashMap.put(person.getId() + "", person.getName());
        }
        stringObjectHashMap.put("id", requestContext.getContextVariable("id"));
        return stringObjectHashMap;
    }
}
