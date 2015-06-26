import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class example03 {

  private static class InputHelper {
  
    public String getUserInput() {
  
      String input = null;
      System.out.print("enter next move: ");
      try {
  
        BufferedReader is = new BufferedReader(new InputStreamReader( System.in ));
        input = is.readLine();
        if(input.length() == 0) {
          return null;
        }
      }
      catch(IOException e) {
    
        System.out.println("Exception: " + e);
      }
      return input;
    }
  }
  
  private static class Cell {
  
    private int pos_x;
    private int pos_y;
    private boolean alive = true;
    Cell(int x, int y) {

      pos_x = x;
      pos_y = y;
    }
  }
  
  private static class Ship {
  
    private List<Cell> cells = new ArrayList<Cell>();
    private boolean alive = false;

    public void addCell(int x, int y) {

      Cell c = new Cell(x, y);
      cells.add(c);
    }

    public int checkCell(int x, int y) {

      for(Cell c : cells) {
        if(c.pos_x == x && c.pos_y == y)
          if(c.alive) {
            return 1;
          } else {
            return 2;
          }
      }
      return 0;
    }

    public int hitCell(int x, int y) {

      for(Cell c : cells) {
        if(c.pos_x == x && c.pos_y == y)
          c.alive = false;
      }
      return 0;
    }
  }

  private static class Printer {

    public void print(Ship[] ships) {

      for(int y = 0; y < 5; y++) {

        for(int x = 0; x < 5; x++) {
          boolean found = false; 
          for(Ship s : ships) {

            if(s.checkCell(x,y) == 1) {
              found = true;
              System.out.print("o");
            } else if (s.checkCell(x,y) == 2) {
              found = true;
              System.out.print("x");
            }
          }
          if(!found) {
            System.out.print("~");
          }
        }
        System.out.println("");
      }
    }
  }

  public static void main( String[] args ) {

    InputHelper input = new InputHelper();

    // TODO: random generation of given number of ships (if possible)
    Ship[] ships = new Ship[3];
    ships[0] = new Ship();
    ships[1] = new Ship();
    ships[2] = new Ship();

    ships[0].addCell(1, 2);
    ships[0].addCell(2, 2);
    ships[0].addCell(3, 1);

    Printer p = new Printer();
    int num_moves = 0;
    int living = 3;

    while(living != 0) {
      String move = input.getUserInput();
      num_moves++;
      try {
        if(move.length() == 2) {
          int x = Integer.parseInt(Character.toString(move.charAt(0)));
          int y = Integer.parseInt(Character.toString(move.charAt(1)));
          boolean hit = false;
          for(Ship s : ships) {
            if(s.checkCell(x,y) == 1) {
              s.hitCell(x,y);
              System.out.println("hit");
              living--;
              hit = true;
              break;
            }
          }
          if(!hit)
            System.out.println("miss");
          p.print(ships);
        } else {
          System.out.println("ERROR: Invalid move. Should be two digits between 0 and 5");
        }
      } catch (Exception e) {
        System.out.println("ERROR: Invalid move. Should be two digits between 0 and 5");
      }
    }
    System.out.println("You completed the game in " + num_moves + " moves.");
  }
}
