import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;

/**
 * Central Processing Unit to pull processes from Ready Queue, staging their pages into {@link MemoryManager#mainMemory},
 * and executing the frames once stored in {@link MemoryManager#mainMemory}
 */
public class CPU {

    public void executeProcess(SimulatedProcess process, MemoryManager memoryManager) {
        Instant start = Instant.now();
        System.out.print("Pulling page frame from main memory and executing it at " + start);
        Page nextPage = process.getNextPage();
        Frame frame = memoryManager.getFrame(nextPage.getFrameId());
        byte[] frameData = frame.getData();
        String scriptLine = new String(frameData);
        try {
            Runtime.getRuntime().exec(scriptLine);
        } catch (IOException ioException){
        }
        Instant end = Instant.now();
        System.out.print("Completed frame execution at  " + end);
        System.out.print("Duration(in ms): " + Duration.between(start, end).toMillis());
    }

}
