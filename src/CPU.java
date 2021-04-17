import java.util.List;

/**
 * Central Processing Unit to pull processes from Ready Queue, staging their pages into {@link MemoryManager#mainMemory},
 * and executing the frames once stored in {@link MemoryManager#mainMemory}
 */
public class CPU {

    private List<Frame> executingFrames;

    public List<Frame> getExecutingFrames() {
        return executingFrames;
    }

    public void setExecutingFrames(List<Frame> executingFrames) {
        this.executingFrames = executingFrames;
    }
}
