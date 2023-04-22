package Behavioral.State;

public class Client {

    public static void main(String[] args) {
        Order order = new Order();

//        order.cancel();

        order.paymentSuccessful();
        order.dispatched();
        order.cancel();

    }
}
