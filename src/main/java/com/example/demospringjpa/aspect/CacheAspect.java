package com.example.demospringjpa.aspect;

import com.example.demospringjpa.service.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CacheAspect {

    @Autowired
    Cache cache;


    @Around(value = "execution(* com.example.demospringjpa.repository.PersonRepository.*(..))")
    public Object RepoLogger(ProceedingJoinPoint jp) throws Throwable {
        String methodName = jp.getSignature().toString();
        Object o = cache.get(methodName);
        if (o != null) {
            return o;
        }
        o = jp.proceed();
        cache.set(methodName, o);
        return o;
    }
}
