import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserService {

    public User [] parseUser() throws IOException {
        User [] individualUser = null;
        String fileName = "data.txt";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader((new FileReader(fileName)));
            String line = "";
            int count = 0;
            long lineCount = Files.lines(Paths.get(fileName)).count();
            individualUser = new User[(int)lineCount];
            while ((line = fileReader.readLine()) != null) {
                String [] users = line.split("\n") ;
                for (String user : users) {
                    String [] userArray = user.split(",");
                    individualUser[count] = createUser(userArray[0], userArray[1], userArray[2]);
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return individualUser;
    }

    public User createUser (String username, String password, String name) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        return user;
    }
}
