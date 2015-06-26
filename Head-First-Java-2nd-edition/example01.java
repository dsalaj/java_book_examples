
public class example01 {

  public static void main( String[] args ) {

    String[] first = {"aaaaa", "beba", "pr pr pr pr"};
    String[] second = {"BEBARAAA", "prc dorat zurik", "hheEEAJAA"};
    String[] third = {"iske", "HHaaaaaa", "majku jebla"};

    int firstIndex = (int) (Math.random() * first.length);
    int secondIndex = (int) (Math.random() * second.length);
    int thirdIndex = (int) (Math.random() * third.length);
    System.out.println(first[firstIndex] + " " + second[secondIndex] + " " + third[thirdIndex]);
  }
}
