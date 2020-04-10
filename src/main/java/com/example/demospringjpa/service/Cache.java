package com.example.demospringjpa.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Cache {

    private HashMap<String, Object> db = new HashMap<>();

    public <T> T get(String target, Class T) {
        Object o = db.get(target);
        return (T) o;
    }

    public Object get(String target) {
        return db.get(target);
    }

    public void set(String methodName, Object target) {
        db.put(methodName, target);
    }
}
