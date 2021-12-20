package com.example.bookstore.model.view;

public class OrderStatsView {

    private int ordersAboveFiftyBGN;
    private int getOrdersBelowAboveFiftyBGN;

    public OrderStatsView(int ordersAboveFiftyBGN, int getOrdersBelowAboveFiftyBGN) {
        this.ordersAboveFiftyBGN = ordersAboveFiftyBGN;
        this.getOrdersBelowAboveFiftyBGN = getOrdersBelowAboveFiftyBGN;
    }

    public int getTotalOrders(){
        return ordersAboveFiftyBGN + getOrdersBelowAboveFiftyBGN;
    }

    public int getOrdersAboveFiftyBGN() {
        return ordersAboveFiftyBGN;
    }

    public int getGetOrdersBelowAboveFiftyBGN() {
        return getOrdersBelowAboveFiftyBGN;
    }
}
