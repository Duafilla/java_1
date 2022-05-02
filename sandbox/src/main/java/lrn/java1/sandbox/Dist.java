package lrn.java1.sandbox;

public class Dist {


  }

    public static void main(String[] args) {
      Point p1 = new Point();
      p1.x = 2;
      p1.y = 3;
      Point p2 = new Point();
      p2.x = 4;
      p2.y = 5;

      System.out.println("Расстояние между точками А(" + p1.x + ";" + p1.y + ") и В( " + p2.y + ";" +
        p2.y + ") = " + distance(p1, p2));

    }
}
