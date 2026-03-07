package org.cardoza.sec12;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class sinks03SinkThreadSafety {

    private static final Logger log = LoggerFactory.getLogger(sinks03SinkThreadSafety.class);

    public static void main(String[] args) {

//        demo1();

        demo2();
    }

    private static void demo1(){
         var sink = Sinks.many().unicast().onBackpressureBuffer();

         var flux = sink.asFlux();

         var list = new ArrayList<>();
         flux.subscribe(list::add);

         for(int i=0; i<1000; i++) {
             int finalI = i;
             CompletableFuture.runAsync(() -> {
                 sink.tryEmitNext(finalI);
             });
         }

         Util.sleepSeconds(2);

         log.info("list size: {}", list.size());
    }

    private static void demo2(){
        var sink = Sinks.many().unicast().onBackpressureBuffer();

        var flux = sink.asFlux();

        var list = new ArrayList<>();
        flux.subscribe(list::add);

        for(int i=0; i<1000; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> {
                sink.emitNext(finalI, (singnal, emitResult)-> {
                    return Sinks.EmitResult.FAIL_NON_SERIALIZED.equals(emitResult);
                });
            });
        }

        Util.sleepSeconds(2);

        log.info("list size: {}", list.size());
    }


}
