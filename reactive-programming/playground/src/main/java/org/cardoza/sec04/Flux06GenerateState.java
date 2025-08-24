package org.cardoza.sec04;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux06GenerateState {

    public static void main(String[] args) {

        Flux.generate(
                () -> 0,
                (counter, sink) -> {
                    var country = Util.faker().country().name();
                    sink.next(country);
                    counter++;
                    if(counter == 10 || country.equalsIgnoreCase("canada")){
                        sink.complete();
                    }
                    return counter;
                }
        ).subscribe(Util.subscriber("Generate-State"));
    }
}
