package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux05Range {

    public static void main(String[] args) {

        var flux = Flux.range(1,10);

        flux.subscribe(Util.subscriber("Subscribe-1"));

        flux.subscribe(Util.subscriber("Subscribe-2"));

        Flux.range(1,10).map(i -> Util.faker().name().firstName()).subscribe(Util.subscriber("RandomNames"));
    }
}
