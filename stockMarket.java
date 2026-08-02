import java.util.Scanner;
import java.util.Random;

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

        // stocks
        double NVDA = 200.75;
        int sharesNVDA = 0;
        double AAPL = 308.91;
        int sharesAAPL = 0;

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
        System.out.println("    - in any primary input field, type 'exit' to exit the game");
        System.out.println("\n");

        System.out.println("Goal: ");
        System.out.println("Your goal is to make as much $$$$ as you can.");
        Thread.sleep(3575);
        System.out.print("\n"); // had to get help, did not know how to clear the terminal in java

        // getting to know the playa
        System.out.print("What is your name: ");
        String name = scanner.nextLine();

        System.out.println("\n");

        System.out.printf("Hi %s%n", name);
        System.out.println("\n");
        System.out.printf("%s, if you would like to play, press any key and if not, press 'q'.%n", name);
        System.out.println("\n");
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
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);

            System.out.println("\n");

            while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice1 = scanner.nextLine();

            // day 1 choices

            if (stockChoice1.equalsIgnoreCase("buy")) {
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

                    // System.out.println(stockDay1);

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
                    if (cash >= day1cost) {
                        if (stockDay1.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day1cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day1cost);
                            System.out.println("Skipping to day 2.");
                            break;
                        }
                        else if (stockDay1.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day1cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day1cost);
                            System.out.println("Skipping to day 2.");
                            break;
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

            // main HUD
            System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPl : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);

            System.out.println("\n");

            while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice2 = scanner.nextLine();

                if (stockChoice2.equalsIgnoreCase("buy")) {
                    while (true) {
                        System.out.print("What stock do you want to buy: ");
                        String stockBuy2 = scanner.nextLine();

                        if (stockBuy2.equalsIgnoreCase("NVDA") || stockBuy2.equalsIgnoreCase("AAPL")) {
                            stockDay2 = stockBuy2;
                            break;
                        }
                        else {
                            System.out.println("Enter a valid stock!!");
                        }
                    }

                    System.out.print("How many shares: ");
                    double day2cost = 0;
                    int Shares = scanner.nextInt();
                    scanner.nextLine();

                    // find out the cost of day 1 shares
                    if (stockDay2.equalsIgnoreCase("NVDA")) {
                        day2cost = NVDA * Shares;
                    }
                    else if (stockDay2.equalsIgnoreCase("AAPL")) {
                        day2cost = AAPL * Shares;
                    }

                    // find out if playa can afford the shares
                    if (cash >= day2cost) {
                        if (stockDay2.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day2cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day2cost);
                            System.out.println("Moving to day 3.");
                            break;
                        }
                        else if (stockDay2.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day2cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day2cost);
                            System.out.println("Moving to day 3.");
                            break;
                        }
                    }
                    else {
                        System.out.println("Cant afford it.");
                    }

                
                } else if (stockChoice2.equalsIgnoreCase("sell")) {
                    while (true) {
                        System.out.println("What stock do you want to sell: ");
                        String stockSell2 = scanner.nextLine();
                        
                        if (stockSell2.equalsIgnoreCase("NVDA") || stockSell2.equalsIgnoreCase("AAPL")) {
                            System.out.printf("How many shares of %s would you like to sell: ", stockSell2);
                            int shareSell2 = scanner.nextInt();
                            scanner.nextLine();
                            // sell NVDA
                            if (stockSell2.equalsIgnoreCase("NVDA") && shareSell2 > 0 && sharesNVDA >= shareSell2) {
                                double returnValue = shareSell2 * NVDA;
                                sharesNVDA -= shareSell2;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell2, stockSell2, returnValue);
                                System.out.println("\n".repeat(50));
                                break;
                            }
                            // sell AAPL
                            else if (stockSell2.equalsIgnoreCase("AAPL") && shareSell2 > 0 && sharesAAPL >= shareSell2) {
                                double returnValue = shareSell2 * AAPL;
                                sharesAAPL -= shareSell2;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell2, stockSell2, returnValue);
                                System.out.println("\n".repeat(50));
                                break;
                            }
                            else {
                                System.out.printf("You don't own that many shares of %s%n", stockSell2);
                                continue;
                            }
                        }
                        else {
                            System.out.println("Enter a valid stock to sell!!");
                            continue;
                        }
                    }
                    break;
                }
                else if (stockChoice2.equalsIgnoreCase("skip")) {
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
            System.out.println(NVDA);

            NVDA = NVDA + (NVDA * randomChange);
            AAPL = AAPL + (AAPL * randomChange);

            System.out.println("NVDA");
            
            // random event 
            double randomEventNum = Math.random();

            if (randomEventNum >= 0.67) {
                NVDA = NVDA * 1.20; // price surge so nvda is 20% up
                System.out.println("NVDA made too many potato chips so they are up 20%!!");
                System.out.println("\n");
            }
            else {
                AAPL = AAPL * 0.85;
                System.out.println("AAPL is down 15% coz ..."); 
                System.out.println("\n");
            }
        
            // main HUD
            System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
            System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
            System.out.println("------------------------------");
            System.out.printf("Cash : %.2f%n", cash);
        
            System.out.println("\n");

            while (true) {
                System.out.print("What do you want to do (type buy/sell/skip): ");
                String stockChoice3 = scanner.nextLine();

                if (stockChoice3.equalsIgnoreCase("buy")) {
                    while (true) {
                        System.out.print("What stock do you want to buy: ");
                        String stockBuy3 = scanner.nextLine();

                        if (stockBuy3.equalsIgnoreCase("NVDA") || stockBuy3.equalsIgnoreCase("AAPL")) {
                            stockDay3 = stockBuy3;
                            break;
                        }
                        else {
                            System.out.println("Enter a valid stock!!");
                        }
                    }

                    System.out.print("How many shares: ");
                    double day3cost = 0;
                    int Shares = scanner.nextInt();
                    scanner.nextLine();

                    // find out the cost of day 1 shares
                    if (stockDay3.equalsIgnoreCase("NVDA")) {
                        day3cost = NVDA * Shares;
                    }
                    else if (stockDay3.equalsIgnoreCase("AAPL")) {
                        day3cost = AAPL * Shares;
                    }

                    // find out if playa can afford the shares
                    if (cash >= day3cost) {
                        if (stockDay3.equalsIgnoreCase("NVDA")) {
                            sharesNVDA += Shares;
                            cash -= day3cost;
                            System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day3cost);
                            System.out.println("Moving to day 4.");
                            break;
                        }
                        else if (stockDay3.equalsIgnoreCase("AAPL")) {
                            sharesAAPL += Shares;
                            cash -= day3cost;
                            System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day3cost);
                            System.out.println("Moving to day 4.");
                            break;
                        }
                    }
                    else {
                        System.out.println("Cant afford it.");
                    }
            
                } 
                else if (stockChoice3.equalsIgnoreCase("sell")) {
                    while (true) {
                        System.out.println("What stock do you want to sell: ");
                        String stockSell3 = scanner.nextLine();
                        
                        if (stockSell3.equalsIgnoreCase("NVDA") || stockSell3.equalsIgnoreCase("AAPL")) {
                            System.out.printf("How many shares of %s would you like to sell: ", stockSell3);
                            int shareSell3 = scanner.nextInt();
                            scanner.nextLine();
                            // sell NVDA
                            if (stockSell3.equalsIgnoreCase("NVDA") && shareSell3 > 0 && sharesNVDA >= shareSell3) { // fixed the input error for sell
                                double returnValue = shareSell3 * NVDA;
                                sharesNVDA -= shareSell3;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell3, stockSell3, returnValue);
                                System.out.println("\n".repeat(50));
                                break;
                            }
                            // sell AAPL
                            else if (stockSell3.equalsIgnoreCase("AAPL") && shareSell3 > 0 && sharesAAPL >= shareSell3) {
                                double returnValue = shareSell3 * AAPL;
                                sharesAAPL -= shareSell3;
                                cash += returnValue;
                                System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell3, stockSell3, returnValue);
                                System.out.println("\n".repeat(50));
                                break;
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
                    break;
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
    
        // main HUD
        System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
        System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
        System.out.println("------------------------------");
        System.out.printf("Cash : %.2f%n", cash);
    
        System.out.println("\n");
        while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice4 = scanner.nextLine();
            if (stockChoice4.equalsIgnoreCase("buy")) {
                while (true) {
                    System.out.print("What stock do you want to buy: ");
                    String stockBuy4 = scanner.nextLine();
                    if (stockBuy4.equalsIgnoreCase("NVDA") || stockBuy4.equalsIgnoreCase("AAPL")) {
                        stockDay4 = stockBuy4;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid stock!!");
                    }
                }
                System.out.print("How many shares: ");
                double day4cost = 0;
                int Shares = scanner.nextInt();
                scanner.nextLine();
                // find out the cost of day 1 shares
                if (stockDay4.equalsIgnoreCase("NVDA")) {
                    day4cost = NVDA * Shares;
                }
                else if (stockDay4.equalsIgnoreCase("AAPL")) {
                    day4cost = AAPL * Shares;
                }
                // find out if playa can afford the shares
                if (cash >= day4cost) {
                    if (stockDay4.equalsIgnoreCase("NVDA")) {
                        sharesNVDA += Shares;
                        cash -= day4cost;
                        System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day4cost);
                        System.out.println("Moving to day 3.");
                        break; 
                    }
                    else if (stockDay4.equalsIgnoreCase("AAPL")) {
                        sharesAAPL += Shares;
                        cash -= day4cost;
                        System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day4cost);
                        System.out.println("Moving to day 4.");
                        break;
                    }
                }
                else {
                    System.out.println("Cant afford it.");
                }
            }
            else if (stockChoice4.equalsIgnoreCase("sell")) {
                while (true) {
                    System.out.println("What stock do you want to sell: ");
                    String stockSell4 = scanner.nextLine();
                    
                    if (stockSell4.equalsIgnoreCase("NVDA") || stockSell4.equalsIgnoreCase("AAPL")) {
                        System.out.printf("How many shares of %s would you like to sell: ", stockSell4);
                        int shareSell4 = scanner.nextInt();
                        scanner.nextLine();
                        // sell NVDA
                        if (stockSell4.equalsIgnoreCase("NVDA") && shareSell4 > 0 && sharesNVDA >= shareSell4) {
                            double returnValue = shareSell4 * NVDA;
                            sharesNVDA -= shareSell4;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell4, stockSell4, returnValue);
                            System.out.println("\n".repeat(50));
                            break;
                        }
                        // sell AAPL
                        else if (stockSell4.equalsIgnoreCase("AAPL") && shareSell4 > 0 && sharesAAPL >= shareSell4) {
                            double returnValue = shareSell4 * AAPL;
                            sharesAAPL -= shareSell4;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell4, stockSell4, returnValue);
                            System.out.println("\n".repeat(50));
                            break;
                        }
                        else {
                            System.out.printf("You don't own that many shares of %s%n", stockSell4);
                            continue;
                        }
                    }
                    else {
                        System.out.println("Enter a valid stock to sell!!");
                        continue;
                    }
                }
                break;
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
    
        // main HUD
        System.out.printf("NVDA : %.2f | Shares owned : %d%n", NVDA, sharesNVDA);
        System.out.printf("AAPL : %.2f | Shares owned : %d%n", AAPL, sharesAAPL);
        System.out.println("------------------------------");
        System.out.printf("Cash : %.2f%n", cash);
    
        System.out.println("\n");
        while (true) {
            System.out.print("What do you want to do (type buy/sell/skip): ");
            String stockChoice5 = scanner.nextLine();
            if (stockChoice5.equalsIgnoreCase("buy")) {
                while (true) {
                    System.out.print("What stock do you want to buy: ");
                    String stockBuy5 = scanner.nextLine();
                    if (stockBuy5.equalsIgnoreCase("NVDA") || stockBuy5.equalsIgnoreCase("AAPL")) {
                        stockDay5 = stockBuy5;
                        break;
                    }
                    else {
                        System.out.println("Enter a valid stock!!");
                    }
                }
                System.out.print("How many shares: ");
                double day5cost = 0;
                int Shares = scanner.nextInt();
                scanner.nextLine();
                // find out the cost of day 1 shares
                if (stockDay5.equalsIgnoreCase("NVDA")) {
                    day5cost = NVDA * Shares;
                }
                else if (stockDay5.equalsIgnoreCase("AAPL")) {
                    day5cost = AAPL * Shares;
                }
                // find out if playa can afford the shares
                if (cash >= day5cost) {
                    if (stockDay4.equalsIgnoreCase("NVDA")) {
                        sharesNVDA += Shares;
                        cash -= day5cost;
                        System.out.printf("Bought %d shares of NVDA for %.2f.%n", Shares, day5cost);
                        System.out.println("Moving to day 3.");
                        break; 
                    }
                    else if (stockDay4.equalsIgnoreCase("AAPL")) {
                        sharesAAPL += Shares;
                        cash -= day5cost;
                        System.out.printf("Bought %d shares of AAPL for %.2f.%n", Shares, day5cost);
                        System.out.println("Moving to day 4.");
                        break;
                    }
                }
                else {
                    System.out.println("Cant afford it.");
                }
            }
            else if (stockChoice5.equalsIgnoreCase("sell")) {
                while (true) {
                    System.out.println("What stock do you want to sell: ");
                    String stockSell5 = scanner.nextLine();
                    
                    if (stockSell5.equalsIgnoreCase("NVDA") || stockSell5.equalsIgnoreCase("AAPL")) {
                        System.out.printf("How many shares of %s would you like to sell: ", stockSell5);
                        int shareSell5 = scanner.nextInt();
                        scanner.nextLine();
                        // sell NVDA
                        if (stockSell5.equalsIgnoreCase("NVDA") && shareSell5 > 0 && sharesNVDA >= shareSell5) {
                            double returnValue = shareSell5 * NVDA;
                            sharesNVDA -= shareSell5;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell5, stockSell5, returnValue);
                            System.out.println("\n".repeat(50));
                            break;
                        }
                        // sell AAPL
                        else if (stockSell5.equalsIgnoreCase("AAPL") && shareSell5 > 0 && sharesAAPL >= shareSell5) {
                            double returnValue = shareSell5 * AAPL;
                            sharesAAPL -= shareSell5;
                            cash += returnValue;
                            System.out.printf("Sold %d shares of %s for %.2f!%n", shareSell5, stockSell5, returnValue);
                            System.out.println("\n".repeat(50));
                            break;
                        }
                        else {
                            System.out.printf("You don't own that many shares of %s%n", stockSell5);
                            continue;
                        }
                    }
                    else {
                        System.out.println("Enter a valid stock to sell!!");
                        continue;
                    }
                }
                break;
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

        // final summary of the playa
        /*
        profit calculation here (if in +, then say profit in summary and if in -, say loss), find a cool format for a summary table, and put scanner checks 
        (so the input can deal with wrong data types)
        */

        System.out.println("Your trading journey comes to an end (for now). ");
        System.out.println("Here are your stats: ");
        
    }
}