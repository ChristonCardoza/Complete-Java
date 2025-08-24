package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux06Log {

    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .map(i -> Util.faker().name().firstName())
                .log()
                .subscribe(Util.subscriber("RandomNames"));
    }

}
