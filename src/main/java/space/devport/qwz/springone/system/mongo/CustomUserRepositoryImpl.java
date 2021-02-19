package space.devport.qwz.springone.system.mongo;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import space.devport.qwz.springone.model.User;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final ReactiveMongoTemplate template;

    public CustomUserRepositoryImpl(ReactiveMongoTemplate template) {
        this.template = template;
    }

    @Override
    public Flux<User> findByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return template.find(query, User.class);
    }

    @Override
    public Mono<User> updateBalance(String name, double newBalance) {
        Query query = new Query(Criteria.where("name").is(name));
        Update update = Update.update("balance", newBalance);
        return template.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), User.class);
    }
}
