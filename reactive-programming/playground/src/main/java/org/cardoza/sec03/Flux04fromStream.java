package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Flux04fromStream {

    public static void main(String[] args) {

        var list = List.of(1,2,3,4);

//        var stream = list.stream();
//        var flux = Flux.fromStream(stream);

        var flux = Flux.fromStream(() -> list.stream());

        flux.subscribe(Util.subscriber("Stream1"));
        flux.subscribe(Util.subscriber("Stream2"));
    }
}
