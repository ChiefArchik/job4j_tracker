package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDuplicate() {
        Citizen citizen = new Citizen("alef234", "Archi Chief");
        Citizen citizen1 = new Citizen("alef234", "Albert Batman");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizen1));
    }
}