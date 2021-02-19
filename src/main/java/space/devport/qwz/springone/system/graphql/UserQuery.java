package space.devport.qwz.springone.system.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import space.devport.qwz.springone.model.User;
import space.devport.qwz.springone.system.UserService;

@Service
public class UserQuery implements GraphQLQueryResolver {

    private final UserService userService;

    public UserQuery(UserService userService) {
        this.userService = userService;
    }

    public User byName(String name) {
        Flux<User> flux = userService.findByName(name);
        return flux.blockFirst();
    }
}
