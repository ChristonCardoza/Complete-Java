package com.handson.serialization.model;

import java.io.Serializable;

public class Child1 extends Parent1 implements Serializable {

    public int j = 20;

    public Child1(){
        System.out.println("Child1 Constructor Called");
    }
}
