package ru.job4j.search;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriorityQueueTest {

        @Test
        public void whenHigherPriority() {
            var queue = new PriorityQueue();
            queue.put(new Task("low", 5));
            queue.put(new Task("urgent", 1));
            queue.put(new Task("middle", 3));
            var result = queue.take();
            assertThat(result.getDesc(), is("urgent"));
        }

}