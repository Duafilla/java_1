package lrn.java1.sandbox;


public class Dist {
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
  }
  public static void main(String[] args) {
    Point p1 = new Point(2, 3);

    Point p2 = new Point(4, 5);


    System.out.println("Расстояние между точками А(" + p1.x + ";" + p1.y + ") и В( " + p2.x + ";" +
      p2.y + ") = " + p1.distance(p2));

  }
}
