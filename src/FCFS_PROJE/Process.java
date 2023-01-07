package FCFS_PROJE;

public class Process {

    private int arrivalTime;//varış süresi
    private int priority;//öncelik
    private int processTime;//işlem süresi

    public Process(int arrivalTime, int priority, int processTime) {
        this.arrivalTime = arrivalTime;
        this.priority = priority;
        this.processTime = processTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

}

