import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

/**
 * This class will generate a file with a large amount of lines and text inside of it.
 * This file will be used to test our operating system as the file lines only need to
 * be read no actions on the computer need to physically occur
 */
public class RandomProcessFileGenerator {

    private File randomFile;
    private String filename;
    private FileWriter fileWriter;
    private FileReader fileReader;

    RandomProcessFileGenerator() {
        int fileNumber = new Random().nextInt() * 1000;
        int numberOfLetters = new Random().nextInt() * 700;
        filename = "RandomFile_" + fileNumber + ".txt";
        randomFile = new File(filename);
        try {
            fileWriter = new FileWriter(randomFile);
            for (int letter = 1; letter < numberOfLetters; letter++) {
                int num = new Random().nextInt(256);
                fileWriter.append((char) num);
            }
            fileWriter.close();
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            fileReader = new FileReader(randomFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getRandomFile() {
        return randomFile;
    }

    public void setRandomFile(File randomFile) {
        this.randomFile = randomFile;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }
}
