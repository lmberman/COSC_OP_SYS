import java.io.File;

public class Main {

    public static void main(String[] args) {

        MemoryManager memoryManager = new MemoryManager();

        System.out.println("This is our simple Operating System \"Janis\"!");
        int scriptNum = 1;
        System.out.println("Creating 20 processes to execute");
        for(int i= 0;i<20;i++){
            SimulatedProcess process = new SimulatedProcess(i, new File("src/TestScript" + scriptNum + ".sh"));
            memoryManager.createPageTableForProcess(process);
            if(scriptNum == 5){
                scriptNum = 0;
            }
            scriptNum++;
        }




    }
}
