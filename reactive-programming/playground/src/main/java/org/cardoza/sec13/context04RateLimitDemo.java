package org.cardoza.sec13;


import org.cardoza.common.Util;
import org.cardoza.sec13.client.ExternalServiceClient;
import reactor.util.context.Context;

public class context04RateLimitDemo {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        for(int i=0; i<20; i++){
            client.getBook()
                    .contextWrite(Context.of("user", "sam"))
                    .subscribe(Util.subscriber());

            Util.sleepSeconds(5);
        }

        Util.sleepSeconds(5);
    }
}
