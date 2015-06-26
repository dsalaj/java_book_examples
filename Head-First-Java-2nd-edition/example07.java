import javax.sound.midi.*;

public class example07 {

  public void play() {

    try {

      Sequencer player = MidiSystem.getSequencer();
      player.open();

      Sequence s = new Sequence(Sequence.PPQ, 4);
      Track t = s.createTrack();

      ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 54, 100);
      MidiEvent noteOn = new MidiEvent(a, 1);
      t.add(noteOn);

      ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 54, 100);
      MidiEvent noteOff = new MidiEvent(a, 3);
      t.add(noteOff);

      player.setSequence(s);
      player.start();

    }
    catch(Exception e) {

      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    example07 p = new example07();
    p.play();
    try{ Thread.sleep(1500); } catch(Exception ex) { ex.printStackTrace(); }
    System.exit(0);
  }

}
