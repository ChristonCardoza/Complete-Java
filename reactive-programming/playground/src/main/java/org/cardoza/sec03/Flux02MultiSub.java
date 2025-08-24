package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux02MultiSub {

    public static void main(String[] args) {

        var flux = Flux.just(1,2,3,4,5,6);

        flux.subscribe(Util.subscriber("Sub-1"));

        flux.subscribe(Util.subscriber("Sub-2"));

        flux.filter(i -> i % 2 == 0)
                .subscribe(Util.subscriber("Sub-3"));
    }
}
