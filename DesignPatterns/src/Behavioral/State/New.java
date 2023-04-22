package Behavioral.State;

public class New implements OrderState {


    @Override
    public double handleCancellation() {
        System.out.println("It's a new Order. No processing is done");
        return 0;
    }
}
