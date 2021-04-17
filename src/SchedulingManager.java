/**
 * Class managing our processing queues
 */
public class SchedulingManager {

    private SchedulingQueue readyQueue;
    private SchedulingQueue diskBlockedQueue;

    SchedulingManager() {
        readyQueue = new SchedulingQueue();
        diskBlockedQueue = new SchedulingQueue();
    }

    public void addProcessToReadyQueue(SimulatedProcess process){
        System.out.println("Adding process with pid " + process.getPid() + " to ready queue");
        readyQueue.push(process);
    }
    public SimulatedProcess removeProcessFromReadyQueue(){
        SimulatedProcess process = readyQueue.pop();
        System.out.println("Removing process with pid " + process.getPid() + " to Ready queue");
        return process;
    }

    public void addProcessToDiskBlockedQueue(SimulatedProcess process){
        System.out.println("Adding process with pid " + process.getPid() + " to disk blocked queue");
        diskBlockedQueue.push(process);
    }

    public SimulatedProcess removeProcessFromDiskBlockedQueue() {
        SimulatedProcess process = diskBlockedQueue.pop();
        System.out.println("Removing process with pid " + process.getPid() + " to disk blocked queue");
        return process;
    }

    public void moveProcessFromBlockedToReadyQueue() {
        SimulatedProcess blockedProcess = removeProcessFromDiskBlockedQueue();
        addProcessToReadyQueue(blockedProcess);
    }

    /**
     * Prints contents of queues to console
     */
    public void printQueues() {
        System.out.println("Ready Queue:");
       readyQueue.print();
        System.out.println("Disk Blocked Queue:");
       diskBlockedQueue.print();
    }
}
