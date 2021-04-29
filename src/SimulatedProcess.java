import java.io.File;

/**
 * Class for a process in the janis operating system
 */
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

    /**
     * Checks if the {@link ProcessControlBlock} {@link PageTable} has anymore pages by checking 
     * its size. returns true if the page table size is 0
     * @return boolean value symbolizing the {@link PageTable#getSize()}
     */
    public boolean isEmpty(){
        return this.processControlBlock.getPageTable().getSize() == 0;
    }

    /**
     * Retrieves the next available page in the {@link ProcessControlBlock#getPageTable()}
     * @return next page in the {@link ProcessControlBlock} {@link PageTable}
     */
    public Page getNextPage() {
        return this.processControlBlock.getNextPage();
    }
}
