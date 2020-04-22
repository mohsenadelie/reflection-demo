import java.lang.reflect.Field;

public class Main3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        System.out.println(a + " " + b);
        swap1(a, b);
        System.out.println(a + " " + b);

        swap2(a, b);
        System.out.println(a + " " + b);
    }

    public static void swap1(Integer a, Integer b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap2(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Integer temp = new Integer(a);
        Field f = Integer.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set(a, b);
        f.set(b, temp);
    }
}
