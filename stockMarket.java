import java.util.Scanner;
import java.util.Random;

// MAKE SURE to learn for loops and other data types in java and then revisit this game after, make it more efficient

public class stockMarket {
    public static void main(String[] args) throws InterruptedException {
        // initialize scanner and random
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // user variables
        double cash = 1000.0;
        // stock fluctuations
        double low = -0.15;
        double high = 0.15;
        double randomChange = (double)(Math.random() * (high-low) + low); 
    
        double randomEventNum = Math.random(); // only for CRAZY tragic/good events (day 5)

        // stocks
        double NVDA = 200.75;
        int sharesNVDA = 0;
        double AAPL = 308.91;
        int sharesAAPL = 0;
        double GOOGL = 370.93;
        int sharesGOOGL = 0;

        // ADD one or 2 more stocks

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
        System.out.println("    - in any secondary input field, type 'back' to go back");
        System.out.println("    - in any primary input field, type 'exit' to exit the game");
        System.out.print("\n");

        System.out.println("Goal: ");
        System.out.println("Your goal is to make as much $$$$ as you can.");
        Thread.sleep(3000);
        System.out.print("\n"); // had to get help, did not know how to clear the terminal in java

        // getting to know the playa
        System.out.print("What is your name: ");
        String name = scanner.nextLine();

        System.out.print("\n");

        System.out.printf("Hi %s%n", name);
        System.out.print("\n");
        System.out.printf("%s, if you would like to play, press any key and if not, press 'q'.%n", name);
        System.out.print("\n");
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
            // String stockDay1 = "";

            // System.out.println("==========");
            // System.out.println("  DAY 1");
            // System.out.println("==========");
            
            // System.out.println("\n");

            // // main HUD
            // System.out.printf("NVDA : %.2f | Shares onwed : %d%n", NVDA, sharesNVDA);
            // System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            // System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
            // System.out.println("-------------------------------");
            // System.out.printf("Cash : %.2f%n", cash);

            // System.out.println("\n");

            while (true) {
            // day 1
            String stockDay1 = "";

            System.out.println("==========");
            System.out.println("  DAY 1");
            System.out.println("==========");
            
            System.out.println("\n");
                
            // main HUD
            System.out.printf("NVDA : %.2f | Shares onwed : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
            System.out.println("-------------------------------");
            System.out.printf("Cash : %.2f%n", cash);

            System.out.println("\n");

            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice1 = scanner.nextLine();
            String stockBuy1 = "";

            // day 1 choices

            if (stockChoice1.equalsIgnoreCase("buy")) {
                while (true) {
                        System.out.println("What stock do you want to buy: ");
                        stockBuy1 = scanner.nextLine();

                        if (stockBuy1.equalsIgnoreCase("back")) {
                            break; // if want to back out
                        }

                        if (stockBuy1.equalsIgnoreCase("NVDA") || stockBuy1.equalsIgnoreCase("AAPL") || stockBuy1.equalsIgnoreCase("GOOGL")) {
                            stockDay1 = stockBuy1;
                            break;
                        }
                        else {
                            System.out.println("Enter a valid stock!!");
                        }
                    }

                    if (stockBuy1.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                        continue; 
                    }

                    double day1cost = 0;
                    int Shares = 0;

                    while (true) {
                        System.out.print("How many shares: ");

                        if (scanner.hasNextInt()) {
                            Shares = scanner.nextInt();
                            scanner.nextLine();
                            if (Shares <= 0) {
                                System.out.println("Invalid Input!");
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            System.out.println("INVALID input!!");

                            scanner.nextLine();
                        }
                    }

                    // find out the cost of day 1 shares
                    if (stockDay1.equalsIgnoreCase("NVDA")) {
                        day1cost = NVDA * Shares;
                    }
                    else if (stockDay1.equalsIgnoreCase("AAPL")) {
                        day1cost = AAPL * Shares;
                    }
                    else if (stockDay1.equalsIgnoreCase("GOOGL")) {
                        day1cost = GOOGL * Shares;
                    }

                    // find out if playa can afford the shares
                    if (cash >= day1cost) {
                        if (stockDay1.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day1cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day1cost);
                            System.out.println("\n".repeat(50));
                            // break;
                        }
                        else if (stockDay1.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day1cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day1cost);
                            System.out.println("\n".repeat(50));
                            // break;
                        }
                        else if (stockDay1.equalsIgnoreCase("GOOGL")) {
                            sharesGOOGL += Shares;
                            cash -= day1cost;
                            System.out.printf("Bought %d shares of GOOGL for %.2f.%n", Shares, day1cost);
                            System.out.println("\n".repeat(50));
                            // break;                            
                        }
                    }
                    else {
                        System.out.println("Cant afford it.");
                    }
                    
                } 
                else if (stockChoice1.equalsIgnoreCase("sell")) {
                        System.out.println("Its the first day, you don't have anything to sell.");
                }
                else if (stockChoice1.equalsIgnoreCase("skip")) { 
                        System.out.println("Skipping day 1. Moving to day 2.");
                        System.out.println("\n".repeat(50));
                        break;
                }
                else if (stockChoice1.equalsIgnoreCase("exit")){
                    System.exit(0);
                }
                else {
                        System.out.println("Invalid input. CMON!!!");
                    }
            }

            // day 2
            String stockDay2 = "";

            System.out.println("==========");
            System.out.println("  DAY 2");
            System.out.println("==========");
            
            System.out.println("\n");

            // // stock fluctuations
            // double low = -0.15;
            // double high = 0.15;
            // double randomChange = (double)(Math.random() * (high-low) + low);

            NVDA = (NVDA * randomChange) + NVDA;
            AAPL = (AAPL * randomChange) + AAPL;
            GOOGL = (GOOGL * randomChange) + GOOGL;

            // main HUD
            System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);

