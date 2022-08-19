import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {2100, 20, 42000},
        {1111, 1003, 1114333}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {0, -3},
        {-3, 0},
        {0, 3},
        {0, 0}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
      int area = ExampleException.rectangleArea(a, b);
      assertEquals(area, c);
  }

  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a, b);
      fail();
    } catch (IllegalArgumentException ex) {
      assertEquals(ex.getMessage(), "Input value is below zero.");
    }
  }

  @Test(dataProvider = "negativeData", expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Input value is below zero.")
  public void testRectangleAreaNegativeCool(int a, int b) {
      ExampleException.rectangleArea(a, b);
  }
}