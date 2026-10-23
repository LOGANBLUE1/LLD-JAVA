package interviewProblems.uberRegister.register;

import interviewProblems.uberRegister.exception.RegisterNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class RegisterManager implements IRegisterManager {
    Map<String, Register> registers;
    public RegisterManager() {
        registers = new HashMap();
    }

    public void createRegister(String register) {
        validateRegisterName(register);
        registers.put(register, new Register(register));
    }

    private void validateRegisterExists(String register) {
        if (!registers.containsKey(register)) {
            throw new RegisterNotFoundException("Register " + register + " does not exist");
        }
    }

    private void validateRegisterName(String register) {
        if (register == null || register.trim().isEmpty()) {
            throw new IllegalArgumentException("Register name cannot be null or empty");
        }
    }

    private void validateRegister(String register) {
        this.validateRegisterName(register);
        this.validateRegisterExists(register);
    }

    public Register getRegister(String register) {
        this.validateRegister(register);
        return this.registers.get(register);
    }

    public int getValue(String register) {
        return this.getRegister(register).getValue();
    }

    @Override
    public void set(String register, int value) {
        this.validateRegister(register);
        registers.get(register).setValue(value);
    }

    @Override
    public void inc(String register) {
        this.getRegister(register).inc();
    }

    @Override
    public void move(String register1, String register2) {
        this.set(register1, getValue(register2));
    }

    @Override
    public void dec(String register) {
        this.getRegister(register).dec();
    }

    @Override
    public void addR(String register1, String register2) {
        this.set(register1,
                getValue(register1) + getValue(register2));
    }
}
