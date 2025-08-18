public class Person{
    private String name;
    private int age;
    private int salary;


    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, int salary) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.salary = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }
    public Person setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
        return this;
    }

    public Person setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}
