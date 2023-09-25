package com.handson.serialization.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Account implements Serializable {

    public String username = "Christon";
    public transient String password = "Cardoza";
    public transient  int pin = 1234;

    private void writeObject(ObjectOutputStream os) throws IOException {

        os.defaultWriteObject();
        String epwd = "123"+password;
        int epin = 4444 + pin;
        os.writeObject(epwd);
        os.writeInt(epin);
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {

        is.defaultReadObject();
        String epwd = (String) is.readObject();
        int epin = is.readInt();
        password = epwd.substring(3);
        pin = epin - 4444;
    }
}
