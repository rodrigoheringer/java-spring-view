package com.example.demospringjpa.aggregators;

import com.example.demospringjpa.entity.Person;

import java.util.List;

public interface PersonAggregator {
    Object getView(List<Person> people);
}
