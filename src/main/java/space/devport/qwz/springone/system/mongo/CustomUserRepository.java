package space.devport.qwz.springone.system.mongo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.devport.qwz.springone.model.User;

public interface CustomUserRepository {

    Flux<User> findByName(String name);

    Mono<User> updateBalance(String name, double newBalance);
}
