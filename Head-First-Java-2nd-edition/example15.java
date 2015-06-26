
class example15 {

  public static void main(String[] args) {

    Runnable job = new Job();
    Thread worker = new Thread(job);
    worker.start();
    System.out.println("finished in main");
  }
}

class Job implements Runnable {

  public void run() {
    go();
  }

  private void go() {
    System.out.println("whatever you want");
  }

}
