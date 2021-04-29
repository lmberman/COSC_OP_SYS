import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the object which controls the memory allocation of the system
 * Main Memory is limited to 10 {@link SimulatedProcess}s at a time.
 * Elements of Main Memory are stored as {@link Frame}s
 * 
 * This class is in charge of paginating {@link SimulatedProcess}s file 
 * and saves is corresponding {@link Frame}s
 */
public class MemoryManager {

    private int maxNumOfProcesses;
    private int currentNumOfProcesses;
    private List<Frame> mainMemory;
    private int frameAndPageSize;

    MemoryManager(){
        this.maxNumOfProcesses = 10;
        currentNumOfProcesses = 0;
        mainMemory = new ArrayList<>();
        frameAndPageSize = 64;
    }

    MemoryManager(int maxNumOfProcesses, int frameAndPageSize){
        this.maxNumOfProcesses = maxNumOfProcesses;
        currentNumOfProcesses = 0;
        mainMemory = new ArrayList<>();
        this.frameAndPageSize = frameAndPageSize;
    }

    public void increaseCurrentNumOfProcesses(){
        currentNumOfProcesses++;
    }

    public boolean isMemoryFull(){
        return currentNumOfProcesses == maxNumOfProcesses;
    }

    public void decreaseProcessCount(){
            currentNumOfProcesses--;
    }

    /**
     * Creates a {@link PageTable} for the given {@link SimulatedProcess} based on the size of its script
     * @param simulatedProcess {@link SimulatedProcess} for which we will create a page table
     * @return updated {@link SimulatedProcess} with page table or original unmodified process
     */
    public void createPageTableForProcess(SimulatedProcess simulatedProcess) {
        System.out.println("Creating Page Table for process " + simulatedProcess.getPid() + " and store pages in main memory");
        if(currentNumOfProcesses < maxNumOfProcesses){
            PageTable pageTable = new PageTable();
            File processScript = simulatedProcess.getProcessControlBlock().getScript();
            try {
                FileInputStream fileInputStream = new FileInputStream(processScript.getAbsolutePath());
                int dataLength = 0;
                while (dataLength > - 1){
                    Page page = new Page(frameAndPageSize);
                    dataLength = fileInputStream.read(page.getData(), 0, page.getMaxSize());
                    if(dataLength != -1) {
                        //store the page in main memory
                        storePageInMainMemory(page);
                        //push the page into the page table
                        pageTable.push(page);
                    }
                }
                fileInputStream.close();
                simulatedProcess.setPageTable(pageTable);
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("File " + processScript.getName() + " can not be found. Unable to create Page Table");
            } catch (IOException ioException) {
                System.out.println("Unable to read from file");
            }
            increaseCurrentNumOfProcesses();
        } 
    }

    /**
     * Converts a {@link Page} into a {@link Frame} to be stored in {@link MemoryManager#mainMemory}
     * Retrieves an index for the created {@link Frame} representing where it is stored in {@link MemoryManager#mainMemory}
     * @param page {@link Page} to store in {@link Frame}
     */
    public void storePageInMainMemory(Page page){
        System.out.println("Storing page data in a frame in main memory");
        Frame frame = new Frame();
        frame.setData(page.getData());
        // get the current index in main memory for which the frame will be stored
        int currentIndex = mainMemory.size();
        mainMemory.add(frame);
        page.setFrameId(currentIndex);
    }

    /**
     * Get frame from main memory at index i for the CPU to process
     * @param index location in main memory for which to retrieve the desired {@link Frame}
     * @return {@link Frame} stored at provided index
     */
    public Frame getFrame(int index){
        return mainMemory.get(index);   
    }
}
