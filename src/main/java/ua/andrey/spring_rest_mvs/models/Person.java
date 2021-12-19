package ua.andrey.spring_rest_mvs.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    public Person() {
    }

    private int id;
    @NotEmpty(message = "name should not be empty")
    @Size(min = 2, max = 10, message = "message should be between 2 and 10 characters")
    private String name;
    @Min(value = 0, message = "age should be greater than 0")
    private int age;
    @NotEmpty(message = "email should not be empty")
    @Email(message = "email should be valid")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}