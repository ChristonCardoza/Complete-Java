package org.cardoza.sec10;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class batching03Window {

    private static final Logger log = LoggerFactory.getLogger(batching03Window.class);

    public static void main(String[] args) {

//        demo1();

        demo2();


        Util.sleepSeconds(8);

    }

    private static void demo1() {
        eventStream()
                .window(5)
                .flatMap(batching03Window::processEvents)
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
        eventStream()
                .window(Duration.ofMillis(400))
                .flatMap(batching03Window::processEvents)
                .subscribe(Util.subscriber());
    }



    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(250))
                .map(i -> "event" + (i + 1));
    }

    private static Mono<Void> processEvents(Flux<String> flux){
        return flux.doOnNext(e -> System.out.print("*"))
                .doOnComplete(System.out::println)
                .then();
    }
}
