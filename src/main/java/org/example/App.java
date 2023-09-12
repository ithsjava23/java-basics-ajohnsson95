package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        int[] price = new int[24];
        Scanner scanner = new Scanner(System.in);
        TimeIntervals timeIntervals = new TimeIntervals();

        while (true) {
            printMenu.menu();
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {

                case "1":
                    System.out.print("""
                            Va god och mata in elpriserna under dygnets timmar,
                            priser räknas i hela ören och priset sätts per intervall
                            mellan två hela timmar börjar 00-01""");
                    for (int i = 0; i < 24; i++) {
                        System.out.print("\nTimintervall " + timeIntervals.getTime()[i]+ "\n");
                        price[i] = scanner.nextInt();
                    }
                    break;
                case "2":
                    System.out.print("\nLägsta pris, högsta pris och medelvärde");
                    int[] results = CheckingTimeMinMax.Check(price);
                    int timeForMin = results[0];
                    int timeForMax = results[1];
                    float sum = results[2];
                    int lowestPrice = price[timeForMin];
                    int highestPrice = price[timeForMax];
                    System.out.print("\nLägsta pris är " + lowestPrice + " ören mellan " + timeIntervals.getTime()[timeForMin]);
                    System.out.print("\nHögsta pris är " + highestPrice + " ören mellan " + timeIntervals.getTime()[timeForMax]);
                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
                    String averagePrice = decimalFormat.format(sum / 24);
                    System.out.print("\nMedelvärdet är " + averagePrice + "ören");
                    break;
                case "3":
                    System.out.print("\nSortera ut priset från dyrast till billigast");
                    PriceTime[] sortedPriceTimes = SortPriceTime.sortPriceTime(price, timeIntervals.getTime());
                    for (PriceTime priceTime : sortedPriceTimes) {
                        String sortedTime = priceTime.getTime();
                        int sortedPrice = priceTime.getPrice();
                        System.out.print("\n" + sortedTime + " " + sortedPrice + " öre");
                    }
                    break;
                case "4":

                    int cheapestSum = Integer.MAX_VALUE;
                    int bestStartHour = -1;

                    for (int i = 0; i <= price.length - 4; i++) {
                        int result = price[i] + price[i + 1] + price[i + 2] + price[i + 3];
                        if (result < cheapestSum) {
                            cheapestSum = result;
                            bestStartHour = i;
                        }
                    }

                    String formattedBestStartHour = String.format("%02d:00", bestStartHour);
                    double avgPrice = (double) cheapestSum / 4;
                    System.out.print("\nBästa laddningstid (4h) börjar kl " + formattedBestStartHour + "\n");
                    System.out.printf(" Medelpris under dessa 4 timmar: %.2f öre%n", avgPrice);
                    break;
                case "e":
                    System.out.print("\nProgrammet avslutas.");
                    System.exit(0);
                default:
                    System.out.print("\nOgiltigt val. Försök igen.");
                    break;

            }
        }
    }
}