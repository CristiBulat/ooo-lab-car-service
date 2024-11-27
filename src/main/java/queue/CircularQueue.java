package queue;

public class CircularQueue<T> implements Queue<T> {
    private final T[] items;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public CircularQueue(int capacity) {
        items = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == items.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = items[front];
        items[front] = null; // Optional: clear the spot for GC
        front = (front + 1) % items.length;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
