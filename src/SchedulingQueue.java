import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class represents a scheduling queue
 * In this simple Operating System (Janis) these scheduling queues are:
 * a. Ready Queue
 * b. Disk blocked Queue
 */
public class SchedulingQueue {

    private LinkedList<SimulatedProcess> processes;

    SchedulingQueue() {
        processes = new LinkedList<>();
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
        processes.push(process);
    }

    public void print(){
        if(processes.isEmpty()){
            System.out.println("    Queue is empty  ");
        }
        for(SimulatedProcess process: processes) {
            System.out.println("             Process: " + process.getPid());
        }
    }

    public boolean isEmpty(){
        return processes.size() == 0;
    }
}
