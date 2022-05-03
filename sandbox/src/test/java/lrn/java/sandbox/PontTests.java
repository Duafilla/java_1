package lrn.java.sandbox;

import lrn.java1.sandbox.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PontTests {
  @Test
  public void testDistance() {
    Point p1 = new Point(2, 3);
    Point p2 = new Point(6, 5);
    Assert.assertEquals(p2.distance(p1), 4.47213595499958);
  }
}
