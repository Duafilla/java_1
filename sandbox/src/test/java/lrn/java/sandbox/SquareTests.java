package lrn.java.sandbox;

import lrn.java1.sandbox.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test
  public void testArea() {
    Square s = new Square(5);
    Assert.assertEquals(s.area(), 25);
  }
}