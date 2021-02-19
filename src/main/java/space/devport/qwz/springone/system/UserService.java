package space.devport.qwz.springone.system;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.devport.qwz.springone.model.User;
import space.devport.qwz.springone.system.mongo.UserRepository;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final AtomicInteger currentId = new AtomicInteger();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> createUser(String name) {
        User user = new User(currentId.getAndIncrement(), name);
        return userRepository.save(user);
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> delete(int id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Mono<User> updateBalance(String name, double balance) {
        return userRepository.updateBalance(name, balance);
    }
}
