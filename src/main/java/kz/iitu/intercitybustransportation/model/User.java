package kz.iitu.intercitybustransportation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;

    public User(String name, String email, String hashedPassword) {
        this.username = name;
        this.email=email;
        this.password = hashedPassword;
    }

    // other fields, getters and setters
}