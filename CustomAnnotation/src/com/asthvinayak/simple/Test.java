package com.asthvinayak.simple;
//Test.java
import  java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String   info()      default "";
	int      version()   default 1;
}