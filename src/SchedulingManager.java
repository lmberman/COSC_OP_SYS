public class SchedulingManager {
    private SchedulingQueue readyQueue;
    private SchedulingQueue diskBlockedQueue;

    SchedulingManager() {
        readyQueue = new SchedulingQueue();
        diskBlockedQueue = new SchedulingQueue();
    }

    public void addProcessToReadyQueue(SimulatedProcess process){
        readyQueue.push(process);
    }
    public SimulatedProcess removeProcessFromReadyQueue(){
        return readyQueue.pop();
    }

    public void addProcessToDiskBlockedQueue(SimulatedProcess process){
        diskBlockedQueue.push(process);
    }

    public SimulatedProcess removeProcessFromDiskBlockedQueue() {
        return diskBlockedQueue.pop();
    }

    public void moveProcessFromBlockedToReadyState() {
        SimulatedProcess blockedProcess = removeProcessFromDiskBlockedQueue();
        addProcessToReadyQueue(blockedProcess);
    }
}
