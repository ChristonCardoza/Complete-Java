package org.cardoza.sec03;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Flux03fromIterable {


    public static void main(String[] args) {

        var list = List.of("a", "b", "c");

         Flux.fromIterable(list).subscribe(Util.subscriber("Iterable"));

         Integer[] arr = {1,2,3,4,5,6};

         Flux.fromArray(arr).subscribe(Util.subscriber("Array"));
    }
}
