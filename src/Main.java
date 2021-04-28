import java.io.File;

/** 
   @author Lindsei Berman
   @author Cherrie Espineda
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

