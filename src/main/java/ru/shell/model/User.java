package ru.shell.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age")
    private Long age;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;   //множество

    public User() {

    }

    public User(Long age, String name, String password, String role) {
        this.age = age;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getAge(), that.getAge()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getRole(), that.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getPassword());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public Long getAge() {
        return age;
    }
}