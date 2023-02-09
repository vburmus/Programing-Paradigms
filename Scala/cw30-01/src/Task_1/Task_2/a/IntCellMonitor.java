package Task_1.Task_2.a;

class IntCellMonitor {
    private int n = 0;
    public  int getN() {return n;}
    public  void setN(int n) {this.n = n;}

    private void incr(){
        n++;
    }
    protected synchronized void increment(){
        incr();
    }
}
