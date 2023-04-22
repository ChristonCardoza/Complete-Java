package Behavioral.Observer;

//Concrete observer
public class PriceObserver implements OrderObserver{

    @Override
    public void updated(Order order) {
        double total = order.getItemCost();

        if(total >= 200) {
            order.setDiscount(10);
        } else if(total >= 500) {
            order.setDiscount(20);
        }
    }
}
