import java.util.Scanner;
import java.util.Random;

public class stockMarket {
    public static void main(String[] args) throws InterruptedException {
        // initialize scanner and random
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // user variables
        double cash = 1000.0;

        // stocks
        double NVDA = 200.75;
        int sharesNVDA = 0;
        double AAPL = 308.91;
        int sharesAPPL = 0;

        // introduction
        System.out.println("======");
        System.out.println("STOCKS");

        System.out.println("Welcome to the STOCK MARKET simulator");
        System.out.println("======");
        Thread.sleep(2000);
        System.out.print("\n"); // had to get help, did not know how to clear the terminal in java
        
        // instructions
        System.out.println("How to play:");
        System.out.println("- you start with $1000 cash");
        System.out.println("- Each day, stock prices will change.");
        System.out.println("On your turn, you can: ");
        System.out.println("    - buy shares (if you can afford them lol)");
        System.out.println("    - sell the shares you own");
        System.out.println("    - skip to the next day");

        System.out.println("Goal: ");
        System.out.println("Your goal is to make as much $$$$ as you can.");
        Thread.sleep(3575);
        System.out.print("\n"); // had to get help, did not know how to clear the terminal in java

        // getting to know the playa
        System.out.print("What is your name: ");
        String name = scanner.nextLine();

        System.out.printf("Hi %s%n", name);
        System.out.printf("%s, if you would like to play, press any key and if not, press 'q'.%n", name);
        System.out.print("Your choice: ");
        String playOrNot = scanner.nextLine();

        if (playOrNot.equalsIgnoreCase("q")) { // user does not want to play
            System.out.println("K, thanks for playing");
            System.exit(0);
        }
        else { // user wants to play
            System.out.printf("Good choice %s.%n", name);
            System.out.print("\n".repeat(50)); // had to get help, did not know how to clear the terminal in java
            
            // day 1
            String stockDay1 = "";

            System.out.println("==========");
            System.out.println("  DAY 1");
            System.out.println("==========");
            
            System.out.println("\n");

            // main HUD
            System.out.printf("NVDA : %.2f | Shares onwed : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAPPL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);

            System.out.println("\n");

            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice = scanner.nextLine();

            // day 1 choices

            if (stockChoice.equalsIgnoreCase("buy")) {
                while (true) {
                    System.out.println("What stock do you want to buy: ");
                    String stockBuy1 = scanner.nextLine();

                    if (stockBuy1.equalsIgnoreCase("NVDA") || stockBuy1.equalsIgnoreCase("AAPL")) {
                        stockDay1 = stockBuy1;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid stock!!");
                    }
                }
                
                System.out.println(stockDay1);

                System.out.println("How many shares: ");
                double day1cost = 0;
                int Shares = scanner.nextInt();
                scanner.nextLine();

                // find out the cost of day 1 shares
                if (stockDay1.equalsIgnoreCase("NVDA")) {
                    day1cost = NVDA * Shares;
                }
                else if (stockDay1.equalsIgnoreCase("AAPL")) {
                    day1cost = AAPL * Shares;
                }

                // find out if playa can afford the shares
                if (cash - day1cost > 0) {
                    if (stockDay1.equalsIgnoreCase("NVDA")) {
                        sharesNVDA = Shares;
                        cash = cash - (Shares * NVDA);
                    }
                    else if (stockDay1.equalsIgnoreCase("AAPL")) {
                        sharesAPPL = Shares;
                        cash = cash - (Shares * AAPL);
                    }
                }

            }
            else if (stockChoice.equalsIgnoreCase("sell")) {

            }
            else if (stockChoice.equalsIgnoreCase("skip")) { 
                System.out.println("Skipping day 1. Moving to day 2.");
                System.out.println("\n".repeat(50));
            }
            else {
                System.out.println("Invalid input. Moving onto the next day.");
                System.out.println("\n".repeat(50));
            }

        }
    }
}