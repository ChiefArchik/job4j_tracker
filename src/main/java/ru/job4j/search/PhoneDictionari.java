package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = person -> person.getName().contains(key);
        Predicate<Person> predSurname = person -> person.getSurname().contains(key);
        Predicate<Person> predPhone = person -> person.getPhone().contains(key);
        Predicate<Person> predAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = predName.or(predSurname).or(predPhone).or(predAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
