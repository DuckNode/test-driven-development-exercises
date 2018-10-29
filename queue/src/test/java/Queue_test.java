import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class Queue_test {

    @Test
    public void isEmpty() {
        Queue isEmpty = new Queue();

        assertEquals(true, isEmpty.isEmpty());

        Queue isNotEmpty = new Queue();

        isNotEmpty.enqueue("1");
        assertEquals(false, isNotEmpty.isEmpty());
    }

    @Test
    public void enqueueAnItem() {
        Queue queue = new Queue();

        assertEquals(0, queue.size()); // omit on creation for candidate to suggest

        queue.enqueue("1");
        assertEquals(1, queue.size());

        // omit on creation for candidate to suggest
        queue.enqueue("2");
        assertEquals(2, queue.size());
    }

    @Test
    public void testContains() {
        Queue queue = new Queue();

        queue.enqueue("1");
        queue.enqueue("2");

        assertTrue(queue.contains("1"));
        assertTrue(queue.contains("2"));

        // omit on creation for candidate to suggest
        queue.dequeue();
        assertFalse(queue.contains("1"));
        assertTrue(queue.contains("2"));
    }

    @Test
    public void dequeueAnItem() {
        Queue queue = new Queue();

        queue.enqueue("1");
        queue.enqueue("2");

        assertEquals("1", queue.dequeue());
        assertEquals(1, queue.size());

        // omit on creation for candidate to suggest
        assertEquals("2", queue.dequeue());
        assertEquals(0, queue.size());

        // omit on creation for candidate to suggest
        assertEquals("Nothing left", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void isFull() {
        Queue queue = new Queue();

        assertFalse(queue.isFull()); // omit on creation for candidate to suggest

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        assertTrue(queue.isFull());

        queue.dequeue();

        assertFalse(queue.isFull()); // omit on creation for candidate to suggest
    }
}
