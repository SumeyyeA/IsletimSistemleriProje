package FCFS_PROJE;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessBuilder {

    private static Queue<Process> processQueue;//işlem listesi
    private static Color color;//renk sınıfı
    private static int time = 0;//süre
    private static int id = 0;//id

    public ProcessBuilder(File file) {
        processQueue = new Queue<>(50);//50 elemanlı liste oluşturuldu
        readFile(file);//dosya okundu
        color = new Color();
    }

    public static void start() {

        while (!processQueue.isEmpty()) {
            execute(processQueue.dequeue(), color.getColor());//işlemler listeden sırayla çıkartılıp işlenmek üzere gönderiliyor
            color.getColor();
            id++;
            if (time > 20) {//20 saniye limiti
                break;
            }
        }

    }

    private static void execute(Process process, String colors) {//işlemlerin işlendiği metot

        int len = process.getProcessTime();

        for (int i = len; i>= 0;i--) {
            if (i == len) {
                System.out.println(colors +time + "sn proses başladı. (id: 000"+ id+ " öncelik: "+process.getPriority()+" kalan süre:"+ process.getProcessTime());
            } else if (i == 0) {
                System.out.println(colors +time + "sn proses sonlandı. (id: 000"+ id+ " öncelik: "+process.getPriority()+" kalan süre:"+ process.getProcessTime());
            } else {
                System.out.println(colors +time + "sn proses yürütülüyor. (id: 000"+ id+ " öncelik: "+process.getPriority()+" kalan süre:"+ process.getProcessTime()+")");
            }
            time++;
            if (time > 20) {// 20 saniye limiti
                System.out.println("SÜRE DOLDU");
                break;
            }
            process.setProcessTime(process.getProcessTime() - 1);//her saniye geçtikten sonra işlenen süre işlem süresinden düşürülüyor
        }


    }

    public static void printList() {//test emek için oluşturulmuş ekleme metodu
        for (int i = 0; i < processQueue.getCurrentSize(); i++) {
            Process item = processQueue.dequeue();
            System.out.println("Arrival Time: " +item.getArrivalTime() +" Priority: "+item.getPriority() + " Process Time: " +item.getProcessTime());
        }
    }

    private void readFile(File file) {

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {//txt dosyasından çekilen elemanlar teker teker sıraya ekleniyor
                String line = scanner.nextLine();
                String[] arr = line.split(",");//her satır parçalanıp gerekli parça gerekli kısma kayıt ediliyor
                int arrivalTime = Integer.parseInt(arr[0]);
                int priority = Integer.parseInt(arr[1]);
                int processTime = Integer.parseInt(arr[2]);
                processQueue.enqueue(new Process(arrivalTime, priority, processTime));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found: " + e.getLocalizedMessage());
        }

    }

}
