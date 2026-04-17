// ==== COMPRESSED QUICK REFERENCE ====
// WHAT: Just signatures, fastest lookup
// WHEN: You know the pattern, need syntax reminder
// HOW: Find concept, copy line, paste

// ==== SCANNER ====
// Scanner sc = new Scanner(System.in);
// String s = sc.nextLine();
// int n = sc.nextInt(); sc.nextLine();  // clear buffer

// ==== BOOLEAN ====
// boolean flag = condition;
// if (flag && otherFlag) { }
// if (a > b || c < d) { }
// if (!flag) { }

// ==== STRING ====
// int len = str.length();
// boolean eq = str1.equals(str2);
// boolean has = str.contains("text");
// String sub = str.substring(5, 10);
// String up = str.toUpperCase();
// String[] parts = str.split(",");

// ==== ARRAY ====
// int[] arr = new int[10];
// String[] arr = {"a", "b", "c"};
// for (int i = 0; i < arr.length; i++) { }
// for (String s : arr) { }

// ==== ARRAYLIST ====
// ArrayList<String> list = new ArrayList<>();
// list.add("item");
// String s = list.get(0);
// list.set(0, "new");
// list.remove(0);
// int n = list.size();
// for (String s : list) { }
// boolean has = list.contains("x");

// ==== LOOPS ====
// for (int i = 0; i < n; i++) { }
// for (int i = n; i > 0; i--) { }
// while (condition) { }
// do { } while (condition);

// ==== SWITCH ====
// switch (val) {
//   case 1: break;
//   case 2: break;
//   default: break;
// }

// ==== CLASS ====
// public class Name {
//   private String field;
//   public Name(String f) { this.field = f; }
//   public String getField() { return field; }
//   public void setField(String f) { this.field = f; }
// }

// ==== INHERITANCE ====
// public class Child extends Parent {
//   public Child(String x) { super(x); }
//   @Override public void method() { super.method(); }
// }

// ==== STATIC ====
// private static int count = 0;
// public static int getCount() { return count; }
// Call: ClassName.getCount();

// ==== OVERLOAD ====
// public int add(int a, int b) { return a+b; }
// public int add(int a, int b, int c) { return a+b+c; }

// ==== ERROR HANDLING ====
// try {
//   int num = Integer.parseInt(str);
// } catch (NumberFormatException e) {
//   System.out.println("Invalid number");
// }
// try {
//   FileWriter fw = new FileWriter("file.txt");
// } catch (IOException e) {
//   System.out.println("File error: " + e.getMessage());
// }
// if (index >= 0 && index < arr.length) { arr[index] = val; }
// if (obj != null) { obj.method(); }

// ==== ABSTRACT CLASS ====
// public abstract class Shape {
//   protected String name;
//   public abstract double getArea();
//   public void print() { System.out.println(name); }
// }
// public class Circle extends Shape {
//   @Override public double getArea() { return Math.PI * r * r; }
// }

// ==== INTERFACE ====
// public interface Drawable {
//   void draw();
//   int MAX_SIZE = 100;
// }
// public class Box implements Drawable {
//   @Override public void draw() { }
// }

// ==== TYPE CHECKING ====
// if (obj instanceof Circle) { Circle c = (Circle) obj; }

// ==== WRAPPER CLASSES ====
// Integer num = 42;  // autoboxing
// int n = num;       // unboxing
// int x = Integer.parseInt("123");
// Integer a = 1000, b = 1000;
// a.equals(b)  // true
// a == b       // false (for values > 127)

// ==== 2D ARRAY ====
// int[][] grid = new int[3][4];
// int val = grid[row][col];
// for (int r=0; r<grid.length; r++) {
//   for (int c=0; c<grid[r].length; c++) { }
// }

// ==== FINAL ====
// public static final double PI = 3.14159;
// final String id;  // set in constructor, never change
// final class CannotExtend { }
// final void cannotOverride() { }

// ==== MAIN ====
// public static void main(String[] args) { }
