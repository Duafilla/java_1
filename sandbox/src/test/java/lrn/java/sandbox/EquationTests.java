package lrn.java.sandbox;

import lrn.java1.sandbox.Equation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {
  @Test
    public void test0() {
    Equation e = new Equation(1, 1, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void test1() {
    Equation e = new Equation(2, 4, 2);
    Assert.assertEquals(e.rootNumber(), 1);
  }

  @Test
  public void test2() {
    Equation e = new Equation(2, 6, 2);
    Assert.assertEquals(e.rootNumber(), 2);
  }

  @Test
  public void testLinear() {
    Equation e = new Equation(0, 0, 0);
    Assert.assertEquals(e.rootNumber(), -1);
  }

  @Test
  public void testConstant() {
    Equation e = new Equation(0, 0, 2);
    Assert.assertEquals(e.rootNumber(), 0);
  }

  @Test
  public void testZero() {
    Equation e = new Equation(0, 6, 2);
    Assert.assertEquals(e.rootNumber(), 1);
  }
}