            System.out.println("\n");

            while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice2 = scanner.nextLine();
            String stockBuy2 = "";

                if (stockChoice2.equalsIgnoreCase("buy")) {
                    while (true) {
                        System.out.print("What stock do you want to buy: ");
                        stockBuy2 = scanner.nextLine();

                        if (stockBuy2.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                        if (stockBuy2.equalsIgnoreCase("NVDA") || stockBuy2.equalsIgnoreCase("AAPL") || stockBuy2.equalsIgnoreCase("GOOGL")) {
                            stockDay2 = stockBuy2;
                            break;
                        }
                        else {
                            System.out.println("Enter a valid stock!!");
                        }
                    }

                    if (stockBuy2.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                        continue; 
                    }   
                    
                    double day2cost = 0;
                    int Shares = 0;

                    while (true) {
                        System.out.print("How many shares: ");

                        if (scanner.hasNextInt()) {
                            Shares = scanner.nextInt();
                            scanner.nextLine();
                            if (Shares <= 0) {
                                System.out.println("INVALID input!!");
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            System.out.println("INVALID input!!");

                            scanner.nextLine();
                        }
                    }

                    // find out the cost of day 2 shares
                    if (stockDay2.equalsIgnoreCase("NVDA")) {
                        day2cost = NVDA * Shares;
                    }
                    else if (stockDay2.equalsIgnoreCase("AAPL")) {
                        day2cost = AAPL * Shares;
                    }
                    else if (stockDay2.equalsIgnoreCase("GOOGL")) {
                        day2cost = GOOGL * Shares;
                    }

                    // find out if playa can afford the shares
                    if (cash >= day2cost) {
                        if (stockDay2.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day2cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day2cost);
                            // System.out.println("Moving to day 3.");
                            // break;
                        }
                        else if (stockDay2.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day2cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day2cost);
                            // System.out.println("Moving to day 3.");
                            // break;
                        }
                        else if (stockDay2.equalsIgnoreCase("GOOGL")) {
                            sharesGOOGL += Shares;
                            cash -= day2cost;
                            System.out.printf("Bought %d shares of GOOGL for %.2f.%n", Shares, day2cost);
                            // System.out.println("Moving to day 3.");
                            // break;
                        }
                    }
                    else {
                        System.out.println("Cant afford it.");
                    }
                } 

