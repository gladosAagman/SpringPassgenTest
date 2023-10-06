import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody CreateUserRequest createUserRequest) {
        
        String password = generatePassword(
            createUserRequest.getFirstName(),
            createUserRequest.getMiddleName(),
            createUserRequest.getLastName()
        );

        
        User user = new User(
            createUserRequest.getFirstName(),
            createUserRequest.getMiddleName(),
            createUserRequest.getLastName(),
            password
        );

        userRepository.save(user);

        return user;
    }

    private String generatePassword(String firstName, String middleName, String lastName) {
     
        String firstChars = firstName.substring(0, 2);
        String middleChars = middleName.substring(0, 2);
        String lastChars = lastName.substring(0, 2);

        
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;

     
        return firstChars + middleChars + lastChars + randomNumber;
    }
}
