package mypackage;


public class Person implements Cloneable {

    @Inject(values = "ali")
    private String name;


    public String getName() {
        return name;
    }



    public static int number;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void sayHello(String otherName) {
        System.out.println("Hello " + otherName);
    }

    public static void addPerson() {
        number++;
    }

    private String sleep(Integer time) {
        return "sleep for " + time;
    }

    @Override
    public String toString() {
        return name;
    }
}