                else if (stockChoice2.equalsIgnoreCase("sell")) {
                    String stockSell2 = "";
                    while (true) {
                        System.out.println("What stock do you want to sell: ");
                        stockSell2 = scanner.nextLine();
                        
                        if (stockSell2.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                        if (stockSell2.equalsIgnoreCase("NVDA") || stockSell2.equalsIgnoreCase("AAPL") || stockSell2.equalsIgnoreCase("GOOGL")) {
                            int shareSell2 = 0;

                            while (true) {
                                System.out.printf("How many shares of %s would you like to sell: ", stockSell2);
                            
                                if (scanner.hasNextInt()) {
                                    shareSell2 = scanner.nextInt();
                                    scanner.nextLine();
                                    break;
                                }
                                else {
                                    System.out.println("INVALID input!!");
                                
                                    scanner.nextLine();
                                }
                            }

                            // sell NVDA
                            if (stockSell2.equalsIgnoreCase("NVDA") && shareSell2 > 0 && sharesNVDA >= shareSell2) {
                                double returnValue = shareSell2 * NVDA;
                                sharesNVDA -= shareSell2;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell2, stockSell2, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            // sell AAPL
                            else if (stockSell2.equalsIgnoreCase("AAPL") && shareSell2 > 0 && sharesAAPL >= shareSell2) {
                                double returnValue = shareSell2 * AAPL;
                                sharesAAPL -= shareSell2;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell2, stockSell2, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            // sell google
                            else if (stockSell2.equalsIgnoreCase("GOOGL") && shareSell2 > 0 && sharesGOOGL >= shareSell2) {
                                double returnValue = shareSell2 * GOOGL;
                                sharesGOOGL -= shareSell2;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell2, stockSell2, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            else {
                                System.out.printf("You don't own that many shares of %s%n", stockSell2);
                                continue;
                            }
                        }
                        else if (!stockSell2.equalsIgnoreCase("back")) {
                            System.out.println("Enter a valid stock to sell!!");
                        }
                    }

                if (!stockSell2.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                    break; 
                }

                }
                else if (stockChoice2.equalsIgnoreCase("skip")) {
                    System.out.println("Skipping to day 3.");
                    System.out.println("\n".repeat(50));
                    break;
                }
                else if (stockChoice2.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                else {
                    System.out.println("Enter a valid choice!!");
                }
            }

            // day 3
            String stockDay3 = "";
        
            System.out.println("==========");
            System.out.println("  Day 3");
            System.out.println("==========");
        
            System.out.println("\n");

            // stock fluctuations
            // System.out.println(NVDA);

            NVDA = NVDA + (NVDA * randomChange);
            AAPL = AAPL + (AAPL * randomChange);
            GOOGL = GOOGL + (GOOGL * randomChange);

            // System.out.println("NVDA");

            // make sure the random event works for the new stock of google
            if (randomEventNum >= 0.67) {
                NVDA = NVDA * 1.20; // price surge so nvda is 20% up
                System.out.println("NVDA made too many potato chips so they are up 20%!!");
                System.out.println("\n");
            }
            else if (randomEventNum <= 0.33 || randomEventNum >= 0.66) {
                AAPL = AAPL * 0.85;
                System.out.println("AAPL is down 15% coz ..."); 
                System.out.println("\n");
            }
            else {
                GOOGL = GOOGL * 1.125; // tried to put googl somewhere in the middle of the price surge (somewhere between 0.85 and 1.20)
                System.out.println("GOOGL is up 15%!?");
                System.out.println("BUT WHY? I guess people are using a lot of gemini");
                System.out.println("\n");
            }
        
            // main HUD
            System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);
        
            System.out.println("\n");

            while (true) {
                System.out.print("What do you want to do (type buy/sell/skip): ");
                String stockChoice3 = scanner.nextLine();
                String stockBuy3 = "";

                if (stockChoice3.equalsIgnoreCase("buy")) {
                    while (true) {
                        System.out.print("What stock do you want to buy: ");
                        stockBuy3 = scanner.nextLine();

                        if (stockBuy3.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                        if (stockBuy3.equalsIgnoreCase("NVDA") || stockBuy3.equalsIgnoreCase("AAPL") || stockBuy3.equalsIgnoreCase("GOOGL")) {
                            stockDay3 = stockBuy3;
                            break;
                        }
                        else {
                            System.out.println("Enter a valid stock!!");
                        }
                    }

                if (stockBuy3.equalsIgnoreCase("back")) {
                    continue; 
                }

                    double day3cost = 0;
                    int Shares = 0;

                    while (true) {
                        System.out.print("How many shares: ");

                        if (scanner.hasNextInt()) {
                            Shares = scanner.nextInt();
                            scanner.nextLine();
                            if (Shares <= 0) {
                                System.out.println("INDVALID INPUT!");
                            } else {
                                break;
                            }
                        }
                        else {
                            System.out.println("INVALID input!!");

                            scanner.nextLine();
                        }
                    }

                    // find out the cost of day 3 shares
                    if (stockDay3.equalsIgnoreCase("NVDA")) {
                        day3cost = NVDA * Shares;
                    }
                    else if (stockDay3.equalsIgnoreCase("AAPL")) {
                        day3cost = AAPL * Shares;
                    }
                    else if (stockDay3.equalsIgnoreCase("GOOGL")) {
                        day3cost = GOOGL * Shares;
                    }

                    // find out if playa can afford the shares
                    if (cash >= day3cost) {
                        if (stockDay3.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day3cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day3cost);
                            // System.out.println("Moving to day 4.");
                            // break;
                        }
                        else if (stockDay3.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day3cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day3cost);
                            // System.out.println("Moving to day 4.");
                            // break;
                        }
                        else if (stockDay3.equalsIgnoreCase("GOOGL")) {
                            sharesGOOGL += Shares;
                            cash -= day3cost;
                            System.out.printf("Bought %d shares of GOOGL for %.2f.%n", Shares, day3cost);
                            // System.out.println("Moving to day 4.");
                            // break;
                        }
                    }
                    else {
                        System.out.println("Cant afford it.");
                    }
            
                } 
                else if (stockChoice3.equalsIgnoreCase("sell")) {

                    String stockSell3 = "";
                    while (true) {
                        System.out.println("What stock do you want to sell: ");
                        stockSell3 = scanner.nextLine();
                        
                        if (stockSell3.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                        if (stockSell3.equalsIgnoreCase("NVDA") || stockSell3.equalsIgnoreCase("AAPL") || stockSell3.equalsIgnoreCase("GOOGL")) {
                            int shareSell3 = 0;

                        while (true) {
                            System.out.printf("How many shares of %s would you like to sell: ", stockSell3);
                        
                            if (scanner.hasNextInt()) {
                                shareSell3 = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            }
                            else {
                                System.out.println("INVALID input!!");
                            
                                scanner.nextLine();
                            }
                        }

                            // sell NVDA
                            if (stockSell3.equalsIgnoreCase("NVDA") && shareSell3 > 0 && sharesNVDA >= shareSell3) { // fixed the input error for sell
                                double returnValue = shareSell3 * NVDA;
                                sharesNVDA -= shareSell3;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell3, stockSell3, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            // sell AAPL
                            else if (stockSell3.equalsIgnoreCase("AAPL") && shareSell3 > 0 && sharesAAPL >= shareSell3) {
                                double returnValue = shareSell3 * AAPL;
                                sharesAAPL -= shareSell3;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell3, stockSell3, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            // sell GOGl
                            else if (stockSell3.equalsIgnoreCase("GOOGL") && shareSell3 > 0 && sharesGOOGL >= shareSell3) {
                                double returnValue = shareSell3 * GOOGL;
                                sharesGOOGL -= shareSell3;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell3, stockSell3, returnValue);
                                // System.out.println("\n".repeat(50));
                                // break;
                            }
                            else {
                                System.out.printf("You don't own that many shares of %s%n", stockSell3);
                                continue;
                            }
                        }
                        else {
                            System.out.println("Enter a valid stock to sell!!");
                            continue;
                        }
                    }

                    if (!stockSell3.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                        break; 
                    }

                }
                else if (stockChoice3.equalsIgnoreCase("skip")) {
                    System.out.println("\n".repeat(50));
                    break;
                }
                else if (stockChoice3.equalsIgnoreCase("exit")) {
                    System.exit(0);
                }
                else {
                    System.out.println("Enter a valid choice!!");
                }
            }
        }
            
        // day 4
        String stockDay4 = "";
    
        System.out.println("==========");
        System.out.println("  Day 4");
        System.out.println("==========");
    
        System.out.println("\n");
        
        // add stock fluctuations here
        NVDA = NVDA + (NVDA * randomChange);
        AAPL = AAPL + (AAPL * randomChange);
        GOOGL = GOOGL + (GOOGL * randomChange); 
    
        // main HUD
        System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
        System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
        System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
        System.out.println("------------------------------");
        System.out.printf("Cash : %.2f%n", cash);
    
        System.out.println("\n");
        while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice4 = scanner.nextLine();
            String stockBuy4 = "";

            if (stockChoice4.equalsIgnoreCase("buy")) {
                while (true) {
                    System.out.print("What stock do you want to buy: ");
                    stockBuy4 = scanner.nextLine();

                    if (stockBuy4.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                    }

                    if (stockBuy4.equalsIgnoreCase("NVDA") || stockBuy4.equalsIgnoreCase("AAPL") || stockBuy4.equalsIgnoreCase("GOOGL")) {
                        stockDay4 = stockBuy4;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid stock!!");
                    }
                }

                if (stockBuy4.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                    continue; 
                }

                double day4cost = 0;
                int Shares = 0;

                while (true) {
                    System.out.print("How many shares: ");
                    if (scanner.hasNextInt()) {
                        Shares = scanner.nextInt();
                        scanner.nextLine();
                        if (Shares <= 0) {
                            System.out.println("Invalid Input!!!");
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        System.out.println("INVALID input!!");

                        scanner.nextLine();
                    }
                }
                
                // find out the cost of day 4 shares
                if (stockDay4.equalsIgnoreCase("NVDA")) {
                    day4cost = NVDA * Shares;
                }
                else if (stockDay4.equalsIgnoreCase("AAPL")) {
                    day4cost = AAPL * Shares;
                }
                else if (stockDay4.equalsIgnoreCase("GOOGL")) {
                    day4cost = GOOGL * Shares;
                }
                // find out if playa can afford the shares
                if (cash >= day4cost) {
                    if (stockDay4.equalsIgnoreCase("NVDA")) {
                        sharesNVDA += Shares;
                        cash -= day4cost;
                        System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day4cost);
                        // System.out.println("Moving to day 5.");
                        // break; 
                    }
                    else if (stockDay4.equalsIgnoreCase("AAPL")) {
                        sharesAAPL += Shares;
                        cash -= day4cost;
                        System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day4cost);
                        // System.out.println("Moving to day 5.");
                        // break;
                    }
                    else if (stockDay4.equalsIgnoreCase("GOOGL")) {
                        sharesGOOGL += Shares;
                        cash -= day4cost;
                        System.out.printf("Bought %d shares of GOOGL for %.2f.%n", Shares, day4cost);
                        // System.out.println("Moving to day 5.");
                        // break;
                    }
                }
                else {
                    System.out.println("Cant afford it.");
                }
            }
            
            else if (stockChoice4.equalsIgnoreCase("sell")) {
                String stockSell4 = ""; // got help for this part, couldnt figure out how to implement the 'back'ing out feature

                while (true) {
                    System.out.println("What stock do you want to sell: ");
                    stockSell4 = scanner.nextLine();
                    
                    if (stockSell4.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                    if (stockSell4.equalsIgnoreCase("NVDA") || stockSell4.equalsIgnoreCase("AAPL") || stockSell4.equalsIgnoreCase("GOOGL")) {
                        int shareSell4 = 0;

                        while (true) {
                            System.out.printf("How many shares of %s would you like to sell: ", stockSell4);
                        
                            if (scanner.hasNextInt()) {
                                shareSell4 = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            }
                            else {
                                System.out.println("INVALID input!!");
                                scanner.nextLine();
                            }
                        }
                        
                        // sell NVDA
                        if (stockSell4.equalsIgnoreCase("NVDA") && shareSell4 > 0 && sharesNVDA >= shareSell4) {
                            double returnValue = shareSell4 * NVDA;
                            sharesNVDA -= shareSell4;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell4, stockSell4, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        // sell AAPL
                        else if (stockSell4.equalsIgnoreCase("AAPL") && shareSell4 > 0 && sharesAAPL >= shareSell4) {
                            double returnValue = shareSell4 * AAPL;
                            sharesAAPL -= shareSell4;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell4, stockSell4, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        // sell GOOGL
                        else if (stockSell4.equalsIgnoreCase("GOOGL") && shareSell4 > 0 && sharesGOOGL >= shareSell4) {
                            double returnValue = shareSell4 * GOOGL;
                            sharesGOOGL -= shareSell4;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell4, stockSell4, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        else {
                            System.out.printf("You don't own that many shares of %s%n", stockSell4);
                            continue;
                        }
                    }
                    else if (!stockSell4.equalsIgnoreCase("back")) {
                        System.out.println("Enter a valid stock to sell!!");
                    }
                }

                // got help for this
                if (!stockSell4.equalsIgnoreCase("back")) {
                    break; 
                }

                // break; 
            }
            else if (stockChoice4.equalsIgnoreCase("skip")) {
                System.out.println("\n".repeat(50));
                break;
            }
            else if (stockChoice4.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else {
                System.out.println("Enter a valid choice!!");
            }
        }
        
        // day 5
        String stockDay5 = "";
    
        System.out.println("==========");
        System.out.println("  Day 5");
        System.out.println("==========");
    
        System.out.println("\n");
        
        // either tragic or super good event

        // System.out.println(randomEventNum * 5);
        if (randomEventNum > 0.6) {
            NVDA = NVDA * 0.85; 
            AAPL = AAPL * 0.85;
            GOOGL = GOOGL * 0.85;

            System.out.println("THE ENTIRE STOCK MARKET IS DOWN 15%!!");
            System.out.println("\n");
        }
        else if (randomEventNum >= 0.4 || randomEventNum <= 0.5) {
            AAPL = AAPL * 1.20;
            NVDA = NVDA * 1.20;
            GOOGL = GOOGL * 1.20;

            System.out.println("THE ENTIRE STOCK MARKET IS UP 20%!?");
            System.out.println("\n");
        }
        else if (randomEventNum < 0.4) {
            AAPL = AAPL * 0.90;
            NVDA = NVDA * 0.90;
            GOOGL = GOOGL * 0.90;

            System.out.println("THE ENTIRE STOCK MARKET IS DOWN 10%!!!");
            System.out.println("\n");
        }
    
        // main HUD
        System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
        System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
        System.out.printf("GOOGL : %.2f | Shares owned : %d%n", GOOGL, sharesGOOGL);
        System.out.println("------------------------------");
        System.out.printf("Cash : %.2f%n", cash);
    
        System.out.println("\n");
        while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice5 = scanner.nextLine();
            String stockBuy5 = "";
            if (stockChoice5.equalsIgnoreCase("buy")) {
                while (true) {
                    System.out.print("What stock do you want to buy: ");
                    stockBuy5 = scanner.nextLine();

                    if (stockBuy5.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }
                    if (stockBuy5.equalsIgnoreCase("NVDA") || stockBuy5.equalsIgnoreCase("AAPL") || stockBuy5.equalsIgnoreCase("GOOGL")) {
                        stockDay5 = stockBuy5;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid stock!!");
                    }
                }

                if (stockBuy5.equalsIgnoreCase("back")) { // got help (if user wants to go back)
                    continue; 
                }

                double day5cost = 0;
                int Shares = 0;

                while (true) {
                    System.out.print("How many shares: ");
                    if (scanner.hasNextInt()) {
                        Shares = scanner.nextInt();
                        scanner.nextLine();
                        if (Shares <= 0) {
                            System.out.println("INVALID INPUT!!");
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        System.out.println("INVALID input!!");
                        scanner.nextLine();
                    }
                }

                // find out the cost of day 5 shares
                if (stockDay5.equalsIgnoreCase("NVDA")) {
                    day5cost = NVDA * Shares;
                }
                else if (stockDay5.equalsIgnoreCase("AAPL")) {
                    day5cost = AAPL * Shares;
                }
                else if (stockDay5.equalsIgnoreCase("GOOGL")) {
                    day5cost = GOOGL * Shares;
                }
                // find out if playa can afford the shares
                if (cash >= day5cost) {
                    if (stockDay5.equalsIgnoreCase("NVDA")) {
                        sharesNVDA += Shares;
                        cash -= day5cost;
                        System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day5cost);
                        // System.out.println("Moving to the final results..."); // maybe change it so that after every action, you go back to the main input and the day ONLY CHANGES when press skip??
                        // break; 
                    }
                    else if (stockDay5.equalsIgnoreCase("AAPL")) {
                        sharesAAPL += Shares;
                        cash -= day5cost;
                        System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day5cost);
                        // System.out.println("Moving to the final results..."); // // maybe change it so that after every action, you go back to the main input and the day ONLY CHANGES when press skip??
                        // break;
                    }
                    else if (stockDay5.equalsIgnoreCase("GOOGL")) {
                        sharesGOOGL += Shares;
                        cash -= day5cost;
                        System.out.printf("Bought %d shares of GOOGL for %.2f.%n", Shares, day5cost);
                        // System.out.println("Moving to the final results..."); // maybe change it so that after every action, you go back to the main input and the day ONLY CHANGES when press skip??
                        // break;
                    }
                }
                else {
                    System.out.println("Cant afford it.");
                }
            }
            else if (stockChoice5.equalsIgnoreCase("sell")) {
                String stockSell5 = "";
                while (true) {
                    System.out.println("What stock do you want to sell: ");
                    stockSell5 = scanner.nextLine();
                    
                    if (stockSell5.equalsIgnoreCase("back")) {
                            break; // if want to back out 
                        }

                    if (stockSell5.equalsIgnoreCase("NVDA") || stockSell5.equalsIgnoreCase("AAPL") || stockSell5.equalsIgnoreCase("GOOGL")) {
                        // System.out.printf("How many shares of %s would you like to sell: ", stockSell5);
                        int shareSell5 = 0;

                        while (true) {
                            System.out.printf("How many shares of %s would you like to sell: ", stockSell5);
                        
                            if (scanner.hasNextInt()) {
                                shareSell5 = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            }
                            else {
                                System.out.println("INVALID input!!");
                                scanner.nextLine();
                            }
                        }


                        // sell NVDA
                        if (stockSell5.equalsIgnoreCase("NVDA") && shareSell5 > 0 && sharesNVDA >= shareSell5) {
                            double returnValue = shareSell5 * NVDA;
                            sharesNVDA -= shareSell5;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell5, stockSell5, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        // sell AAPL
                        else if (stockSell5.equalsIgnoreCase("AAPL") && shareSell5 > 0 && sharesAAPL >= shareSell5) {
                            double returnValue = shareSell5 * AAPL;
                            sharesAAPL -= shareSell5;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell5, stockSell5, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        // sell GOOGL
                        else if (stockSell5.equalsIgnoreCase("GOOGL") && shareSell5 > 0 && sharesGOOGL >= shareSell5) {
                            double returnValue = shareSell5 * GOOGL;
                            sharesGOOGL -= shareSell5;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell5, stockSell5, returnValue);
                            // System.out.println("\n".repeat(50));
                            // break;
                        }
                        else {
                            System.out.printf("You don't own that many shares of %s%n", stockSell5);
                            continue;
                        }
                    }
                    else if (!stockSell5.equalsIgnoreCase("back")) {
                        System.out.println("Enter a valid stock to sell!!");
                    }
                }

                if (!stockSell5.equalsIgnoreCase("back")) {
                    break; 
                }
                // break;
            }
            else if (stockChoice5.equalsIgnoreCase("skip")) {
                System.out.println("\n".repeat(50));
                break;
            }
            else if (stockChoice5.equalsIgnoreCase("exit")) {
                System.exit(0);
            }
            else {
                System.out.println("Enter a valid choice!!");
            }
        }

        // final summary of the playerr
        
        double profitOrLoss = cash + sharesNVDA*NVDA + sharesAAPL*AAPL + sharesGOOGL*GOOGL; 

        System.out.println("Your trading journey comes to an end (for now). ");
        System.out.println("Here are your stats: ");
        
        if (profitOrLoss > 0) {
            // double profit = cash - 1000;
            System.out.printf("Cash : $%.2f | Profit : $%.2f", cash, profitOrLoss);
            System.out.println("\n");
            System.out.println("Making profit? Lets gooo!!");

        }
        else if (profitOrLoss < 0) {
            double loss = 1000 - cash;

            System.out.printf("Cash : $%.2f | Profit : -$%.2f", cash, loss);
            System.out.println();
            System.out.println("Ok, maybe not the outcome you expected but what can we do??");
            System.out.println("\n");
            System.out.printf("I think you should play again, %s.%n", name);
            System.out.println("Maybe, yk see if something changes.");
        }
        else {
            System.out.printf("Cash : $%.2f | Profit : $0", cash);
            System.out.println("\n");
            System.out.println("Nothing changed??");
            System.out.println("Maybe you can change this outcome by playing AGAIN...");
        }

        System.out.print("\n".repeat(2));
        System.out.printf("Thanks for playing %s", name);
        Thread.sleep(2325);
        System.exit(0);
    }
}