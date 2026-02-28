package org.cardoza.sec06;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class pub02HotPub {

    private static final Logger log = LoggerFactory.getLogger(pub02HotPub.class);

    public static void main(String[] args) {

        var movieFlux = movieSteam().share();

        Util.sleepSeconds(2);

        movieFlux.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(3);

        movieFlux.subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(15);
    }

    private static Flux<String> movieSteam() {

        return Flux.generate(
                () -> {
                    ;log.info("received the request");
                    return 1;
                },
                (state, sink) -> {
                    var scene = "movie scene " + state;
                    log.info("playing {}", scene);
                    sink.next(scene);
                    return ++state;
                }
        )
                .take(10)
                .delayElements(Duration.ofSeconds(1))
                .cast(String.class);
    }
}
