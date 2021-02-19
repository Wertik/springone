package space.devport.qwz.springone.system.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;
import space.devport.qwz.springone.model.User;
import space.devport.qwz.springone.system.UserService;

@Service
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    public UserMutation(UserService userService) {
        this.userService = userService;
    }

    public User updateBalance(String name, double balance) {
        return userService.updateBalance(name, balance).block();
    }
}
