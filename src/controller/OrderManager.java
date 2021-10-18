package controller;

import model.MilkTea;
import model.Order;

import java.util.List;

public class OrderManager {
    private List<Order>orderList;

    public OrderManager() {
    }

    public List<Order> getOrderList() {
        return orderList;
    }
    public void addNewOrder(Order order){
        orderList.add(order);
    }
    public void editOrder(int index, Order order){
        orderList.set(index,order);
    }
    public void removeOrder(Order order){
        orderList.remove(order);
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
    public void showList(){
        for (Order a:orderList) {
            System.out.println(a);
        }
    }
}
