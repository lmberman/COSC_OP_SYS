/**
 * Object to represent an individual {@link Page} of a given {@link SimulatedProcess}
 * <p>
 * This object contains a {@link Byte} array with a max size of 64 bytes
 * <p>
 * It has a frameId which represents the frame id stored in main memory
 */
public class Page {
    private byte[] data;
    private int frameId;
    private int maxSize = 64;

    Page() {
        data = new byte[maxSize];
        frameId = -1;
        maxSize = 64;
    }

    Page(int maxSize) {
        this.maxSize = maxSize;
        data = new byte[maxSize];
        frameId = -1;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
