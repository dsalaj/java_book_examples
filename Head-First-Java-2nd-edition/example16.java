
public class example16 implements Runnable {

  public static void main(String[] args) {

    example16 job = new example16();
    Thread a = new Thread(job);
    Thread b = new Thread(job);
    a.start();
    b.start();
  }

  public void run() {
    String name = Thread.currentThread().getName();
    for(int i = 0; i < 15; i++) {
      System.out.println(name + " is running");
    }
  }
}
