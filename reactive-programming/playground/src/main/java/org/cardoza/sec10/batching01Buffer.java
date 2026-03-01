package org.cardoza.sec10;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class batching01Buffer {

    private static final Logger log = LoggerFactory.getLogger(batching01Buffer.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

//        demo3();

        demo4();

        Util.sleepSeconds(8);

    }

    private static void demo1() {
        eventStream()
                .buffer()
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
        eventStream()
                .buffer(3)
                .subscribe(Util.subscriber());
    }

    private static void demo3() {
        eventStream()
                .buffer(Duration.ofMillis(500))
                .subscribe(Util.subscriber());
    }

    private static void demo4() {
        eventStream()
                .bufferTimeout(3, Duration.ofMillis(1))
                .subscribe(Util.subscriber());
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(200))
                .take(10)
                .concatWith(Flux.never())
                .map(i -> "event" + (i + 1));
    }
}
