package org.cardoza.sec05;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator03DelayElement {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber("Delay"));

        Util.sleepSeconds(15);
    }
}
