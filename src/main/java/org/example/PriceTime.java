package org.example;

public class PriceTime {
    public int price;
    public String time;

    public PriceTime(int price, String time) {
        this.price = price;
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }
}