package com.example.demo.SERVER.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    public User(String login, String surname, String name, String father_name, Date birthday) {
        this.login = login;
        this.surname = surname;
        this.name = name;
        this.father_name = father_name;
        this.birthday = birthday;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String surname;

    @Column
    private String name;

    @Column
    private String father_name;

    @Column
    private Date birthday;

    @CreatedDate
    @Column
    private LocalDate created;

    @LastModifiedDate
    @Column
    private LocalDate updated;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", Login='" + login + '\'' +
                ", Surname='" + surname + '\'' +
                ", Name='" + name + '\'' +
                ", Father name='" + father_name + '\'' +
                ", Birthday=" + birthday +
                '}';
    }
}