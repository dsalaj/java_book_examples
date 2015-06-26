
class example05 {

  public static void main(String[] args) {

    String s = String.format("The answer is %,2.0f and not %d", 1200042.1234 % 12000, '*' + 1);
    System.out.println(s);
  }
}
