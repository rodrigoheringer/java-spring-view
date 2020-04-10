package com.example.demospringjpa.aspect;

import com.example.demospringjpa.service.RequestContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aspect
@Component
public class SessionAspect {

    @Autowired
    RequestContext context;

    @Before(value = "execution(* com.example.demospringjpa.api.*.*(..))")
    public void RepoLogger(JoinPoint jp) throws Throwable {
        String value = UUID.randomUUID().toString();
        context.setContextValue("id", value);
        System.out.println(value);
    }
}
