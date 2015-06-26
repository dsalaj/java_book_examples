
public class example06 {

  public static boolean catcher() {

    System.out.println("CATCHER: I'm catching my exceptions!");
    try {
      boolean b = duck();
      return b;
    }
    catch(NewException e) {
      System.out.println("CATCHER: Caught it!");
      e.printStackTrace();
      return false;
    }
  }

  public static boolean duck() throws NewException {

    System.out.println("THROWER: I'm gonna throw and exception now!");
    if(true) {
      throw new NewException("THROWER: duck!");
    }
    return true;
  }

  public static void main(String[] args) throws NewException {

    boolean a = catcher();
    
    System.out.println("MAIN: I'm gonna duck!");
    boolean b = duck();

  }

  public static class NewException extends Exception {
    public NewException(String message) {
      super(message);
    }
  }
}
