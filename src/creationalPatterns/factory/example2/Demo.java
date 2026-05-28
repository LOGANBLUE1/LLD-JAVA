package creationalPatterns.factory.example2;

public class Demo {
    void main(){
        var animal = Factory.getAnimal(4);
        animal.setType("Chocolate");
        animal.milk();
        System.out.println(animal.getMilkType());
    }
}
