import java.io.File;
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

    private long pid;
    private File script;
    private long programCounter;
    private SchedulingQueue schedulingQueue;
    private int baseRegIndex;
    private int limitRegIndex = 64;
    private PageTable pageTable;

    ProcessControlBlock() { }

    ProcessControlBlock(long pid, File script) {
        this.pid = pid;
        this.script = script;
        this.programCounter = 0;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public File getScript() {
        return script;
    }

    public void setScript(File script) {
        this.script = script;
    }

    public long getProgramCounter() {
        return programCounter;
    }

    public void setProgramCounter(long programCounter) {
        this.programCounter = programCounter;
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

    public PageTable getPageTable() {
        return pageTable;
    }

    public void setPageTable(PageTable pageTable) {
        this.pageTable = pageTable;
    }
}
