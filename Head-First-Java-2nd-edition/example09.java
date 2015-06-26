import javax.sound.midi.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;


public class example09 {

  static JFrame f = new JFrame("Beat Squares");
  static MyDrawPanel ml;

  public static void main(String[] args) {
    example09 music_player = new example09();
    music_player.go();
  }

  public void setUpGui() {
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ml = new MyDrawPanel();
    f.setContentPane(ml);
    f.setBounds(30, 30, 300, 300);
    f.setVisible(true);
  }

  public void go() {
    setUpGui();

    try {

      Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequencer.addControllerEventListener(ml, new int[] {127});
      Sequence seq = new Sequence(Sequence.PPQ, 4);
      Track track = seq.createTrack();

      int r = 0;
      for(int i = 0; i < 1200; i += 1+(int)(Math.random() * 5)) {

        r = (int) ((Math.random() * 25) + 45);
        track.add(makeEvent(176, 1, 127, 0,   i  ));
        track.add(makeEvent(144, 1, r,   100, i  ));
        track.add(makeEvent(128, 1, r,   100, i+1+(int)(Math.random() * 7)));
      }

      sequencer.setSequence(seq);
      sequencer.start();
      sequencer.setTempoInBPM(160);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void controlChange(ShortMessage m) {
    System.out.println("la");
  }

  public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {

    MidiEvent event = null;
    try {
      ShortMessage m = new ShortMessage();
      m.setMessage(comd, chan, one, two);
      event = new MidiEvent(m, tick);
    } catch(Exception e) {
      e.printStackTrace();
    }
    return event;
  }

}

class MyDrawPanel extends JPanel implements ControllerEventListener {

  boolean msg = false;

  public void controlChange(ShortMessage event) {
    msg = true;
    repaint();
  }

  public void paintComponent(Graphics g) {

    if (msg) {

      Graphics2D g2 = (Graphics2D) g;

      int r = (int) (Math.random() * 250);
      int gr = (int) (Math.random() * 250);
      int b = (int) (Math.random() * 250);

      g.setColor(new Color(r,gr,b));

      int ht = (int) ((Math.random() * 120) + 10);
      int width = (int) ((Math.random() * 120) + 10);
      int x = (int) ((Math.random() * this.getWidth()));
      int y = (int) ((Math.random() * this.getHeight()));
      g.fillRect(x, y, ht, width);
      msg = false;
    }
  }
}
