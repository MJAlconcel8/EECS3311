public class B {

  static /*@ spec_public*/ int j,k;

  //@ requires i >= 0;
  //@ modifies j;
  //@ ensures j == i;
  public static void setj(int i) {
    k = i;
    return;
  }

  //@ ensures j == 1;
  public static void main(String[] args) {
    setj(3);
    return;
  }
}
