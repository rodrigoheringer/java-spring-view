package com.example.demospringjpa.customViews;

import com.example.demospringjpa.entity.Person;

import java.util.List;

public interface PersonCustomView {
    Object getView(List<Person> people);
}
