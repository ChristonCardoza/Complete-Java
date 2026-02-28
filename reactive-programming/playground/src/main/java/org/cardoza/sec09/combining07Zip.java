package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class combining07Zip {

    private static final Logger log = LoggerFactory.getLogger(combining07Zip.class);

    record Car(String body, String engine, String tires){}

    public static void main(String[] args) {

        Flux.zip(getBody(), getEngine(), getTires())
                .map(t ->  new Car(t.getT1(), t.getT2(), t.getT3()))
                        .subscribe(Util.subscriber());

        Util.sleepSeconds(3);
    }


    private static Flux<String> getBody() {
        return Flux.range(1,5)
                .map(i -> "body-" + i)
                .transform(Util.fluxLogger("body"))
                .delayElements(Duration.ofMillis(100));
    }

    private static Flux<String> getEngine() {
        return Flux.range(1,3)
                .map(i -> "engine-" + i)
                .transform(Util.fluxLogger("engine"))
                .delayElements(Duration.ofMillis(200));
    }

    private static Flux<String> getTires() {
        return Flux.range(1,10)
                .map(i -> "tiers-" + i)
                .transform(Util.fluxLogger("tiers"))
                .delayElements(Duration.ofMillis(75));
    }
}
