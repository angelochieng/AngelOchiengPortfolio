package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

//Virginia Tech Honor Code Pledge:
//Project 4 Spring 2025
//As a Hokie, I will conduct myself 
//with honor and integrity at all times.
//I will not lie, cheat, or steal,
//nor will I accept the actions of those who do.
//-- AngelOchieng 906580673
/**
 * The implementing the song class
 *
 * @author Angel Ochieng
 * @version 03.17.2025
 */
/**
* 
* @param <T> array
*/
public class ArrayQueue<T> implements QueueInterface<T> {
    /**
     * instantiating fields
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int size;
    private int enqueueIndex;

    /**
     * constructor for int capacity
     * 
     * @param capacity constructor for arrayQueue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        queue = (T[]) new Object[capacity + 1];
        this.size = 0;
        this.dequeueIndex = 0;
        this.enqueueIndex = capacity;

    }

    /**
     * constructor ArrayQueue
     * 
     */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);

    }

    /**
     * clears the queue
     */
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] newQueue = (T[]) new Object[DEFAULT_CAPACITY + 1];
        queue = newQueue;
        size = 0;
        dequeueIndex = 0;
        enqueueIndex = queue.length - 1;

    }

    /**
     * @return the queue as string
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            T item = queue[(dequeueIndex + i) % queue.length];
            builder.append(item != null ? item.toString() : "null");
            if (i < size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * @param obj what makes it equal
     * @return true if equal length
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ArrayQueue)) {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>) obj;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            T thisItem = queue[(dequeueIndex + i) % 
                               queue.length];
            Object otherItem = 
                    other.queue[(other.dequeueIndex + i) %
                    other.queue.length];

            if (thisItem == null &&
                    otherItem == null) {
                continue;
            }
            if (thisItem == null || otherItem == null || 
                    !thisItem.equals(otherItem)) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if queue is empty
     * 
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * removes items from queue
     * 
     * @return front of queue
     * @throws EmptyQueueException if empty
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        T front = getFront();
        queue[dequeueIndex] = null;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        size--;
        return front;

    }

    /**
     * checks capacity
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
        T[] newQueue = (T[]) new Object[queue.length * 2];
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(dequeueIndex + i) % queue.length];
        }
        queue = newQueue;
        dequeueIndex = 0;
        enqueueIndex = size;
    }

    /**
     * adds to the queue
     * 
     * @param newEntry that is added
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(T newEntry) {
        if (size == queue.length - 1) {
            ensureCapacity();
        }
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        queue[enqueueIndex] = newEntry;
        size++;
    }

    /**
     * @return length of underlying array
     * 
     */
    public int getLengthOfUnderlyingArray() {
        return queue.length;
    }

    /**
     * @return the front
     * @throws EmptyQueueException if empty
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }

    /**
     * @return size of queue
     * 
     */

    public int getSize() {
        return size;
    }

    /**
     * @return the queue as array
     * @throws EmptyQueueException if empty
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return array;
    }

}
