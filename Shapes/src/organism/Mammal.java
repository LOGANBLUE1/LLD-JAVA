package organism;

import lombok.Data;

@Data
public class Mammal implements Animal{

    @Override
    public void eat() {
        new Exception("Method not implemented in organism.Mammal class.");
    }

    @Override
    public void move() {
        new Exception("Method not implemented in organism.Mammal class.");
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void breathe() {
        new Exception("Method not implemented in organism.Mammal class.");
    }

    @Override
    public void sleep() {
        new Exception("Method not implemented in organism.Mammal class.");
    }
}
