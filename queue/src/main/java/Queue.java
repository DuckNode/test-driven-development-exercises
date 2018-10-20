public class Queue {

    private int size = 0;
    private Object[] arrayOfItems = new Object[5];
    private int head = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Object item) {
        arrayOfItems[size++] = item;
    }

    public int size() {
        return size;
    }

    public Object dequeue() {

        if (isEmpty()) return "Nothing left";

        Object dequeuedItem = arrayOfItems[head];
        arrayOfItems[head] = null;
        head++;
        size--;
        return dequeuedItem;
    }

    public boolean contains(Object item) {
        for (int i = head; i < size; i++) {
            if (arrayOfItems[i].equals(item)) return true;
        }

        return false;
    }

    public boolean isFull() {
        return size == arrayOfItems.length;
    }
}
