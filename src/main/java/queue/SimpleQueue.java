package queue;

import java.util.ArrayList;

public class SimpleQueue<T> implements Queue<T>{
    private final ArrayList<T> items = new ArrayList<>();

    @Override
    public void enqueue(T item) {
        items.add(item);
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return items.remove(0);
    }

    @Override
    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public int size(){
        return items.size();
    }
}
