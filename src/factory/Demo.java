package factory;

public class Demo {
    void main(){
        var animal = Factory.getAnimal(3);
        animal.setType("Chocolate");
        animal.milk();
        System.out.println(animal.getMilkType());
    }
}
