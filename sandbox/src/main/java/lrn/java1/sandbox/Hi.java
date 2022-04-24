package lrn.java1.sandbox;

public class Hi {

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Kirill");

    double l = 5;
    System.out.println("Ploshad kvadrata so storonoi " + l + " = " + area(l));

    double a = 5;
    double b = 6;
    System.out.println("Ploshad pryamougolnika so storonami " + a + " i " + b + " = " + area(a, b));
  }

}
