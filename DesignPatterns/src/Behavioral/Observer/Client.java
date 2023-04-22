package Behavioral.Observer;

public class Client {

    public static void main(String[] args) {

        Order order = new Order("100");
        PriceObserver price = new PriceObserver();

        order.attach(price);

        order.addItem(50);
        order.addItem(180);
        System.out.println(order);
    }
}
