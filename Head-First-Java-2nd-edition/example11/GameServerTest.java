import java.io.*;

public class GameServerTest {

  public static void main(String[] args) {

    GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow","sword","dust"});

    System.out.println("Hero power = " + one.getPower() + " type = " + one.getType() );

    try{

      FileWriter w = new FileWriter("Game.txt");
      ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
      os.writeObject(one);
      w.write(one.toString());
      os.close();
      w.close();
    } catch(IOException ex) {

      ex.printStackTrace();
    }

    one = null;

    try{

      ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
      GameCharacter oneRestore = (GameCharacter) is.readObject();
      System.out.println("Restored hero power = " + oneRestore.getPower() + " type = " + oneRestore.getType() );
    } catch(Exception ex) {

      ex.printStackTrace();
    }

  }
}
