package com.handson.serialization;

import com.handson.serialization.model.*;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class SDServiceImpl implements SDService {
    @Override
    public void doSD() throws IOException, ClassNotFoundException {

        Dog d1 = new Dog();

        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/dogSerialize.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/dogSerialize.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Dog d2 = (Dog) ois.readObject();

        System.out.println(d2.i + "---" + d2.j);
    }

    @Override
    public void objectGraphSD() throws IOException, ClassNotFoundException {

        Dog2 d1 = new Dog2();

        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/ObjectGraph.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d1);

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/ObjectGraph.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog2 d2 = (Dog2) ois.readObject();
        System.out.println(d2.c.r.j);
    }

    @Override
    public void customizeSD() throws IOException, ClassNotFoundException {

        Account a1 = new Account();
        System.out.println(a1.username + "------" + a1.password + "------" + a1.pin);
        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/Customize.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(a1);

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/Customize.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account a2 = (Account) ois.readObject();
        System.out.println(a2.username + "------" + a2.password + "------" + a2.pin);
    }

    @Override
    public void inheritanceSD() throws IOException, ClassNotFoundException {

        Child c1 = new Child();
        System.out.println(c1.i + "-----" + c1.j);
        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/Inheritance.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c1);

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/Inheritance.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Child c2 = (Child) ois.readObject();
        System.out.println(c2.i + "-----" + c2.j);
    }

    @Override
    public void instanceControlSD() throws IOException, ClassNotFoundException {

        System.out.println("------------- Serialization ----------------");

        Child1 c1 = new Child1();
        c1.i = 888;
        c1.j = 999;
        System.out.println(c1.i + "-----" + c1.j);

        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/InstanceControl.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(c1);

        System.out.println("------------- Deserialization ----------------");

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/InstanceControl.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Child1 c2 = (Child1) ois.readObject();
        System.out.println(c2.i + "-----" + c2.j);
    }

    @Override
    public void externalizationSD() throws IOException, ClassNotFoundException {

        Externalization t1 = new Externalization("Christon", 10, 20);
        System.out.println(t1.s + "-----" + t1.i + "-----" + t1.j);

        FileOutputStream fos = new FileOutputStream("./src/main/resources/sd/Externalization.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(t1);

        FileInputStream fis = new FileInputStream("./src/main/resources/sd/Externalization.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Externalization t2 = (Externalization) ois.readObject();
        System.out.println(t2.s + "-----" + t2.i + "-----" + t2.j);
    }
}
