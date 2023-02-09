package lista8_1;

import java.util.ArrayList;

public class CyclicArrayQueue<E> implements MyQueue<E> {
    private final ArrayList<E> queue;
    private int front;
    private int rear;
    CyclicArrayQueue(int size) {
        front = rear = 0;
        queue = new ArrayList<>(size + 1);
        for (int i = 0; i < size + 1; i++) queue.add(null);
    }
    @Override
    public void enqueue(E el) throws FullException {
        if (isFull()) throw new FullException("lista8_1.CyclicArrayQueue: enqueue");
        else {
            queue.set(rear, el);
            rear = (rear + 1) % queue.size();
        }
    }
    @Override
    public void dequeue() {
        if (!isEmpty()) {
            queue.set(front, null);
            front = (front + 1) % queue.size();
        }
    }
    @Override
    public E first() throws EmptyException {
        if (isEmpty()) throw new EmptyException("lista8_1.CyclicArrayQueue: first");
        else return queue.get(front);
    }
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % queue.size() == front;
    }
}