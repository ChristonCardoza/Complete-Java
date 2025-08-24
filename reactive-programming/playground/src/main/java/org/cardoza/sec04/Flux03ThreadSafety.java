package org.cardoza.sec04;

import org.cardoza.common.Util;
import org.cardoza.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Flux03ThreadSafety {

    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    private static void demo1() {
        var list = new ArrayList<Integer>();

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };

        for(int i=0; i<10; i++){
//            new Thread(runnable).start();
            Thread.ofPlatform().start(runnable);
        }

        Util.sleepSeconds(5);
        System.out.println("List Size: "+ list.size());
    }

    private static void demo2() {
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);

        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };

        for(int i=0; i<10; i++){
            Thread.ofPlatform().start(runnable);
        }

        Util.sleepSeconds(5);
        System.out.println("List Size: "+ list.size());
    }
}
