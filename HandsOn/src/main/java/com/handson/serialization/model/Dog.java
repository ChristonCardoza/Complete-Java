package com.handson.serialization.model;

import java.io.Serializable;

public class Dog implements Serializable {

    public transient final  int i = 10;
    public transient  int j = 20;
}
