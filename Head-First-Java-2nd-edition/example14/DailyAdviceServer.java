
import java.io.*;
import java.net.*;

public class DailyAdviceServer {

  String[] advices = {"Take smaller bites", "Advice two...", "Three... bla bla", "42"};

  public void go() {

    try {
      ServerSocket ss = new ServerSocket(4242);
      while(true) {
        Socket s = ss.accept();

        PrintWriter writer = new PrintWriter(s.getOutputStream());
        String advice = getAdvice();
        writer.println(advice);
        writer.close();
        System.out.println(advice);
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }

  private String getAdvice() {

    int random = (int)(Math.random() * advices.length);
    return advices[random];
  }

  public static void main(String[] args) {

    DailyAdviceServer s = new DailyAdviceServer();
    s.go();
  }
}
