package lrn.java.sandbox;

import lrn.java1.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PontTests {
  @Test
  public void test1Distance() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(6, 5);
    Assert.assertEquals(p2.distance(p1), 4.47213595499958);
  }

  @Test
  public void test2Distance() {
    Point p1 = new Point(9, 9);
    Point p2 = new Point(10, 10);
    Assert.assertEquals(p2.distance(p1), 1.4142135623730951);
  }

  @Test
  public void test3Distance() {
    Point p1 = new Point(22, 23);
    Point p2 = new Point(10, 10);
    Assert.assertEquals(p2.distance(p1), 17.69180601295413);
  }
}
