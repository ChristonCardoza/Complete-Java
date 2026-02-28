package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combining05merge {

    private static final Logger log = LoggerFactory.getLogger(combining05merge.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

        demo3();

        Util.sleepSeconds(3);
    }

    private static void demo1() {
        Flux.merge(producer1(), producer2(), producer3())
                .subscribe(Util.subscriber());
    }

    private static void demo2() {
        Flux.merge(producer1(), producer2(), producer3())
                .take(2)
                .subscribe(Util.subscriber());
    }

    private static void demo3() {
        producer1().mergeWith(producer3()).mergeWith(producer2())
                .take(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> producer1() {
        return Flux.just(1,2,3)
                .transform(Util.fluxLogger("producer-1"))
                .delayElements(Duration.ofMillis(10));
    }

    private static Flux<Integer> producer2() {
        return Flux.just(51,52,53)
                .transform(Util.fluxLogger("producer-2"))
                .delayElements(Duration.ofMillis(10));
    }

    private static Flux<Integer> producer3() {
        return Flux.just(11,12,13)
                .transform(Util.fluxLogger("producer-3"))
                .delayElements(Duration.ofMillis(10));
    }
}
