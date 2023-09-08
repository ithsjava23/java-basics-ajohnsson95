package org.example;

public class SortPriceTime {
    public static PriceTime[] sortPriceTime(int[] price, String[] times) {
        PriceTime[] priceTimes = new PriceTime[24];


        for (int i = 0; i < 24; i++) {
            priceTimes[i] = new PriceTime(price[i], times[i]);
        }
        for (int i = 0; i < 23; i++) {
            for (int j = 0; j < 23 - i; j++) {
                if (priceTimes[j].getPrice() < priceTimes[j + 1].getPrice()) {
                    // Swap priceTimes[j] and priceTimes[j + 1]
                    PriceTime temp = priceTimes[j];
                    priceTimes[j] = priceTimes[j + 1];
                    priceTimes[j + 1] = temp;
                }
            }
        }
        return priceTimes;
    }
}