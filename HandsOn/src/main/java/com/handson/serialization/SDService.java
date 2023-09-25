package com.handson.serialization;

import java.io.IOException;

public interface SDService {

    void doSD() throws IOException, ClassNotFoundException;

    void objectGraphSD() throws IOException, ClassNotFoundException;

    void customizeSD() throws IOException, ClassNotFoundException;

    void inheritanceSD() throws IOException, ClassNotFoundException;

    void instanceControlSD() throws IOException, ClassNotFoundException;

    void externalizationSD() throws IOException, ClassNotFoundException;
}
