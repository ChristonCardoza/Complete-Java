package org.cardoza.sec01;

import org.cardoza.sec01.publisher.PublisherImpl;
import org.cardoza.sec01.subscriber.SubscriberImpl;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
//        demo1();

//        demo2();

//        demo3();

        demo4();
    }

    public static void demo1(){

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
    }

    public static void demo2() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));
    }

    public static void demo3() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(3);
        Thread.sleep(Duration.ofSeconds(2));

        subscriber.getSubscription().cancel();
        Thread.sleep(Duration.ofSeconds(2));

        subscriber.getSubscription().request(3);
    }

    public static void demo4() throws InterruptedException {

        var publisher = new PublisherImpl();
        var subscriber = new SubscriberImpl();
        publisher.subscribe(subscriber);
        subscriber.getSubscription().request(11);

    }
}
