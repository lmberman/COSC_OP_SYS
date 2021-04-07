import java.util.concurrent.TimeUnit;

/**
 * Class to symbolize the Process Control Block for a given Process
 * This class will store all information regarding the status of the Process
 * <p>
 * A pointer to the process itself
 * includes(pid and file which process is associated to)
 * A program counter (line number for which the file reader is currently reading)
 * Process priority (defaulted to low unless specified)
 * A reference to the queue (Ready or IO blocked queue) for which the process currently resides
 * Base and limit register indexes for where the page of the process is stored in the page table
 * Its time limit to ensure equal amounts of IO time
 */
public class ProcessControlBlock {

    private Process process;
    private long programCounter;
    private ProcessPriority priority;
    private SchedulingQueue schedulingQueue;
    private int baseRegIndex;
    private int limitRegIndex;
    private int timeLimit;
    private TimeUnit timeLimitUnit;

    ProcessControlBlock() {
        process = null;
        programCounter = 0;
        priority = ProcessPriority.LOW;
        timeLimit = 1;
        timeLimitUnit = TimeUnit.SECONDS;
        //TODO: Need Base Reg and Limit Reg Index settings
    }

    ProcessControlBlock(ProcessPriority processPriority, TimeUnit timeUnit, int timeLimit) {
        this.process = null;
        this.programCounter = 0;
        this.priority = processPriority;
        this.timeLimitUnit = timeUnit;
        this.timeLimit = timeLimit;

    }

    ProcessControlBlock(Process process, ProcessPriority processPriority, TimeUnit timeUnit, int timeLimit) {
        this.process = process;
        this.programCounter = 0;
        this.priority = processPriority;
        this.timeLimitUnit = timeUnit;
        this.timeLimit = timeLimit;

    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public long getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(long programCounter) {
        this.programCounter = programCounter;
    }

    public ProcessPriority getPriority() {
        return priority;
    }

    public void setPriority(ProcessPriority priority) {
        this.priority = priority;
    }

    public SchedulingQueue getSchedulingQueue() {
        return schedulingQueue;
    }

    public void setSchedulingQueue(SchedulingQueue schedulingQueue) {
        this.schedulingQueue = schedulingQueue;
    }

    public int getBaseRegIndex() {
        return baseRegIndex;
    }

    public void setBaseRegIndex(int baseRegIndex) {
        this.baseRegIndex = baseRegIndex;
    }

    public int getLimitRegIndex() {
        return limitRegIndex;
    }

    public void setLimitRegIndex(int limitRegIndex) {
        this.limitRegIndex = limitRegIndex;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public TimeUnit getTimeLimitUnit() {
        return timeLimitUnit;
    }

    public void setTimeLimitUnit(TimeUnit timeLimitUnit) {
        this.timeLimitUnit = timeLimitUnit;
    }
}
