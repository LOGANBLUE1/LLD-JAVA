package interviewProblems.uberRegister.register;

public class Register {
    private String name;
    private int value;

    public Register(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void inc(){
        this.value++;
    }

    public void dec(){
        this.value--;
    }
}
