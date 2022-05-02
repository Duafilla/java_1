package lrn.java1.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double p) {
    this.p1 = p
  }
  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.y - p1.x) * (p2.y - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));


}
