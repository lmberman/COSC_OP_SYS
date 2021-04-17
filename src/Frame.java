/**
 * Represents a frame in main memory containing the data stored in a {@link Page}
 * Both {@link Page} and {@link Frame} are 64 byte arrays
 */
public class Frame {

    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
