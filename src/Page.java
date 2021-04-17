/**
 * Object to represent an individual {@link Page} of a given {@link SimulatedProcess}
 * <p>
 * This object contains a {@link Byte} array with a max size of 64 bytes
 * <p>
 * It has a frameId which represents the frame id stored in main memory
 */
public class Page {
    private byte[] data;
    private long frameId;
    private int maxSize = 64;

    Page() {
        data = new byte[maxSize];
        frameId = -1;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public long getFrameId() {
        return frameId;
    }

    public void setFrameId(long frameId) {
        this.frameId = frameId;
    }
}
