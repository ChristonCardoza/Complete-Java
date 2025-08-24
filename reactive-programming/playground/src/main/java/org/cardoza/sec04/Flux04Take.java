package org.cardoza.sec04;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux04Take {

    public static void main(String[] args) {
        take();

        takeWhile();

        takeUntil();
    }

    private static void take(){
        Flux.range(1, 10)
                .log("take")
                .take(3)
                .subscribe(Util.subscriber("Take"));
    }

    private static void takeWhile(){
        Flux.range(1, 10)
                .log("takeWhile")
                .takeWhile(i -> i < 5)
                .subscribe(Util.subscriber("takeWhile"));
    }

    private static void takeUntil(){
        Flux.range(1, 10)
                .log("takeUntil")
                .takeUntil(i -> i== 5)
                .subscribe(Util.subscriber("takeUntil"));
    }

}
