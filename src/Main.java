import java.io.File;

/** 
   @author Lindsei Berman
   @author Cherrie Espineda
   @author Alfred Ajishe
**/

public class Main {

    public static void main(String[] args) { 
        System.out.println("This is our simple Operating System \"Janis\"!");
        System.out.println("Here we goooooooooo.....=)");
        int numOfProcesses = 20;
        int maxProcessesInMemory = 10;
        int pageSize = 64;
        if(args.length == 3) {
            numOfProcesses = Integer.parseInt(args[0]);
            maxProcessesInMemory = Integer.parseInt(args[1]);
            pageSize = Integer.parseInt(args[2]);
        }
        MemoryManager memoryManager = new MemoryManager(maxProcessesInMemory, pageSize);
        SchedulingManager schedulingManager = new SchedulingManager();
        populateQueuesAndMemory(memoryManager, schedulingManager, numOfProcesses);   
        beginExecution(memoryManager, schedulingManager);
    }

    /**
     * Paginates the first 10 {@link SimulatedProcess}s and store them in the Ready Queue {@link SchedulingQueue}
     * Places remaining {@link SimulatedProcess}s in the Disk Blocked Queue {@link SchedulingQueue} without paginating
     * until further processing can be done to them
     * @param memoryManager {@link MemoryManager} in charge of managing pagination and memory memory frame storage
     * @param schedulingManager {@link SchedulingManager} in charge of managing {@link SchedulingQueue}s
     * @param numOfProcesses the number of {@link SimulatedProcess}s to create
     */
    public static void populateQueuesAndMemory(MemoryManager memoryManager, SchedulingManager schedulingManager, int numOfProcesses) {
        int scriptNum = 1;
        System.out.println("Creating " + numOfProcesses +  " processes to execute");
        for (int i = 0; i < numOfProcesses; i++) {
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

    /**
     * Creates a new CPU object and allows it to begin executing processes from the ready queue
     * It also determines when to move {@link SimulatedProcess}s from the Disk Blocked {@link SchedulingQueue}
     * This method continues to execute processes from these queues until both {@link SchedulingQueue}s are empty
     * @param memoryManager {@link MemoryManager} in charge of main memory and paginating processes
     * @param schedulingManager {@link SchedulingManager} in charge of {@link SchedulingQueue}s
     */
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
        cpu.printClockDuration();
    }  
}

