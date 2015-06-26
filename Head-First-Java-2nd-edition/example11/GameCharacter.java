import java.io.*;

public class GameCharacter implements Serializable {

  int power;
  String type;
  String[] weapons;

  public GameCharacter(int p, String t, String[] w) {

    power = p;
    type = t;
    weapons = w;
  }

  public int getPower() {

    return power;
  }

  public String getType() {

    return type;
  }
}
