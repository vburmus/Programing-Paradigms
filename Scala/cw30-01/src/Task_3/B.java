package Task_3;

public class B extends A {
    public B() {
        k++;
    }
    public void BM(){}
    public static void main(String[] args) {
        System.out.println(k);
        B w = new B();
        System.out.println(k);
        w.AM();
        A e = new A();

    }
}
