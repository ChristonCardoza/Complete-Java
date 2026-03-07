package org.cardoza.sec10;

import org.cardoza.common.Util;
import org.cardoza.sec10.assignment.window.FileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class batching04WindowAssignment {

    private static final Logger log = LoggerFactory.getLogger(batching04WindowAssignment.class);

    public static void main(String[] args) {

        var counter = new AtomicInteger(0);
        var fileNameFormat = "playground/src/main/resources/sec10/filed%d.txt";

        eventStream()
                .window(Duration.ofMillis(1800))
                .flatMap(flux -> FileWriter.create(flux, Path.of(fileNameFormat.formatted(counter.incrementAndGet()))))
                .subscribe();

        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(250))
                .map(i -> "event" + (i + 1));
    }

}
