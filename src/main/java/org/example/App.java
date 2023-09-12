package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        System.out.print("Hello There!");
        int[] price = new int[24];
        Scanner scanner = new Scanner(System.in);
        TimeIntervals timeIntervals = new TimeIntervals();
        boolean shouldExit = false;
        while (!shouldExit) {
            printMenu.menu();
            var choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "1" -> {
                    for (int i = 0; i < price.length; i++) {
                        try {
                            price[i] = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.print("Fel Input, va god skriv in ett heltal");
                        }
                    }
                }
                case "2" -> {
                    int[] results = CheckingTimeMinMax.Check(price);
                    int timeForMin = results[0];
                    int timeForMax = results[1];
                    float sum = results[2];
                    int lowestPrice = price[timeForMin];
                    int highestPrice = price[timeForMax];
                    System.out.print("\nLägsta pris: " + timeIntervals.getTime()[timeForMin] + ", " + lowestPrice + " öre/kWh");
                    System.out.print("\nHögsta pris: " + timeIntervals.getTime()[timeForMax] + ", " + highestPrice + " öre/kWh");
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String averagePrice;
                    if (sum == 0) {
                        averagePrice = "0,00";
                    } else {
                        averagePrice = decimalFormat.format(sum / 24);
                    }
                    System.out.print("\nMedelpris: " + averagePrice + " öre/kWh");
                }
                case "3" -> {
                    PriceTime[] sortedPriceTimes = SortPriceTime.sortPriceTime(price, timeIntervals.getTime());
                    for (PriceTime priceTime : sortedPriceTimes) {
                        String sortedTime = priceTime.getTime();
                        int sortedPrice = priceTime.getPrice();
                        System.out.print("\n" + sortedTime + " " + sortedPrice + " öre");
                    }
                }
                case "4" -> {
                    int cheapestSum = Integer.MAX_VALUE;
                    int bestStartHour = -1;
                    for (int i = 0; i <= price.length - 4; i++) {
                        int result = price[i] + price[i + 1] + price[i + 2] + price[i + 3];
                        if (result < cheapestSum) {
                            cheapestSum = result;
                            bestStartHour = i;
                        }
                    }
                    String formattedBestStartHour = String.format("%02d", bestStartHour);
                    double avgPrice = (double) cheapestSum / 4;
                    DecimalFormat decimalFormat1 = new DecimalFormat("#,#0.0");
                    String formattedAvgPrice = decimalFormat1.format(avgPrice);
                    System.out.print("Påbörja laddning klockan " + formattedBestStartHour + "\n");
                    System.out.print("Medelpris 4h: " + formattedAvgPrice + " öre/kWh");
                }
                case "e" -> shouldExit = true;
                default -> System.out.print("\nOgiltigt val. Försök igen.");
            }
        }

    }

}