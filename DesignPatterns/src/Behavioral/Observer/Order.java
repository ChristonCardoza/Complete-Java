package Behavioral.Observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//A concrete subject
public class Order {

    private String id;

    public double getShippingCost() {
        return shippingCost;
    }

    private double shippingCost;
    //cost of items
    private double itemCost;

    private double discount;
    //no of items
    private int count;

    public Order(String id) {
        this.id = id;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return itemCost - discount + shippingCost;
    }

    public void addItem(double price) {
        itemCost += price;
        count ++;
        observers.forEach(o -> o.updated(this));
    }

    public int getCount() {
        return count;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getItemCost() {
        return itemCost;
    }

    @Override
    public String toString() {

        return "Order#"+id+"\nItem cost:"+itemCost+"\nNo. of items:"+count
                +"\nShipping cost:"+shippingCost+"\nDiscount:"+discount
                +"\nTotal:"+getTotal();
    }

    private List<OrderObserver> observers = new ArrayList<>();

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }
}
