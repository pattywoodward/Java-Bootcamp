import java.util.Random;
import java.util.Scanner;

public class RandomNumbers {
    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = random.nextInt(100);
        randomNumber++;
        int guesses = 5;

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= guesses ; ) {
            System.out.print ("Pick a number between 1 and 100: ");
            int numberEntered = scanner.nextInt();
            if ((numberEntered >= 1 && numberEntered <= 100) && (numberEntered < randomNumber)) {
                i++;
                if (i > guesses) {
                    System.out.println("You lose!");
                    System.out.println("The number to guess was " + randomNumber);
                } else {
                    System.out.println("Please pick a higher number");
                }
            } else if ((numberEntered >= 1 && numberEntered <= 100) && (numberEntered > randomNumber)) {
                i++;
                if (i > guesses) {
                    System.out.println("You lose!");
                    System.out.println("The number to guess was " + randomNumber);
                } else {
                    System.out.println("Please pick a lower number");
                }
            } else if ((numberEntered >= 1 && numberEntered <= 100) && (numberEntered == randomNumber)) {
                System.out.println("You are a winner");
                scanner.close();
                return;
            } else
                System.out.println("Your guess is not between 1 and 100, please try again");
        }
        scanner.close();
    }
}
