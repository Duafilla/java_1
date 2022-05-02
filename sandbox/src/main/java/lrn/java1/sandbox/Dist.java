package lrn.java1.sandbox;

public class Dist {


    public static void main(String[] args) {
      Point p1 = new Point(2, 3);
      Point p2 = new Point(4, 5);


      System.out.println("Расстояние между точками А(" + p1.x + ";" + p1.y + ") и В( " + p2.y + ";" +
        p2.y + ") = " + p2.distance(p1));

    }
}
