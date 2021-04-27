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

    public SimulatedProcess pop() {
        try {
            return processes.poll();
        } catch (NoSuchElementException e) {
            System.out.println("The queue is empty");
            return null;
        }
    }

    public void push(SimulatedProcess process) {
        processes.add(process);
    }

    public void print(){
        if(processes.isEmpty()){
            System.out.println("             Queue is empty  ");
        }
        for(SimulatedProcess process: processes) {
            System.out.println("             Process: " + process.getPid());
        }
    }

    public boolean isEmpty(){
        return processes.size() == 0;
    }
}
