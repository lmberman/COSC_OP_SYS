import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * Central Processing Unit to pull processes from Ready Queue, staging their pages into {@link MemoryManager#mainMemory},
 * and executing the frames once stored in {@link MemoryManager#mainMemory}
 */
public class CPU {

    private Instant startTime;
    private Instant endTime;

    CPU() {
        startTime = Instant.now();
    }

    public void printClockDuration() {
        System.out.println("Total CPU time taken (in milliseconds): " + Duration.between(startTime, endTime).toMillis());
    }

    public void executeProcess(SimulatedProcess process, MemoryManager memoryManager) {
        Instant start = Instant.now();
        System.out.println("Pulling pages and frames from main memory and executing them for process " + 
        process.getPid() + " at " + start);
        Page nextPage = process.getNextPage();
        Frame frame = memoryManager.getFrame(nextPage.getFrameId());
        try {
            byte[] frameData = frame.getData();
            String filename = "ExecutingShell.sh";
            FileOutputStream outputStream = new FileOutputStream(filename);
            outputStream.write(frameData);
            outputStream.flush();
            outputStream.close();
            Runtime.getRuntime().exec(filename);
            File file = new File(filename);
            file.delete();
        } catch (IOException ioException){}
        Instant end = Instant.now();
        System.out.println("Completed frame execution at  " + end);
        System.out.println("Duration(in milliseconds): " + Duration.between(start, end).toMillis());
        endTime = Instant.now();

    }

}
