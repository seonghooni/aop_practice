package com.example.springstudy.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

//    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }

//    클래스 경로로 AOP 구현하는 방식
//
//    @Around("execution(* com.example.springstudy..*(..))")
//    public Object logExecutionTime_2(ProceedingJoinPoint joinPoint) throws Throwable {
//
//
//        try {
//            return joinPoint.proceed();
//        } finally {
//
//            System.out.println("클래스 경로를 통해 AOP 구현");
//        }
//
//    }
}
