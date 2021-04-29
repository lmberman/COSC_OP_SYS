import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This class represents a scheduling queue
 * In this simple Operating System (Janis) these scheduling queues are:
 * a. Ready Queue
 * b. Disk blocked Queue
 */
public class SchedulingQueue {

    private Queue<SimulatedProcess> processes;

    SchedulingQueue() {
        processes = new LinkedList<>();
    }

    public int getCurrentSize() {
        return processes.size();
    }

    /**
     * Removes next element from the process Queue
     * @return next element {@link SimulatedProcess}
     */
    public SimulatedProcess pop() {
        try {
            return processes.poll();
        } catch (NoSuchElementException e) {
            System.out.println("The queue is empty");
            return null;
        }
    }

    /**
     * Adds a {@link SimulatedProcess} to the processes queue
     * @param process {@link SimulatedProcess} to be added
     */
    public void push(SimulatedProcess process) {
        processes.add(process);
    }

    /**
     * Prints the contents of the queue
     * If the queue is empty "Queue is Empty" is printed
     * Else each {@link SimulatedProcess} is printed to the out put with its corresponding pid
     */
    public void print(){
        if(processes.isEmpty()){
            System.out.println("             Queue is empty  ");
        }
        for(SimulatedProcess process: processes) {
            System.out.println("             Process: " + process.getPid());
        }
    }

    /**
     * Checks if the queue is empty by ensuring its size is equal to 0
     * @return boolean value if queue size is equal to 0 
     */
    public boolean isEmpty(){
        return processes.size() == 0;
    }
}
