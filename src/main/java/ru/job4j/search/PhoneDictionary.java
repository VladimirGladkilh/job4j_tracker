package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> findOld(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person: persons) {
            if (person.getAddress().contains(key) || person.getName().contains(key)
                    || person.getPhone().contains(key) || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = t -> t.getSurname().contains(key);
        Predicate<Person> combN = t -> t.getName().contains(key);
        Predicate<Person> combA = t -> t.getAddress().contains(key);
        Predicate<Person> combP = t -> t.getPhone().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.or(combN).or(combA).or(combP).test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
