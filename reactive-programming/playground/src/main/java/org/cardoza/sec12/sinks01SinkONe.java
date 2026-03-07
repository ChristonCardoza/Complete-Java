package org.cardoza.sec12;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Sinks;

public class sinks01SinkONe {

    private static final Logger log = LoggerFactory.getLogger(sinks01SinkONe.class);

    public static void main(String[] args) {

//        demo1();

//        demo2();

//        demo3();

//        demo4();

        demo5();
    }

    private static void demo1() {
        var sink = Sinks.one();
        var mono = sink.asMono();

        mono.subscribe(Util.subscriber());
        sink.tryEmitValue("hi");
    }

    private static void demo2() {
        var sink = Sinks.one();
        var mono = sink.asMono();

        mono.subscribe(Util.subscriber());
        sink.tryEmitEmpty();
    }

    private static void demo3() {
        var sink = Sinks.one();
        var mono = sink.asMono();

        mono.subscribe(Util.subscriber());
        sink.tryEmitError(new RuntimeException("oops"));
    }

    private static void demo4() {
        var sink = Sinks.one();
        var mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("tom"));

        sink.tryEmitValue("hi");
    }

    private static void demo5() {
        var sink = Sinks.one();
        var mono = sink.asMono();

        mono.subscribe(Util.subscriber());

        sink.emitValue("hi", (((signalType, emitResult) -> {
            log.info(signalType.name());
            log.info(emitResult.name());
            return false;
        }
                )));

        sink.emitValue("hello ", (((signalType, emitResult) -> {
            log.info(signalType.name());
            log.info(emitResult.name());
            return false;
        }
        )));
    }
}
