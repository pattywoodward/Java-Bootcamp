import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {

    private static String username = null;
    private static String password = null;
    private static String name = null;
    private static Boolean usernameAndPasswordMatched = false;


    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int max_attempts = 5;
        int counter = 0;
        User[] user = new User[0];
        UserService service = new UserService();
        user = service.parseUser();
        while (counter < max_attempts) {
            System.out.print("Enter your email: ");
            String usernameEntered = scanner.nextLine();
            System.out.print("Enter your password: ");
            String passwordEntered = scanner.nextLine();
            for (int i = 0; i < user.length; i++) {
                username = user[i].getUsername();
                password = user[i].getPassword();
                name = user[i].getName();
                if (usernameEntered.equalsIgnoreCase(username) && passwordEntered.equals(password)){
                    usernameAndPasswordMatched = true;
                    continue;
                }
            }
                if (!usernameAndPasswordMatched) {
                    System.out.println("Invalid login, please try again");
                    counter++;
                    if (counter == max_attempts) {
                        System.out.println("Too many failed login attempts, you are now locked out.");
                    }
                } else {
                    System.out.println("Welcome " + name);
                    scanner.close();
                    return;
                }
            }
        scanner.close();
        }
}

