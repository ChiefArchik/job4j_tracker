package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenDescCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenAscComparatorByNameAndPriority() {
        Comparator<Job> cmpAscNamePriority =
                new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpAscNamePriority.compare(
                new Job("Write", 1),
                new Job("Read", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscComparatorByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int rsl = cmpAscByName.compare(
                new Job("Run", 0),
                new Job("Jump", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenAscComparatorByPriority() {
        Comparator<Job> cmpAscByPriority = new JobAscByPriority();
        int rsl = cmpAscByPriority.compare(
                new Job("Pump", 0),
                new Job("Fising", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDecscComparatorByName() {
        Comparator<Job> cmpDescByName = new JobDescByName();
        int rsl = cmpDescByName.compare(
                new Job("Run", 0),
                new Job("Jump", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescComparatorByPriority() {
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int rsl = cmpDescByPriority.compare(
                new Job("Pump", 0),
                new Job("Fising", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByDescNameAndAscPrority() {
        Comparator<Job> cmpDescNameAscPriority =
                new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpDescNameAscPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}