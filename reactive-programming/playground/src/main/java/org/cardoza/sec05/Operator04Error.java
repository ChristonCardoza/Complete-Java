package org.cardoza.sec05;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Operator04Error {

    public static void main(String[] args) {

        errorReturn();

        errorResume();

        errorComplete();

        errorContinue();

    }

    private static void errorReturn(){
        Flux.range(1,10)
                .map(i -> i==5 ? i/0 :i)
                .onErrorReturn(ArithmeticException.class, -1)
                .onErrorReturn(IllegalAccessError.class, -2)
                .onErrorReturn(-3)
                .subscribe(Util.subscriber("errorReturn"));
    }

    private static void errorResume(){
        Flux.range(1,10)
                .map(i -> i==5 ? i/0 :i)
                .onErrorResume(ex -> fallback())
                .subscribe(Util.subscriber("errorResume"));
    }

    private static Flux<Integer> fallback() {
        return Flux.just(Util.faker().random().nextInt(100,500));
    }

    private static void errorComplete(){
        Flux.range(1,10)
                .map(i -> i==5 ? i/0 :i)
                .onErrorComplete()
                .subscribe(Util.subscriber("errorComplete"));
    }

    private static void errorContinue(){
        Flux.range(1,10)
                .map(i -> i==5 ? i/0 :i)
                .onErrorContinue((ex, obj) -> System.out.println("-->"+ obj + " " + ex))
                .subscribe(Util.subscriber("errorContinue"));
    }

}
