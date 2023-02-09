package Task_3;

public class Consumer extends Thread {
    final private Consume buf;


    public Consumer(String name, Consume buf) {
        super(name); this.buf = buf; 
    }

    @Override public void run() {
      for (int i = 1; i <= 50; i++) {
         System.out.println(getName()+" consumed " + buf.take());
      }
    }
}

