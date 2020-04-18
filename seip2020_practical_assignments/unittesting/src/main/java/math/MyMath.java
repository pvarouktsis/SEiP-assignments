package math;

public class MyMath {

  public int factorial(int x) {
    if (x < 0) {
      throw new IllegalArgumentException("Expected x >= 0");
    } else if (x > 12) {
      throw new IllegalArgumentException("Integer output out of bounds");
    } else {
      if (x == 0) {
        return 1;
      } else {
        return x * factorial(x-1);
      }
    }
  }

}
