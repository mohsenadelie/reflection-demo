import mypackage.Person;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
//        Class x = Person.class;
        Class<?> y = Class.forName("mypackage.Person");

//        System.out.println(x.getName());
        System.out.println(y.getSimpleName());

        Person mohsen = new Person("adeli");
//        mohsen.getClass() == Person.class

//        Method[] methods = y.getMethods();
//        for (Method m:methods) {
//            System.out.println(m);
//        }
//        System.out.println(Arrays.toString(methods));

        Method[] decMethods = y.getDeclaredMethods();
        for (Method m : decMethods) {
            System.out.println(m);
        }

        Method sayHello = y.getMethod("sayHello", String.class);
        Object obj = sayHello.invoke(mohsen, "Ali");
//        System.out.println(obj.toString());
        System.out.println("-----------------------");
        Method sleep = y.getDeclaredMethod("sleep", Integer.class);
        int num = 30000;
        sleep.setAccessible(true);
        Object out = sleep.invoke(mohsen, num);
        System.out.println(out.toString());

        Method addPerson = y.getMethod("addPerson", null);
        Object staticObj = addPerson.invoke(null);
        System.out.println(Person.number);

        Field f = y.getDeclaredField("name");
        f.setAccessible(true);
        f.set(mohsen, "asadi");
        System.out.println(mohsen.getName());
    }
}
