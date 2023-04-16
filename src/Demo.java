public class Demo {
    public static void main(String[] args) {
        int numOfThreads = 4;
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(new Task(i));
            threads[i].start();
        }
        for (int i = 0; i < numOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("All threads have finished executing.");
    }
}

class Task implements Runnable {
    private int taskId;

    public Task(int id) {
        this.taskId = id;
    }

    public void run() {
        System.out.println("Task " + taskId + " is running.");
        try {
            Thread.sleep(2000); // Simulate some work for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " has finished.");
    }
}
