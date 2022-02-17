package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = person -> person.getName().equals(key);
        Predicate<Person> predSurname = person -> person.getSurname().equals(key);
        Predicate<Person> predPhone = person -> person.getPhone().equals(key);
        Predicate<Person> predAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine = person -> {
            return predName.or(predSurname).or(predPhone).or(predAddress).test(person);
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
