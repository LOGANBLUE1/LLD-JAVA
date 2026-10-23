package interviewProblems.uberRegister.register;

public interface IRegisterManager {
    void set(String register, int value);
    void inc(String register);
    void move(String register1, String register2);
    void dec(String register);
    void addR(String register1, String register2);
}
