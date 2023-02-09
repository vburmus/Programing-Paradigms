package Task_1;

class Count extends Thread {
    private static IntCell n = new IntCell();

    @Override public void run() {
      int temp;
      for (int i = 0; i < 200000; i++) {
        temp = n.getN(); 
        n.setN(temp + 1);
      }
    }

    public static void main(String[] args) {
      Count p = new Count();
      Count q = new Count();
      p.start();
      q.start();
      try { p.join(); q.join(); }
      catch (InterruptedException e) { }
      System.out.println("The value of n is " + n.getN());
       /* Wartość n nigdy nie będzie równa 400000. Za każdym razem wynik programu będzie w przedziale od
        200000 do 400000. Program zachowuje się w ten sposób, ponieważ zmienna n w klasie IntCell jest
        pobierana przez 2 wątki(obszar krytyczny) i te wątki nie są synchronizowane.
        Z tego powodu mamy wyścig (Race conditions), czyli sytuację, w której dwa lub więcej procesów wykonuje operację na zasobach
        dzielonych, a ostateczny wynik tej operacji jest zależny od momentu jej realizacji. W naszym przypadku
        jeden z wątków pobiera wartość n w momencie, gdy drugi wątek już jej inkrementuje lub tylko pobiera,
        przez co będzie zwiększenie tej samej wartości o 1 przez oba wątki. W wyniku n zwiększy się tylko o 1
        chociaż dwukrotnie próbowano zwiększyć jej wartość. CHAOS.CHAOS.CHAOS.CHAOS*/
    }
}