package org.example;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        int[] price = new int[24];
        Scanner scanner = new Scanner(System.in);
        TimeIntervals timeIntervals = new TimeIntervals();
        while (true) {
            System.out.print("""
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och medel
                    3. Sortera
                    4. Bästa laddningstid(4h)
                    e. Avsluta""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("""
                            Va god och mata in elpriserna under dygnets timmar,
                            priser räknas i hela ören och priset sätts per intervall
                            mellan två hela timmar börjar 00-01""");
                    for (int i = 0; i < 24; i++) {
                        System.out.print("\nTimintervall " + timeIntervals.getTime()[i]);
                        price[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    System.out.print("\nLägsta pris, högsta pris och medelvärde");
                    int[] results = CheckingTimeMinMax.Check(price);
                    int timeForMin = results[0];
                    int timeForMax = results[1];
                    int sum = results[2];
                    int lowestPrice = price[timeForMin];
                    int highestPrice = price[timeForMax];
                    System.out.print("\nLägsta pris är " + lowestPrice + " ören mellan " + timeIntervals.getTime()[timeForMin]);
                    System.out.print("\nHögsta pris är " + highestPrice + " ören mellan " + timeIntervals.getTime()[timeForMax]);
                    System.out.print("\nMedelvärdet är " + (sum / 24));

                    break;
                case 3:
                    System.out.print("\nSortera ut priset från dyrast till billigast");
                    PriceTime[] sortedPriceTimes = SortPriceTime.SortPriceTime(price, timeIntervals.getTime());
                    for (PriceTime priceTime : sortedPriceTimes) {
                        String sortedTime = priceTime.getTime();
                        int sortedPrice = priceTime.getPrice();
                        System.out.print("\nmellan " + sortedTime + " " + sortedPrice + " öre" );
                    }

                    break;
                case 4:
                    System.out.print("\nYou selected Option 4");
                    // Add code for Option 4 here
                    break;
                case 'e', 'E':
                    System.out.print("\nAvsluta");
                    System.exit(0);
                    //default:
                    //System.out.println("");
            }
        }
    }
}
