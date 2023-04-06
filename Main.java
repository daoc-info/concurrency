import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public void createProcess(String... command) throws IOException {
        ProcessBuilder p = new ProcessBuilder(command);
        
        p.directory(new File(System.getProperty("user.dir")));
        p.inheritIO();
        p.start();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        Main me = new Main();
        for(String a : args) {
            switch (a) {
                case "uno":
                    me.createProcess("notepad.exe");
                    break;
                case "dos":
                    me.createProcess("java", "Hello.java");
                    break;    
                case "tres":
                    me.createProcess("java", "ReaderMMF.java");
                    me.createProcess("java", "WriterMMF.java", "1");
                    me.createProcess("java", "WriterMMF.java", "2");
                    break;                   
                default:
                    break;
            }
        }
        System.out.println("Finishing main process");
    }
}
