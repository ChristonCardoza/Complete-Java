package org.cardoza.sec13;

import org.cardoza.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class context02AppendUpdate {

    private static final Logger log = LoggerFactory.getLogger(context02AppendUpdate.class);

    public static void main(String[] args) {

        getWelcomeMessage()
                .contextWrite(ctx -> ctx.put ("user", ctx.get("user").toString().toUpperCase()))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }

    private static void override() {
        getWelcomeMessage()
                .contextWrite(ctx -> Context.of("user", "mike"))
                .contextWrite(Context.of("a", "b").put("c", "d"))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }

    private static void append() {
        getWelcomeMessage()
                .contextWrite(Context.of("a", "b").put("c", "d"))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }


    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            log.info("{}", ctx);
            if(ctx.hasKey("user")){
                return Mono.just("Welcome %s".formatted(ctx.get("user").toString()));
            }

            return Mono.error(new RuntimeException("Unauthenticated"));
        });
    }
}
