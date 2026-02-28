package org.cardoza.sec09;

import org.cardoza.common.Util;
import org.cardoza.sec09.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class combining02StartWithUsecase {

    private static final Logger log = LoggerFactory.getLogger(combining02StartWithUsecase.class);

    public static void main(String[] args) {

        var nameGenerator = new NameGenerator();

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));

    }


}
