package space.devport.qwz.springone.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    @Getter
    private final int id;

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private double balance;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "User{id=" + id +
                ", name = '" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
