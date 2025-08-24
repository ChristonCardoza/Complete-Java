package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux01Just {

    public static void main(String[] args) {
        Flux.just(1,2,3).subscribe(Util.subscriber());
    }
}
