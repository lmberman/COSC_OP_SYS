/**
 * Object to represent an individual {@link Page} of a given {@link SimulatedProcess}
 *
 * This object contains a {@link Byte} array with a max size of 64 bytes
 */
public class Page {
    private byte[] data;
    private int maxSize = 64;

    Page(){
        data = new byte[maxSize];
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
}
