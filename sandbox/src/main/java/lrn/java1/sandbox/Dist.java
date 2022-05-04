package lrn.java1.sandbox;

public class Dist {


    public static void main(String[] args) {
      Point p1 = new Point(22, 23);
      Point p2 = new Point(10, 10);


      System.out.println("Расстояние между точками А(" + p1.x + ";" + p1.y + ") и В( " + p2.x + ";" +
        p2.y + ") = " + p2.distance(p1));

    }
}
