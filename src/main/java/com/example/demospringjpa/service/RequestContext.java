package com.example.demospringjpa.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RequestContext {

    private final ThreadLocal<Map<String, Object>> threadValues;

    public RequestContext() {
        this.threadValues = new ThreadLocal<>();
    }

    public <T> T getContextVariable(String name) {
        checkContext();
        return ((T) threadValues.get().get(name));
    }

    private void checkContext() {
        if (threadValues.get() == null) {
            threadValues.set(new HashMap<>());
        }
    }

    public void setContextValue(String name, Object value) {
        checkContext();
        threadValues.get().put(name, value);
    }
}
