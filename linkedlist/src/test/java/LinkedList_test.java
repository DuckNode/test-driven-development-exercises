import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedList_test {

    LinkedList emptyList = new LinkedList();

    @Test
    public void testIsEmptyLinkedList() {
        LinkedList notEmptyList = new LinkedList();

        notEmptyList.add("One");

        assertTrue(emptyList.isEmpty());
        assertFalse(notEmptyList.isEmpty());
    }

    @Test
    public void testAddItem() {
        assertEquals(0, emptyList.size());

        LinkedList list = new LinkedList();

        list.add("One");
        assertEquals(1, list.size());

        list.add("Two");
        assertEquals(2, list.size());
    }

    @Test
    public void testGetItem() {
        LinkedList list = new LinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("One", list.at(0));
        assertEquals("Two", list.at(1));
        assertEquals("Three", list.at(2));

        assertEquals("Out of bounds", list.at(3));
    }

    @Test
    public void testRemoveAt() {
        LinkedList list = new LinkedList();

        list.add("One");
        list.add("Two");

        list.removeAt(0);

        assertEquals("Two", list.at(0));
        assertEquals(1, list.size());

        list.removeAt(0);

        assertEquals("Out of bounds", list.at(0));
        assertEquals(0, list.size());

        LinkedList bigList = new LinkedList();

        bigList.add("One");
        bigList.add("Two");
        bigList.add("Three");
        bigList.add("Four");

        bigList.removeAt(2);

        assertEquals("One", bigList.at(0));
        assertEquals("Two", bigList.at(1));
        assertEquals("Four", bigList.at(2));
        assertEquals("Out of bounds", bigList.at(3));
    }

    @Test
    public void testContains() {
        LinkedList list = new LinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals(0, list.contains("One"));
        assertEquals(1, list.contains("Two"));

        assertEquals(-1, list.contains("Four"));
    }

    @Test
    public void testDeleteLast() {
        LinkedList list = new LinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");

        list.removeLast();

        assertEquals(2, list.size());
        assertEquals(-1, list.contains("Three"));
    }

    @Test
    public void testPrint() {
        Object[] emptyArray = new Object[0];

        assertArrayEquals(emptyArray, emptyList.printAll());

        LinkedList list = new LinkedList();

        list.add("One");
        list.add("Two");
        list.add("Three");

        Object[] populatedArray = new Object[3];

        populatedArray[0] = "One";
        populatedArray[1] = "Two";
        populatedArray[2] = "Three";

        assertArrayEquals(populatedArray, list.printAll());
    }
}
