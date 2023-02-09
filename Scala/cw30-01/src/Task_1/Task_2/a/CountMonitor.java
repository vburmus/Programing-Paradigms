package Task_1.Task_2.a;

class CountMonitor extends Thread {
    private static IntCellMonitor n = new IntCellMonitor();

    @Override public void run() {
      int temp;
      for (int i = 0; i < 200000; i++) {
          //synchronized(n){
          //temp = n.getN();
          //n.setN(temp + 1);
          // }
        n.increment();
      }
    }

    public static void main(String[] args) {
      CountMonitor p = new CountMonitor();
      CountMonitor q = new CountMonitor();
      p.start();
      q.start();
      try { p.join(); q.join(); }
      catch (InterruptedException e) { }
      System.out.println("The value of n is " + n.getN());
    }
}