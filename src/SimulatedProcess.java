import java.io.File;

public class SimulatedProcess {
    private long pid;
    private ProcessControlBlock processControlBlock;

    SimulatedProcess(long pid, File file){
        System.out.println("Creating new Process with pid " + pid + " and file " + file.getName());
        this.pid = pid;
        processControlBlock = new ProcessControlBlock(pid, file);
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public ProcessControlBlock getProcessControlBlock() {
        return processControlBlock;
    }

    public void setProcessControlBlock(ProcessControlBlock processControlBlock) {
        this.processControlBlock = processControlBlock;
    }

    public void setPageTable(PageTable pageTable){
        this.processControlBlock.setPageTable(pageTable);
    }

    public PageTable getPageTable(){
        return this.processControlBlock.getPageTable();
    }
}
