package org.example.dao;

import org.example.models.Book;
import org.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonDAO() {
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    //Метод для валидатора
    public Optional<Person> show(String fullname) {
        return jdbcTemplate.query("SELECT * FROM person WHERE fullname=?", new Object[]{fullname}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();// ПРОВЕРИТЬ ЧТО ПОЛЯ СОВПАДАЮТ ПО ИМЕНИ В ПОЛЯМИ В ТАБЛИЦЕ
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);// ПРОВЕРИТЬ ЧТО ПОЛЯ СОВПАДАЮТ ПО ИМЕНИ В ПОЛЯМИ В ТАБЛИЦЕ
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO person(fullname, birthyear) VALUES(?,?)", person.getFullname(), person.getBirthyear());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE person SET fullname = ?, birthyear = ? WHERE id = ?", updatedPerson.getFullname(), updatedPerson.getBirthyear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

    public List<Book> getReadedBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM book WHERE person_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }
}
