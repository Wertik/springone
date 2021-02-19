package space.devport.qwz.springone.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.devport.qwz.springone.model.User;

@RestController
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/updateBalance/{name}/{newBalance}")
    public Mono<User> updateBalance(@PathVariable("name") String name, @PathVariable("newBalance") double newBalance) {
        return userService.updateBalance(name, newBalance);
    }

    @PostMapping("/create/{name}")
    public Mono<User> createUser(@PathVariable("name") String name) {
        return userService.createUser(name);
    }

    @GetMapping("/user/{name}")
    public Flux<User> getUser(@PathVariable("name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/users")
    public Flux<User> getUsers() {
        return userService.findAll();
    }
}
