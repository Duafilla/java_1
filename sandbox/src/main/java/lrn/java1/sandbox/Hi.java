package lrn.java1.sandbox;

public class Hi {

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

  public static double area(Rectangle r) {

    return r.a * r.b;

  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Kirill");

    Square s = new Square(5);
    System.out.println("Ploshad kvadrata so storonoi " + s.l + " = " + s.area());

    Rectangle r = new Rectangle();
    r.a = 5;
    r.b = 6;
    System.out.println("Ploshad pryamougolnika so storonami " + r.a + " i " + r.b + " = " + area(r));
  }

}
