package kazybek.meiirbek.springmvc.dao;

import kazybek.meiirbek.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Kazy",22,"kazy@mail.kz"));
        people.add(new Person(++PEOPLE_COUNT,"Yera",21,"yera@mail.kz"));
        people.add(new Person(++PEOPLE_COUNT,"Yerik",20,"yerik@mail.kz"));
        people.add(new Person(++PEOPLE_COUNT,"Zhena",23,"zhena@mail.kz"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId()==id);
    }
}
