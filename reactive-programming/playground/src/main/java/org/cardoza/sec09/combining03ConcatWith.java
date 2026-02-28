package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combining03ConcatWith {

    private static final Logger log = LoggerFactory.getLogger(combining03ConcatWith.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

        demo3();


        Util.sleepSeconds(3);
    }

    private static void demo1() {
        producer1()
                .concatWithValues(-1, 0)
                .subscribe(Util.subscriber());
    }


    private static void demo2() {
        producer1()
                .concatWith(producer2())
                .subscribe(Util.subscriber());
    }

    private static void demo3() {
        Flux.concat(producer1(), producer2())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> producer1() {
        return Flux.just(1,2,3)
                .doOnSubscribe((s -> log.info("Subscribing to producer-1")))
                .delayElements(Duration.ofMillis(10));
    }

    private static Flux<Integer> producer2() {
        return Flux.just(51,52,53)
                .doOnSubscribe((s -> log.info("Subscribing to producer-2")))
                .delayElements(Duration.ofMillis(10));
    }
}
