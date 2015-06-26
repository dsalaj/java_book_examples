
import java.io.*;
import java.net.*;

public class DailyAdviceClient {

  public void go() {

    try {

      Socket s = new Socket("127.0.0.1", 4242);
      InputStreamReader isr = new InputStreamReader(s.getInputStream());
      BufferedReader reader = new BufferedReader(isr);

      String advice = reader.readLine();
      System.out.println("Advice: " + advice);
      reader.close();

    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {

    DailyAdviceClient c = new DailyAdviceClient();
    c.go();
  }
}
