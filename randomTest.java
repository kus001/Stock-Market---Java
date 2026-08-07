public class randomTest {
    public static void main(String[] args) throws InterruptedException {


            // stock fluctuations
            double low = -0.45;
            double high = 0.45;
            double randomChange = (double)(Math.random() * (high-low) + low);
            System.out.println(randomChange);
    }
}