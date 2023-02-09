
public class Task {

    private int numberOfThreads;

    private int numberOfIterations;

    private int pause;

    private int c1;

    private int c2;

    public Task(int numberOfThreads, int numberOfIterations, int pause) {
        this.numberOfThreads = numberOfThreads;
        this.numberOfIterations = numberOfIterations;
        this.pause = pause;
    }
    private synchronized void increment(){
        incr();
    }

    private void incr() {
        for (int j = 0; j < numberOfIterations; j++) {

            System.out.println( (c1 == c2 ?  "true " + c1 + " " + c2 : "false " + c1 + " " + c2));

            c1++;
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c2++;


        }
    }

    public void compare() {
        this.c1 = 0;
        this.c2 = 0;
        for(int i = 0; i < numberOfThreads; i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    incr();
                }
            };

            t.start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void compareSync() {
        this.c1 = 0;
        this.c2 = 0;
        for(int i = 0; i < numberOfThreads; i++){
            Thread t = new Thread(() -> increment());

            t.start();
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Task t = new Task(2, 5, 100);
        t.compare();
        Thread.sleep(5000);
        System.out.println("~~~");
        t.compareSync();
    }

}
