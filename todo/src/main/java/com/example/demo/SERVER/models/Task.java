package com.example.demo.SERVER.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "tasks")
public class Task {
    public Task(String name, String description,Date deadline, Boolean success){
        this.name=name;
        this.description=description;
        this.success=success;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "taskid")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date deadline;

    @Column
    private Boolean success;


    @CreatedDate
    @Column
    private LocalDate created;

    @LastModifiedDate
    @Column
    private LocalDate updated;

    public Task(){}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_like",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> category;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", success=" + success +
                ", created=" + created +
                ", updated=" + updated +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
