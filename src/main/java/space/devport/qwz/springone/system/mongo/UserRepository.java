package space.devport.qwz.springone.system.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import space.devport.qwz.springone.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Integer>, CustomUserRepository {
}
