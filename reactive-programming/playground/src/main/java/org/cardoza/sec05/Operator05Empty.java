package org.cardoza.sec05;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Operator05Empty {

    public static void main(String[] args) {

        defaultEmpty();

        switchEmpty();

    }

    private static void defaultEmpty() {
        Flux.range(1,10)
                .filter(i -> i >10)
                .defaultIfEmpty(Integer.MAX_VALUE)
                .subscribe(Util.subscriber("defaultEmpty"));

    }

    private static void switchEmpty() {
        Flux.range(1,10)
                .filter(i -> i >10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber("switchEmpty"));

    }

    private static Flux<Integer> fallback(){
        return Flux.just(Integer.MIN_VALUE);
    }
}
