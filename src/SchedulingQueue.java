import java.util.LinkedList;
import java.util.NoSuchElementException;

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

    private long maxSize = 10;
    private LinkedList<SimulatedProcess> processes;
    private boolean isAvailable;

    SchedulingQueue() {
        processes = new LinkedList<>();
        isAvailable = true;
    }

    public int getCurrentSize() {
        return processes.size();
    }

    public SimulatedProcess pop() {
        try {
            return processes.pop();
        } catch (NoSuchElementException e) {
            System.out.println("The queue is empty");
            return null;
        }
    }

    public void push(SimulatedProcess process) {
        isAvailable = false;
        processes.push(process);
        isAvailable = true;
    }
}
