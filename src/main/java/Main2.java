import mypackage.Inject;
import mypackage.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main2 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class p = Person.class;

        Constructor x = p.getConstructors()[0];

        Class[] cls = x.getParameterTypes();
        Object[] objs = new Object[cls.length];
        Person p1 = (Person) x.newInstance(objs);
        Field[] fs = p.getDeclaredFields();
        for (Field f : fs) {
            Annotation[] ann = f.getAnnotations();
            for (Annotation a : ann) {
                if (a.annotationType().equals(Inject.class)){
                    Inject i = f.getAnnotation(Inject.class);
                    String str = i.values()[0];
                    f.setAccessible(true);
                    f.set(p1,str);
                }
            }
        }
        System.out.println(p1.toString());
    }
}
