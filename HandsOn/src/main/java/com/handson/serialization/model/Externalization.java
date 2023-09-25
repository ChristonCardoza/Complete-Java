package com.handson.serialization.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Externalization  implements Externalizable {

    public String s;
    public int i;
    public int j;

    public Externalization(){
        System.out.println("Public Non-Arg Constructor");
    }

    public Externalization(String s, int i, int j){

        this.s = s;
        this.i = i;
        this.j = j;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        s = (String) in.readObject();
        i = in.readInt();
    }
}
