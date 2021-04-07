import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("This is our simple Operating System \"Janis\"!");

        RandomProcessFileGenerator fileGenerator = new RandomProcessFileGenerator();
        ProcessBuilder processBuilder = new ProcessBuilder(fileGenerator.getRandomFile().getAbsolutePath());
        try{
            Process process = processBuilder.start();
            ProcessControlBlock pcb = new ProcessControlBlock(process, ProcessPriority.MEDIUM, TimeUnit.SECONDS, 1);

        } catch(IOException e){
            e.printStackTrace();
        }


    }
}
