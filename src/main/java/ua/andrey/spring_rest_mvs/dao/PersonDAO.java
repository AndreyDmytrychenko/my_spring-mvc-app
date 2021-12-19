package ua.andrey.spring_rest_mvs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.andrey.spring_rest_mvs.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(final int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, age, email) VALUES(?,?,?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person personUpdate) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                personUpdate.getName(), personUpdate.getAge(), personUpdate.getEmail(), id);
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

    }
}
