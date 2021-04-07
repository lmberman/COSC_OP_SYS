/**
 * This class represents a scheduling queue
 * In this simple Operating System (Janis) these scheduling queues are:
 * a. Ready Queue
 * b. IO blocked Queue
 * <p>
 * These queues are bounded queues for simplicity max (15 processes)
 * It has a semaphore named isAvailable to determine if any aspect of the queue is currently being modified
 * and to cause the other processes to wait before being added or removed
 */
public class SchedulingQueue {

    private final int maxSize = 15;
    private int currentSize;
    private Process[] elements;
    private boolean isAvailable;

    SchedulingQueue() {
        currentSize = 0;
        elements = new Process[maxSize];
        isAvailable = true;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public Process[] getElements() {
        return elements;
    }

    public void setElements(Process[] elements) {
        this.elements = elements;
    }

    public void addElement(Process process) throws Exception {
        isAvailable = false;
        if (currentSize == maxSize) {
            throw new Exception("Queue is full please try again later");
        }

        if (elements[currentSize] == null) {
            elements[currentSize] = process;
            currentSize++;
        } else {
            int index = currentSize;
            while (elements[index] != null) {
                if (index >= maxSize) {
                    index = 0;
                } else {
                    index++;
                }
            }
            elements[currentSize] = process;
            currentSize++;
        }
        isAvailable = true;
    }

    public void removeElement(int index) throws Exception {
        isAvailable = false;
        if (index > maxSize || index < 0) {
            throw new Exception("Index " + index + " is invalid. Please try again with a different index");
        }
        elements[index] = null;
        isAvailable = true;
    }
}
