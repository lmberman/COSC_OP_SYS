import java.io.File;

/**
 * Class to symbolize the Process Control Block for a given Process
 * This class will store all information regarding the status of the Process
 * includes(pid and file which process is associated to)
 */
public class ProcessControlBlock {

    private long pid;
    private File script;
    private PageTable pageTable;

    ProcessControlBlock() { }

    ProcessControlBlock(long pid, File script) {
        this.pid = pid;
        this.script = script;
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

    public PageTable getPageTable() {
        return pageTable;
    }

    public void setPageTable(PageTable pageTable) {
        this.pageTable = pageTable;
    }

    public Page getNextPage(){
        return this.pageTable.pop();
    }
}
