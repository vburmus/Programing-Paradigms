package Task_1.Task_2.b;

import java.util.concurrent.Semaphore;

class CountSemafor extends Thread {
    private static IntCellSemafor n = new IntCellSemafor();
    private static Semaphore semaphore = new Semaphore(1);
    @Override public void run() {
      int temp;
      try {
          for (int i = 0; i < 200000; i++) {
              semaphore.acquire();
              temp = n.getN();
              n.setN(temp + 1);
              semaphore.release();
          }
      }catch (InterruptedException e){
          e.printStackTrace();
      }
    }

    public static void main(String[] args) {
      CountSemafor p = new CountSemafor();
      CountSemafor q = new CountSemafor();
      p.start();
      q.start();
      try { p.join(); q.join(); }
      catch (InterruptedException e) { }
      System.out.println("The value of n is " + n.getN());

    }
}