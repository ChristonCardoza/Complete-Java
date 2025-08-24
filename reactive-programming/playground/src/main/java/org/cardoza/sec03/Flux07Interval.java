package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Flux07Interval {

    public static void main(String[] args) {

        Flux
                .interval(Duration.ofMillis(500))
                .map(i -> Util.faker().name().firstName())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
