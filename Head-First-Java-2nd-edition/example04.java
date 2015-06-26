
public class example04 {

  public static boolean sc() {

    System.out.println("After short circuit operator!");
    return true;
  }

  public static boolean nsc() {

    System.out.println("After non short circuit operator!");
    return true;
  }

  public static void main(String[] args) {

    if(true || sc())
    {
      //nothing here
    }
    if(true | nsc())
    {
      //nothing here
    }
    if(false && sc())
    {
      //nothing here
    }
    if(false & nsc())
    {
      //nothing here
    }
 
  }
}
