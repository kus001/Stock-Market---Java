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
        double AMZN = 271.58;
        int sharesAMZN = 0;
        double MSFT = 464.72;
        int sharesMSFT = 0;
        double GOOGL = 356.13;
        int sharesGOOGL = 0;

        // introduction
        System.out.println("======");
        System.out.println("STOCKS");

        System.out.println("Welcome to the STOCK MARKET simulator");
        System.out.println("======");
        Thread.sleep(2000);
        
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
            System.out.print("\033[H\033[2J"); // had to get help, did not know how to clear the terminal in java
            System.out.println("ok");
        }
    }
}