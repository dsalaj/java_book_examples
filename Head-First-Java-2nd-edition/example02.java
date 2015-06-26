
/*
  Java example 2
  Implementation of builder pattern to allow customizable construction of 
  GuessingGame with standard parameters
*/

public class example02 {

  public static void main( String[] args ) {

    if(args.length != 2) {

      System.out.println("Usage: java example2 #ofPlayers #maximalValueToGuess");
      System.exit(0);
    }
    GuessingGame game3 = new GuessingGame.Builder().setPlayers(Integer.parseInt(args[0]))
                                         .setMaxValue(Integer.parseInt(args[1])).build();
    game3.play();

  }
}

class GuessingGame {

  private int numOfPlayers;
  private int maxValue;
  private int goal;
  private boolean guessed = false;
  private Player[] players;

  public static class Builder {

    private int numOfPlayers = 2;
    private int maxValue = 10;

    public Builder setPlayers(int p) {

      numOfPlayers = p;
      return this;
    }
       
    public Builder setMaxValue(int v) {

      maxValue = v;
      return this;
    }

    public GuessingGame build() {

      return new GuessingGame(this);
    }

  }

  private GuessingGame(Builder builder) {
    numOfPlayers = builder.numOfPlayers;
    maxValue = builder.maxValue;
  }

  void play() {

    System.out.println("--------Starting Guessing Game");
    System.out.println("Number of players: " + numOfPlayers);
    System.out.println("Maximal value to guess: " + maxValue);

    goal = (int) (Math.random() * maxValue);
    System.out.println("Goal to guess is: " + goal);
    System.out.println("--------Players start");

    players = new Player[numOfPlayers];
    for(int i = 0; i < numOfPlayers; i++) {
      players[i] = new Player();
    }
  
    int winner = -1;
    while(checkForWinner() == -1) {

      letGuess();
      winner = checkForWinner();
    }
    System.out.println("The player P" + winner + " guessed the correct number");
    System.out.println("--------Guessing Game Finished");
  }

  void letGuess() {

    //for(int i = 0; i < numOfPlayers; i++) {
    int i = 0;
    for(Player p : players) {
      p.guess(maxValue);
      System.out.println("P" + i++ + " guess: " + p.guess);
      if(p.guess == goal) {
        p.won = true;
        break;
      }
    }
  }

  int checkForWinner() {

    for(int i = 0; i < numOfPlayers; i++) {
      if(players[i].won) {
        return i;
      }
    } 
    return -1;
  }
}

class Player {

  boolean won = false;
  int guess;
  void guess(int max) {

    guess = (int) (Math.random() * max);
  }
}
