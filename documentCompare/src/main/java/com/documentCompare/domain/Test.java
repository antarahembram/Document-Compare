package com.documentCompare.domain;

import org.springframework.stereotype.Component;

@Component
public class Test {
    Obj obj=new Obj("This is coming from method1");

    public Obj method1()
    {
        return obj;
    }
}
