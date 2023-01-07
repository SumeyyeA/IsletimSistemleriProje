package FCFS_PROJE;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        
       // File file = new File("src/giris.txt");
       File file = new File("src\\giris.txt");
        ProcessBuilder processBuilder = new ProcessBuilder(file);
        ProcessBuilder.start();

    }
}
