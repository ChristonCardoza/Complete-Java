package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combining04ConcaDelayError {

    private static final Logger log = LoggerFactory.getLogger(combining04ConcaDelayError.class);

    public static void main(String[] args) {

//        demo1();

        demo2();

        Util.sleepSeconds(3);
    }

    private static void demo1() {
        producer1()
                .concatWith(producer3())
                .concatWith(producer2())
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
       Flux.concatDelayError(producer1(), producer3(), producer2())
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

    private static Flux<Integer> producer3() {
        return Flux.error(new RuntimeException("Oops"));
    }
}
