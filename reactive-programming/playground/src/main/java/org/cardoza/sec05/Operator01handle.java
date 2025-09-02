package org.cardoza.sec05;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Operator01handle {

    public static void main(String[] args) {

        Flux.range(1,10)
                .handle((item, sink) -> {
                    switch (item) {
                        case 1 -> sink.next(-2);
                        case 4 -> {}
                        case 7 -> sink.error(new IllegalArgumentException("error"));
                        default -> sink.next(item);
                    }
                }).subscribe(Util.subscriber("Handle"));
    }
}
