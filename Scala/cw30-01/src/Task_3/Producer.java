package Task_3;

public class Producer extends Thread {
    final private Produce buf;

    public Producer(String name, Produce buf) {
    	super(name); this.buf = buf; 
    }

    @Override public void run() {
      for (int i = 1; i <= 50; i++) {
         System.out.println(getName()+" producing "+i);
         buf.put(i);
      }
    }
}

