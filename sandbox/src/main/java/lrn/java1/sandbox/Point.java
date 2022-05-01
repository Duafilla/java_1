package lrn.java1.sandbox;

public class Point {
  public double x1;
  public double x2;
  public double y1;
  public double y2;

  public void p1(double x1, double y1) {
    this.x1 = x1;
    this.y1 = y1;
  }

  public void p2(double x2, double y2) {
    this.x2 = x2;
    this.y2 = y2;
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.x2 - p1.x1) * (p2.x2 - p1.x1)) + ((p2.y2 - p1.y1) * (p2.y2 - p1.y1)));
  }

  public static void main(String[] args) {
    Point p1 = new Point();
    p1.x1 = 2;
    p1.y1 = 3;
    Point p2 = new Point();
    p2.x2 = 4;
    p2.y2 = 5;

    System.out.println("Расстояние между точками А(" + p1.x1 + ";" + p1.y1 + ") и В( " + p2.x2 + ";" +
      p2.y2 + ") = " + distance(p1, p2));

  }
}
