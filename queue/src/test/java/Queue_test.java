import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Queue_test {

    private static Queue isEmpty = new Queue();
    private static Queue isNotEmpty = new Queue();

    @BeforeClass
    public static void setup() {
        isNotEmpty.enqueue("1");
        isNotEmpty.enqueue("2");
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, isEmpty.isEmpty());
        assertEquals(false, isNotEmpty.isEmpty());
    }

    @Test
    public void testEnqueueAnItem() {
        assertEquals(0, isEmpty.size());

        Queue queue = new Queue();

        queue.enqueue("1");
        assertEquals(1, queue.size());

        queue.enqueue("2");
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueAnItem() {
        Queue queue = new Queue();

        queue.enqueue("1");
        queue.enqueue("2");

        assertEquals("1", queue.dequeue());
        assertEquals(1, queue.size());

        assertEquals("2", queue.dequeue());
        assertEquals(0, queue.size());

        assertEquals("Nothing left", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    public void testContains() {
        Queue queue = new Queue();

        queue.enqueue("1");
        assertTrue(queue.contains("1"));

        queue.dequeue();
        assertFalse(queue.contains("1"));
    }

    @Test
    public void isFull() {
        assertFalse(isEmpty.isFull());

        Queue queue = new Queue();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        assertTrue(queue.isFull());

        queue.dequeue();

        assertFalse(queue.isFull());
    }

    @Test
    public void testAlwaysUseAllAvailableCapacity() {
        Queue queue = new Queue();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
//        queue.enqueue("5");

        queue.dequeue();
        queue.enqueue("6");
        assertTrue(queue.contains("6"));

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertEquals("6", queue.dequeue());
    }

    @Test
    public void testIncreaseCapacity() {
        Queue queue = new Queue(4);

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        assertEquals(5, queue.size()); // may not work in cases, i.e. where enqueue always increases size
        assertTrue(queue.contains("5")); // "seems" safer than size check

        Queue wrapRoundQueue = new Queue(4);

        wrapRoundQueue.enqueue("1");
        wrapRoundQueue.enqueue("2");
        wrapRoundQueue.enqueue("3");
        wrapRoundQueue.enqueue("4");
        wrapRoundQueue.dequeue();
        wrapRoundQueue.enqueue("5");
        wrapRoundQueue.enqueue("6");

        assertEquals("2", wrapRoundQueue.dequeue());//may be always positive depending on candidate implementation
        assertEquals("3", wrapRoundQueue.dequeue());//may be always positive depending on candidate implementation
        assertEquals("4", wrapRoundQueue.dequeue());//may be always positive depending on candidate implementation
        assertEquals("5", wrapRoundQueue.dequeue());//may be always positive depending on candidate implementation
        assertEquals("6", wrapRoundQueue.dequeue());
    }

}