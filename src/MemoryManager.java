import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the object which controls the memory allocation of the system
 * Memory is limited to 10 {@link SimulatedProcess}s at a time.
 * {@link SimulatedProcess}s sizes can range from single to multiple {@link Page}s
 * This means that at max 10 {@link SimulatedProcess}s can be in a ready state at any given time
 * and loaded to memory for processing
 */
public class MemoryManager {

    private int maxNumOfProcesses = 10;
    private int currentNumOfProcesses;
    private List<Page> mainMemory;

    MemoryManager(){
        currentNumOfProcesses = 0;
        mainMemory = new ArrayList<>();
    }
    /**
     * TODO: Methods needed
     * method to determine size of a Process script, create Pages, create Page Table, and assign the page table to the Process
     * method to pull pages from a process and store them into main memory
     * method to remove pages from main memory
     */

    /**
     * Creates a {@link PageTable} for the given {@link SimulatedProcess} based on the size of its script
     * @param simulatedProcess {@link SimulatedProcess} for which we will create a page table
     * @return updated {@link SimulatedProcess} with page table or original unmodified process
     */
    public void createPageTableForProcess(SimulatedProcess simulatedProcess) {
        System.out.println("Creating Page Table for process " + simulatedProcess.getPid());
        PageTable pageTable = new PageTable();
        File processScript = simulatedProcess.getProcessControlBlock().getScript();
        try {
            FileInputStream fileInputStream = new FileInputStream(processScript);
            int dataLength = 0;
            while (dataLength > - 1){
                Page page = new Page();
                dataLength = fileInputStream.read(page.getData(), 0, page.getMaxSize());
                if(dataLength != -1) {
                    pageTable.push(page);
                }
            }
            simulatedProcess.setPageTable(pageTable);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File " + processScript.getName() + " can not be found. Unable to create Page Table");
        } catch (IOException ioException) {
            System.out.println("Unable to read from file");
        }
    }

    public void storeProcess(SimulatedProcess process){
    }
}
