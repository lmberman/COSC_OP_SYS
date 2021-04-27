import java.io.File;

public class Main {

    public static void main(String[] args) {

        MemoryManager memoryManager = new MemoryManager();
        SchedulingManager schedulingManager = new SchedulingManager();
        populateQueuesAndMemory(memoryManager, schedulingManager);   
        beginExecution(memoryManager, schedulingManager);
    }
    public static void populateQueuesAndMemory(MemoryManager memoryManager, SchedulingManager schedulingManager) {
        System.out.println("This is our simple Operating System \"Janis\"!");
        int scriptNum = 1;
        System.out.println("Creating 20 processes to execute");
        for (int i = 0; i < 20; i++) {
            SimulatedProcess process = new SimulatedProcess(i, new File("COSC_OP_SYS\\src\\TestScript" + scriptNum + ".sh"));
            if(memoryManager.isMemoryFull()){
                schedulingManager.addProcessToDiskBlockedQueue(process);
            } else {
                memoryManager.createPageTableForProcess(process);
                if(process.getPageTable() != null){
                    schedulingManager.addProcessToReadyQueue(process);
                }
            }
            if (scriptNum == 5) {
                scriptNum = 0;
            }
            scriptNum++;
            schedulingManager.printQueues();
        }
    }
    public static void beginExecution(MemoryManager memoryManager, SchedulingManager schedulingManager) {
        CPU cpu = new CPU();
        while(!schedulingManager.readyQueueIsEmpty()) {
            SimulatedProcess process = schedulingManager.getNextReadyProcess();
            cpu.executeProcess(process, memoryManager);
            if(process.isEmpty()){
                memoryManager.decreaseProcessCount();
            } else {
                schedulingManager.addProcessToReadyQueue(process);
            }
            if(!memoryManager.isMemoryFull() && !schedulingManager.blockedQueueIsEmpty()) {
                SimulatedProcess blockedProcess = schedulingManager.removeProcessFromDiskBlockedQueue();
                memoryManager.createPageTableForProcess(blockedProcess);
                schedulingManager.addProcessToReadyQueue(blockedProcess);
            }
            schedulingManager.printQueues();
        }
        schedulingManager.printQueues();
    }  
}

