package org.example;

public class CheckingTimeMinMax{
    public static int[] Check(int[] price) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int timeForMin = 0;
        int timeForMax = 0;
        int sum = 0;
        for (int i = 0; i < price.length; i++) {
            if (price[i] < min) {
                min = price[i];
                timeForMin = i;
            }
            if (price[i] > max) {
                max = price[i];
                timeForMax = i;
            }
            sum += price[i];

        }
        return new int[]{timeForMin, timeForMax, sum};
    }
}
