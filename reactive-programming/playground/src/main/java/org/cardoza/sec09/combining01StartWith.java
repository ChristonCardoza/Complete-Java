package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class combining01StartWith {

    private static final Logger log = LoggerFactory.getLogger(combining01StartWith.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

//        demo3();

        demo4();

        Util.sleepSeconds(3);
    }

    private static void demo1() {
        producer1()
                .startWith(-1, 0)
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
        producer1()
                .startWith(List.of(-2,-1,0))
                .subscribe(Util.subscriber());
    }

    private static void demo3() {
        producer1()
                .startWith(producer2())
                .subscribe(Util.subscriber());
    }

    private static void demo4() {
        producer1()
                .startWith(producer2())
                .startWith(100)
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
