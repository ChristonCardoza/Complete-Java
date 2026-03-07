package org.cardoza.sec12;

import org.cardoza.common.Util;
import reactor.core.publisher.Sinks;

public class sinks02SinkUnicast {

    public static void main(String[] args) {

//        demo1();

        demo2();
    }

    private static void demo1(){
         var sink = Sinks.many().unicast().onBackpressureBuffer();

         var flux = sink.asFlux();

         sink.tryEmitNext("hi");
         sink.tryEmitNext("how are your");
         sink.tryEmitNext("?");

         flux.subscribe(Util.subscriber("sam"));
    }

    private static void demo2(){
        var sink = Sinks.many().unicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are your");
        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
    }
}
