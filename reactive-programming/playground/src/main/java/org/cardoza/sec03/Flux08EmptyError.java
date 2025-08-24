package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

public class Flux08EmptyError {

    public static void main(String[] args) {

        Flux.empty().subscribe(Util.subscriber("Empty"));

        Flux.error(new RuntimeException("oops")).subscribe(Util.subscriber("Error"));
    }
}
