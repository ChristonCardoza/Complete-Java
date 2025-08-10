package org.cardoza.sec02;

import org.cardoza.common.Util;
import org.cardoza.sec02.assignment.FileServiceImpl;

public class Mono10File {

    public static void main(String[] args) {

        var fileService = new FileServiceImpl();

        fileService.write("file.txt", "This is a test file")
                .subscribe(Util.subscriber());

        fileService.read("file.txt")
                .subscribe(Util.subscriber());

        fileService.delete("file.txt")
                .subscribe(Util.subscriber());

    }

}
