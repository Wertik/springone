package space.devport.qwz.springone.system;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.devport.qwz.springone.model.User;

public interface IUserService {

    Mono<User> createUser(String name);

    Mono<User> save(User user);

    Mono<User> findById(int id);

    Flux<User> findByName(String name);

    Flux<User> findAll();

    Mono<User> update(User user);

    Mono<Void> delete(int id);

    // Update fields

    Mono<User> updateBalance(String name, double balance);
}
