package org.cardoza.sec04;

import org.cardoza.common.Util;
import org.cardoza.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Flux02CreateRefactor {

    public static void main(String[] args) {

        var generator = new NameGenerator();
        var flux = Flux.create(generator);

        flux.subscribe(Util.subscriber("Refactor"));

        for(int i=0; i<10; i++){
            generator.generate();
        }
    }
}
