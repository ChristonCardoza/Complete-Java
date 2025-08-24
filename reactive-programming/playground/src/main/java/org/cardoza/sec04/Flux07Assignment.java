package org.cardoza.sec04;

import org.cardoza.common.Util;
import org.cardoza.sec04.assignment.FileReaderServiceImpl;

import java.nio.file.Path;

public class Flux07Assignment {

    public static void main(String[] args) {

        var path = Path.of("src/main/java/org/cardoza/sec04/assignment/ThousandLines.txt");
        var fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .subscribe(Util.subscriber());

    }
}
