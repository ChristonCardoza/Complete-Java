package org.cardoza.sec12;

import org.cardoza.common.Util;
import reactor.core.publisher.Sinks;

public class sinks04SinkMulticast {

    public static void main(String[] args) {

        demo1();

    }


    private static void demo1(){
        var sink = Sinks.many().multicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are your");
        sink.tryEmitNext("?");

        Util.sleepSeconds(2);

        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new message");
    }
}
